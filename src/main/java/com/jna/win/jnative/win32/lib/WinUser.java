package com.jna.win.jnative.win32.lib;

import com.sun.jna.Structure;

public interface WinUser extends com.sun.jna.platform.win32.WinUser {
	public static final int MAX_PATH = 260;

	public static class ICONINFOEX extends Structure {
		public DWORD cbSize;
		public boolean fIcon;
		public DWORD xHotspot;
		public DWORD yHotspot;
		public HBITMAP hbmMask;
		public HBITMAP hbmColor;
		public WORD wResID;
		public char szModName[] = new char[MAX_PATH];
		public char szResName[] = new char[MAX_PATH];
	}

	public static class CURSORINFO extends Structure {
		public DWORD cbSize;
		public DWORD flags;
		public HCURSOR hCursor;
		public POINT ptScreenPos;
	}
}
