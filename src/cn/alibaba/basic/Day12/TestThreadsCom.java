package cn.alibaba.basic.Day12;

class Res {
	String name;
	String sex;
	boolean flag = false;

}

class Input implements Runnable {
	private Res r;

	Input(Res r) {
		this.r = r;
	}

	public void run() {
		int x = 0;
		while (true) {
			synchronized (r) {
				if (r.flag) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (x == 0) {
					r.name = "1";
					r.sex = "man";
				} else {
					r.name = "2";
					r.sex = "Ů";
				}
				x = (x + 1) % 2;
				r.flag = true;
				r.notify();
			}
		}
	}
}

class Output implements Runnable {
	private Res r;

	Output(Res r) {
		this.r = r;
	}

	public void run() {
		while (true) {
			synchronized (r) {
				if (!r.flag) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(r.name + "..." + r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}
}

public class TestThreadsCom {

	public static void main(String[] args) {
		Res r = new Res();
		Input in = new Input(r);
		Output out = new Output(r);

		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);

		t1.start();
		t2.start();
	}

}
