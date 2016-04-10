package com.lige.task;

import java.io.File;

import com.lige.utils.FileUtils;

public class Task {

	// ��ͳ�Ƶ��ļ���
	private File dir;
	// �ܹ�����
	private static int count = 0;

	public Task(File dir) {
		this.dir = dir;
	}

	/**
	 * �������� �������ļ����е��������ļ������ļ��У�<br>
	 * ������ļ�����ͳ��������<br>
	 * ������ļ��У�����Ϊ�µ�����ŵ��������β
	 * 
	 */
	public void execute() {
		System.out.println(Thread.currentThread() + "====>" + dir.getPath());
		// ִ��ͳ�Ʋ���
		for (File file : dir.listFiles()) {
			// �ж����ļ�������Java�ļ�
			if (file.isFile() && file.getName().endsWith(".java")) {
				synchronized (Task.class) {
					// ���̲߳���һ����������Ҫ����
					count += FileUtils.getLineConnt(file);
				}
			}
			// ������ļ��У�����ӵ�����β
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
