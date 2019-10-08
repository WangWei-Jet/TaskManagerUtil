package com.whty.util.task;

import android.util.Log;

public class LogManager {
	private static boolean allowLogOut = false;

	public static void permitLogOut(boolean logOutStatus) {
		allowLogOut = logOutStatus;
	}

	public static boolean isLogOutPermitted() {
		return allowLogOut;
	}

	public static void printLog(String logLevel, String logTag, String logInfo) {
		if (isLogOutPermitted()) {
			if (logLevel.equalsIgnoreCase("i")) {
				Log.i(logTag, logInfo);
			} else if (logLevel.equalsIgnoreCase("d")) {
				Log.d(logTag, logInfo);
			} else if (logLevel.equalsIgnoreCase("w")) {
				Log.w(logTag, logInfo);
			} else if (logLevel.equalsIgnoreCase("e")) {
				Log.e(logTag, logInfo);
			}
		}
	}
}
