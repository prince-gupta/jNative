package com.jna.win.jnative.utils;

import com.jna.win.jnative.exception.NotImplementedException;
import com.jna.win.jnative.win32.utils.Win32WindowUtils;
import com.sun.jna.Platform;

public final class NativeUtilsFactory {

	private NativeUtilsFactory() {

	}

	public static WindowUtils getWindowUtils() {
		switch(Platform.getOSType()) {
			case Platform.WINDOWS:
				return new Win32WindowUtils();
			case Platform.LINUX:
				throw new NotImplementedException("WindowUtils isn't implemented for LINUX platform yet");
			case Platform.MAC:
				throw new NotImplementedException("WindowUtils isn't implemented for MAC platform yet");
			default:
				throw new NotImplementedException("WindowUtils isn't implemented for platform code: "
						+ Platform.getOSType() + " yet");
		}
	}
}
