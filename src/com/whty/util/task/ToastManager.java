package com.whty.util.task;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;

public class ToastManager {

	private static Toast pToast;
	private static String tag = ToastManager.class.getSimpleName();

	public static void showToast(Context context, String content, int duration) {
		if (pToast == null) {
			LogManager.printLog("d", tag, "创建toast实例");
			pToast = Toast.makeText(context.getApplicationContext(), "",
					Toast.LENGTH_SHORT);
		}
		int androidVer = Integer.valueOf(Build.VERSION.RELEASE.substring(0, 1));

		// Android 2.X版本不会自动清Toast，这里要清一下，不然多个Toast一起显示时，会排队显示好久。
		if (androidVer == 2) {
			pToast.cancel();
		}
		pToast.setText(content);
		pToast.setDuration(duration);
		pToast.show();
	};
}
