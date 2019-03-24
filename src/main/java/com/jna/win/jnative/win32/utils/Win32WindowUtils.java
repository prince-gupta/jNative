package com.jna.win.jnative.win32.utils;

import com.jna.win.jnative.utils.WindowUtils;
import com.jna.win.jnative.win32.lib.User32;
import com.sun.jna.platform.win32.WinDef.HWND;

public final class Win32WindowUtils implements WindowUtils {
	private static final int WIN_TITLE_MAX_SIZE = 512;

	public static HWND getWindowHandle(String strSearch, String strClass) {
		return getWindowHandle(strSearch, strClass, null);
	}

	public static HWND getWindowHandle(String strSearch, String strClass, StringMatchStrategy strategy) {
		char[] lpString = new char[WIN_TITLE_MAX_SIZE];
		String strTitle;
		HWND hWnd = User32.INSTANCE.FindWindow(strClass, null);
		HWND match = null;
		while(hWnd != null) {
			for(int i = 0; i < lpString.length; ++i) {
				lpString[i] = ' ';
			}
			User32.INSTANCE.GetWindowText(hWnd, lpString, WIN_TITLE_MAX_SIZE);
			strTitle = new String(lpString).trim();
			if(strategy == null && strTitle.equals(strSearch.trim())) {
				match = hWnd;
				break;
			}
			else if(strategy != null && strategy.isMatched(strTitle)) {
				match = hWnd;
				break;
			}
			hWnd = User32.INSTANCE.FindWindowEx(null, hWnd, strClass, null);
		}
		return match;
	}

	@Override
	public boolean windowExists(StringMatchStrategy strategy) {
		HWND hwnd = getWindowHandle(null, null, strategy);
		return hwnd != null;
	}

	@Override
	public boolean windowExists(String windowTitle) {
		HWND hwnd = getWindowHandle(windowTitle, null);
		return hwnd != null;
	}

	@Override
	public HWND getWindowHandler(StringMatchStrategy strategy) {
		return getWindowHandle(null, null, strategy);
	}

	@Override
	public void maximizeWindow(String windowTitle) {
		HWND hWnd = getWindowHandle(windowTitle, null);
		User32.INSTANCE.ShowWindow(hWnd, 3);
	}

	@Override
	public void switchToWindow(String windowTitle) {
		HWND hWnd = getWindowHandle(windowTitle, null);
        User32.INSTANCE.SwitchToThisWindow(hWnd, false);
	}

	@Override
	public void setForegroundWindow(String windowTitle) {
		HWND hWnd = getWindowHandle(windowTitle, null);
		User32.INSTANCE.SetActiveWindow(hWnd);
		User32.INSTANCE.SetForegroundWindow(hWnd);
	}
}
