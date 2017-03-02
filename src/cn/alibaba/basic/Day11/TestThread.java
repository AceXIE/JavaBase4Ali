package cn.alibaba.basic.Day11;

class Demo extends Thread {

	// private String name;
	public Demo(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println(Thread.currentThread().getName() + " Demo Run~"
					+ i);
		}
	}

}

public class TestThread {

	public static void main(String[] args) {
		Demo d = new Demo("Thread 1");// 创建线程
		Demo d1 = new Demo("Thread 2");
		d.start();// 执行线程
		d1.start();

		for (int i = 0; i < 30; i++) {
			System.out.println("main : " + i);
		}
	}

}
