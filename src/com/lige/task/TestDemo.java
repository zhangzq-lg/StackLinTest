package com.lige.task;

import java.io.File;

public class TestDemo {

	public static void main(String[] args) {
		// 初始一个任务（根目录）
		String path = "D:/Eclipse/JavaSpace/";
		Task task = new Task(new File(path));
		TaskQueue.addToTail(task);
		// 开始多线程执行
		for (int i = 0; i < 5; i++) {
			new Worker().start();
		}

		// 查看结果
		try {
			Thread.sleep(8000);
			System.out.println(Task.getCount());
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
