package com.lige.task;

import java.util.LinkedList;

/**
 * 注意多线程访问共同的变量需要加锁
 * 
 * @author zzq_eason
 *
 */
public class TaskQueue {

	// 定义一个存放任务的队列
	private static LinkedList<Task> queue = new LinkedList<Task>();

	/**
	 * 从队尾添加数据 <br>
	 * synchronized，是为了每个线程单独执行这个添加，不然会混乱
	 * 
	 * @param task
	 */

	public static synchronized void addToTail(Task task) {
		queue.addLast(task);
	}

	/**
	 * 从队列的头部获取任务对象<br>
	 * 如果有任务则进行取出，没有则返回null <br>
	 * 此处也是一样，保证每个线程都获取的是单独的任务，<br>
	 * 而不是同一个任务给多个线程执行
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
