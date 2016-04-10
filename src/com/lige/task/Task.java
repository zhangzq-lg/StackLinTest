package com.lige.task;

import java.io.File;

import com.lige.utils.FileUtils;

public class Task {

	// 待统计的文件夹
	private File dir;
	// 总共条数
	private static int count = 0;

	public Task(File dir) {
		this.dir = dir;
	}

	/**
	 * 办理任务： 遍历本文件夹中的所有子文件和子文件夹，<br>
	 * 如果是文件，就统计行数。<br>
	 * 如果是文件夹，就作为新的任务放到任务队列尾
	 * 
	 */
	public void execute() {
		System.out.println(Thread.currentThread() + "====>" + dir.getPath());
		// 执行统计操作
		for (File file : dir.listFiles()) {
			// 判断是文件，且是Java文件
			if (file.isFile() && file.getName().endsWith(".java")) {
				synchronized (Task.class) {
					// 多线程操作一个变量，需要加锁
					count += FileUtils.getLineConnt(file);
				}
			}
			// 如果是文件夹，则添加到队列尾
			else if (file.isDirectory()) {
				Task task = new Task(file);
				TaskQueue.addToTail(task);
			}
		}
	}

	public static int getCount() {
		return count;
	}

}
