package cn.alibaba.basic;

class SomkeException extends Exception {
	public SomkeException(String msg) {
		super(msg);
	}
}

class BlueException extends Exception {
	public BlueException(String msg) {
		super(msg);
	}
}

class NoPlan extends Exception {
	private String msg;
	public NoPlan(String msg) {
		super(msg);
		this.msg = msg;
	}
	public String getMessage() {
		return msg;
	}
}

class Computer {
	private int state = 3;
	public void run() throws BlueException, SomkeException {
		if (state == 2) {
			throw new BlueException("蓝屏~~");
		} else if (state == 3) {
			throw new SomkeException("冒烟~~");
		}
		System.out.println("电脑开机");
	}

	public void reset() {
		System.out.println("电脑重启");
	}
}

class Teacher {
	private Computer comp;
	private String name;

	Teacher(String name) {
		this.name = name;
		comp = new Computer();
	}

	public void pre() throws NoPlan {
		try {
			comp.run();
			System.out.println("上课");
		} catch (BlueException e) {
			comp.reset();
		} catch (SomkeException e) {
			throw new NoPlan("无法继续" + e.getMessage());
		}
	}
}

public class Day09TestE {

	public static void main(String[] args) {
		Teacher te = new Teacher("xie");
		try {
			te.pre();
		} catch (NoPlan e) {
			System.out.println("回家" + e.getMessage());
		}
	}

}
