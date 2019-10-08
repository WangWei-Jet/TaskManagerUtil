package com.whty.util.task;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskManager {

	private ConcurrentLinkedQueue<RunnableTask> taskQueue = new ConcurrentLinkedQueue<RunnableTask>();
	private ExecutorService es = Executors.newSingleThreadExecutor();

	private RunnableTask currenttask;
	private int taskCounter = 0;
	private boolean isTaskRunning = false;
	private String tag = TaskManager.class.getSimpleName();

	public void addTask(RunnableTask task) {
		if (taskQueue == null) {
			taskQueue = new ConcurrentLinkedQueue<RunnableTask>();
		}
		taskQueue.add(task);
	}

	private void startTaskQueue() {
		if (taskQueue == null || taskQueue.size() == 0) {
			if (taskCounter == 0)
				LogManager.printLog("d", tag, "任务队列当前无任务");
			else {
				onAllTaskFinished();
			}
			return;
		}
		currenttask = taskQueue.poll();
		if (currenttask == null) {
			LogManager.printLog("d", tag, "从任务队列获取任务失败");
			return;
		}
		LogManager.printLog("d", tag, "准备执行任务:" + currenttask.getName());
		isTaskRunning = true;
		currenttask.executeOnExecutor(es);
	}

	public void onCurrentTaskFinished(boolean executeResult) {
		taskCounter++;
		startTaskQueue();
	};

	public void runTaskQueue() {
		if (isTaskRunning) {
			LogManager.printLog("d", tag, "任务队列已有任务正在运行");
			return;
		}
		startTaskQueue();
	}

	public void forceContinueTaskQueue() {
		if (currenttask == null) {
			LogManager.printLog("e", tag, "任务队列未执行");
			return;
		}
		if (currenttask.isTaskRunning()) {
			LogManager.printLog("e", tag, "任务队列当前有任务正在运行");
			return;
		}
		if (currenttask.isTaskRunOver()) {
			LogManager.printLog("e", tag, "强制继续运行任务队列");
			isTaskRunning = false;
			startTaskQueue();
		}
	}

	public void onAllTaskFinished() {
		isTaskRunning = false;
		LogManager.printLog("d", tag, "任务队列所有任务执行完毕");
	}

	public int getRemainedTaskNumber() {
		if (taskQueue != null)
			return taskQueue.size();
		return 0;
	}

}
