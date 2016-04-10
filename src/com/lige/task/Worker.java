package com.lige.task;

/**
 * 此类是执行任务线程
 * @author zzq_eason
 *
 */
public class Worker extends Thread {

	/**
	 * 工作线程：<br>
	 * 从队伍队列中取出任务并且执行 如果没有任务，则进行等待，知道全部任务都执行完
	 */
	@Override
	public void run() {
		System.out.println("启动的当前线程： " + this);
		while (true) {
			Task task = TaskQueue.removeHead();
			// 如果队列中有任务则执行，否则执行等待
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
