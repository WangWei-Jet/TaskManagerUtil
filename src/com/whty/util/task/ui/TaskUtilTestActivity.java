package com.whty.util.task.ui;

import android.app.Activity;

public class TaskUtilTestActivity extends Activity {

	// private Button startTaskQueue;
	// private TaskManager taskManager = null;
	// private MyHandler mHandler;
	// private static final int TASKONE_RUNNING = 111;
	// private static final int TASKTWO_RUNNING = 211;
	// private String tag = TaskUtilTestActivity.class.getSimpleName();
	//
	// @Override
	// protected void onCreate(Bundle savedInstanceState) {
	// // TODO Auto-generated method stub
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.task_util_test_activity);
	// startTaskQueue = (Button) findViewById(R.id.startTaskQueue);
	// startTaskQueue.setOnClickListener(new OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	// // TODO Auto-generated method stub
	// taskManager.runTaskQueue();
	// }
	// });
	// mHandler = new MyHandler(getParent());
	// LogManager.permitLogOut(true);
	// LogManager.printLog("d", tag, "onCreate");
	// taskManager = new TaskManager();
	// RunnableTask taskOne = new RunnableTask(taskManager, "taskOne") {
	//
	// @Override
	// protected Boolean doInBackground(Object... params) {
	// // TODO Auto-generated method stub
	// LogManager.printLog("d", tag, this.getName() + " is running!");
	// mHandler.obtainMessage(TASKONE_RUNNING).sendToTarget();
	// try {
	// Thread.sleep(1500);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return true;
	// }
	// };
	// RunnableTask taskTwo = new RunnableTask(taskManager, "taskTwo") {
	//
	// @Override
	// protected Boolean doInBackground(Object... params) {
	// // TODO Auto-generated method stub
	// LogManager.printLog("d", tag, this.getName() + " is running!");
	// mHandler.obtainMessage(TASKTWO_RUNNING).sendToTarget();
	// try {
	// Thread.sleep(1500);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return true;
	// }
	// };
	// taskManager.addTask(taskOne);
	// taskManager.addTask(taskTwo);
	// // taskManager.startTaskQueue();
	//
	// }
	//
	// @Override
	// protected void onResume() {
	// // TODO Auto-generated method stub
	// super.onResume();
	// }
	//
	// @Override
	// protected void onPause() {
	// // TODO Auto-generated method stub
	// super.onPause();
	// }
	//
	// @Override
	// protected void onDestroy() {
	// // TODO Auto-generated method stub
	// super.onDestroy();
	// }
	//
	// private static class MyHandler extends Handler {
	// private WeakReference<Activity> activity;
	//
	// public MyHandler(Activity activity) {
	// super();
	// this.activity = new WeakReference<Activity>(activity);
	// }
	//
	// @Override
	// public void dispatchMessage(Message msg) {
	// // TODO Auto-generated method stub
	// super.dispatchMessage(msg);
	// switch (msg.what) {
	// case TASKONE_RUNNING:
	// if (activity.get() != null) {
	// ToastManager.showToast(activity.get(),
	// "taskOne is running now", 1200);
	// }
	// break;
	// case TASKTWO_RUNNING:
	// if (activity.get() != null) {
	// ToastManager.showToast(activity.get(),
	// "taskTwo is running now", 1200);
	// }
	// break;
	//
	// default:
	// break;
	// }
	// }
	// }

}
