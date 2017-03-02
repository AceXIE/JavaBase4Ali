package cn.alibaba.basic.Day11;

/**
 * 多线程，多线程卖票程序
 *
 * @author xiekai
 *
 */

class Ticket implements Runnable {

	private int ticketNum = 100;
	Object obj = new Object();

	public void run() {
		while (true) {
			show();
		}
	}

	public synchronized void show() {
		if (ticketNum > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "sale:"
					+ ticketNum--);
		}
	}

}

public class SaleTickets {

	public static void main(String[] args) {
		Ticket t = new Ticket();
		Thread td = new Thread(t);
		Thread td1 = new Thread(t);
		Thread td2 = new Thread(t);
		Thread td3 = new Thread(t);

		td.start();
		td1.start();
		td2.start();
		td3.start();

		// Ticket t1 = new Ticket();
		// Ticket t2 = new Ticket();
		// Ticket t3 = new Ticket();
		// Ticket t4 = new Ticket();
		//
		// t1.start();
		// t2.start();
		// t3.start();
		// t4.start();
	}

}
