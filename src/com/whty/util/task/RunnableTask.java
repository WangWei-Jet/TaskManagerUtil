package com.whty.util.task;

import android.os.AsyncTask;

public abstract class RunnableTask extends AsyncTask<Object, Integer, Boolean> {

	private TaskManager taskManager;
	private String taskIdentifier;
	// private Runnable task;
	private boolean taskRunOver = false;
	private boolean taskRunning = false;
	private String tag = RunnableTask.class.getSimpleName();

	// private Handler handler;

	public RunnableTask(TaskManager taskManager) {
		super();
		this.taskManager = taskManager;
		// this.task = task;
	}

	public RunnableTask(TaskManager taskManager, String taskIdentifier) {
		super();
		this.taskManager = taskManager;
		// this.task = task;
		// this.taskIdentifier = taskIdentifier;
		setName(taskIdentifier);
	}

	private void setName(String taskIdentifier) {
		this.taskIdentifier = taskIdentifier;
		LogManager.printLog("d", tag, "��������:" + this.taskIdentifier);
	}

	public String getName() {
		return this.taskIdentifier;
	}

	private void runBefore() {
		taskRunning = true;
		LogManager.printLog("d", tag, "����<" + this.taskIdentifier + ">��ʼִ��");
	}

	private void runAfter() {
		taskRunning = false;
		taskRunOver = true;
		LogManager.printLog("d", tag, "����<" + this.taskIdentifier + ">ִ�н���");
		// taskManager.onCurrentTaskFinished();
	}

	@Override
	protected abstract Boolean doInBackground(Object... params);

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		runBefore();
	}

	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		runAfter();
		if (taskManager != null)
			taskManager.onCurrentTaskFinished(result);
		else {
			LogManager
					.printLog("w", tag, "��ǰ����δ������������������н������޷�֪ͨ�����������������һ������");
		}
	}

	public boolean isTaskRunning() {
		return taskRunning;
	}

	public boolean isTaskRunOver() {
		return taskRunOver;
	}
}
