package com.whty.util.task;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;

public class ToastManager {

	private static Toast pToast;
	private static String tag = ToastManager.class.getSimpleName();

	public static void showToast(Context context, String content, int duration) {
		if (pToast == null) {
			LogManager.printLog("d", tag, "����toastʵ��");
			pToast = Toast.makeText(context.getApplicationContext(), "",
					Toast.LENGTH_SHORT);
		}
		int androidVer = Integer.valueOf(Build.VERSION.RELEASE.substring(0, 1));

		// Android 2.X�汾�����Զ���Toast������Ҫ��һ�£���Ȼ���Toastһ����ʾʱ�����Ŷ���ʾ�þá�
		if (androidVer == 2) {
			pToast.cancel();
		}
		pToast.setText(content);
		pToast.setDuration(duration);
		pToast.show();
	};
}
