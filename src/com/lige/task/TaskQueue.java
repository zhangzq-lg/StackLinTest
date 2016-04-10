package com.lige.task;

import java.util.LinkedList;

/**
 * ע����̷߳��ʹ�ͬ�ı�����Ҫ����
 * 
 * @author zzq_eason
 *
 */
public class TaskQueue {

	// ����һ���������Ķ���
	private static LinkedList<Task> queue = new LinkedList<Task>();

	/**
	 * �Ӷ�β������� <br>
	 * synchronized����Ϊ��ÿ���̵߳���ִ�������ӣ���Ȼ�����
	 * 
	 * @param task
	 */

	public static synchronized void addToTail(Task task) {
		queue.addLast(task);
	}

	/**
	 * �Ӷ��е�ͷ����ȡ�������<br>
	 * ��������������ȡ����û���򷵻�null <br>
	 * �˴�Ҳ��һ������֤ÿ���̶߳���ȡ���ǵ���������<br>
	 * ������ͬһ�����������߳�ִ��
	 * 
	 * @return
	 */
	public static synchronized Task removeHead() {
		if (queue.size() > 0) {
			return queue.removeFirst();
		} else {
			return null;
		}
	}

}
