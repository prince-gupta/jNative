package com.jna.win.jnative.win32.lib;

import com.sun.jna.IntegerType;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.win32.W32APIOptions;

public interface User32 extends com.sun.jna.platform.win32.User32 {

	User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

	HWND GetParent(HWND hWnd);

	HWND FindWindowEx(HWND hwndParent, HWND hwndChildAfter, String lpszClass, String lpszWindow);

	boolean SetLayeredWindowAttributes(HWND hwnd, int crKey, int bAlpha, int dwFlags);

	public static class ULONG_PTR extends IntegerType {
		public ULONG_PTR() {
			this(0);
		}

		public ULONG_PTR(long value) {
			super(Pointer.SIZE, value);
		}
	}

	public static class KBDLLHOOKSTRUCT extends Structure {
		public int vkCode;
		public int scanCode;
		public int flags;
		public int time;
		public ULONG_PTR dwExtraInfo;
	}

	void GetClientRect(HWND hwnd, RECT rcClient);

	HWND SetActiveWindow(HWND hWnd);

	void SwitchToThisWindow(HWND hWnd, boolean byAltTab);

	/** http://msdn.microsoft.com/en-us/library/ms648391(VS.85).aspx */
	public Pointer LoadCursorW(Pointer hInstance, int lpCursorName);

	/** http://msdn.microsoft.com/en-us/library/ms648065(VS.85).aspx */
	public boolean DrawIconEx(Pointer hdc, int xLeft, int yTop, Pointer hIcon, int cxWidth, int cyWidth,
                              int istepIfAniCur, Pointer hbrFlickerFreeDraw, int diFlags);

	public boolean DrawIcon(HDC hDC, int x, int y, HICON hIcon);


	public boolean GetIconInfoEx(HICON hIcon, Pointer pointer);
}
