package cn.alibaba.basic.Day12;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resc {
	private String name;
	private int count = 1;
	private boolean flag = false;

	private Lock lock = new ReentrantLock();
	private Condition condition_pro = lock.newCondition();
	private Condition condition_cus = lock.newCondition();

	public void set(String name) throws InterruptedException {
		lock.lock();

		try {
			while (flag) {
				condition_pro.await();
			}
			this.name = name + "--" + count;
			count++;
			System.out.println(Thread.currentThread().getName() + "生产..."
					+ this.name);
			flag = true;
			condition_cus.signal();
		} finally {
			lock.unlock();
		}

		// this.notify();
	}

	public void out() throws InterruptedException {
		lock.lock();
		try {

			while (!flag) {
				condition_cus.await();
			}
			System.out.println(Thread.currentThread().getName() + "消费..."
					+ this.name);
			flag = false;
			condition_pro.signalAll();

		} finally {
			lock.unlock();
		}
	}

}

class Producer implements Runnable {
	private Resc resc;

	Producer(Resc r) {
		this.resc = r;
	}

	public void run() {
		while (true) {
			try {
				resc.set("商品");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Customer implements Runnable {
	private Resc resc;

	Customer(Resc r) {
		this.resc = r;
	}

	public void run() {
		while (true) {
			try {
				resc.out();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class TestCustom {

	public static void main(String[] args) {
		Resc r = new Resc();

		Producer pd = new Producer(r);
		Customer ct = new Customer(r);

		Thread t1 = new Thread(pd);
		Thread t2 = new Thread(pd);
		Thread t3 = new Thread(ct);
		Thread t4 = new Thread(ct);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
