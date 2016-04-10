package com.lige.task;

import java.io.File;

public class TestDemo {

	public static void main(String[] args) {
		// ��ʼһ�����񣨸�Ŀ¼��
		String path = "D:/Eclipse/JavaSpace/";
		Task task = new Task(new File(path));
		TaskQueue.addToTail(task);
		// ��ʼ���߳�ִ��
		for (int i = 0; i < 5; i++) {
			new Worker().start();
		}

		// �鿴���
		try {
			Thread.sleep(8000);
			System.out.println(Task.getCount());
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
