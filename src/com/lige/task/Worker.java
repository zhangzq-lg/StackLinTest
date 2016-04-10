package com.lige.task;

/**
 * ������ִ�������߳�
 * @author zzq_eason
 *
 */
public class Worker extends Thread {

	/**
	 * �����̣߳�<br>
	 * �Ӷ��������ȡ��������ִ�� ���û����������еȴ���֪��ȫ������ִ����
	 */
	@Override
	public void run() {
		System.out.println("�����ĵ�ǰ�̣߳� " + this);
		while (true) {
			Task task = TaskQueue.removeHead();
			// �����������������ִ�У�����ִ�еȴ�
			if (task != null) {
				task.execute();
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			
		}
	}

}
