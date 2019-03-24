package com.jna.win.jnative.utils;

import com.sun.jna.platform.win32.WinDef.HWND;

public interface WindowUtils {

	public static interface StringMatchStrategy {
		boolean isMatched(String string);
	}

	void maximizeWindow(String windowTitle);

	boolean windowExists(String windowTitle);

	boolean windowExists(StringMatchStrategy strategy);

	HWND getWindowHandler(StringMatchStrategy strategy);

	void switchToWindow(String windowTitle);

	void setForegroundWindow(String windowTitle);
}
