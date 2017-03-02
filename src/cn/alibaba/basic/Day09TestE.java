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
			throw new BlueException("����~~");
		} else if (state == 3) {
			throw new SomkeException("ð��~~");
		}
		System.out.println("���Կ���");
	}

	public void reset() {
		System.out.println("��������");
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
			System.out.println("�Ͽ�");
		} catch (BlueException e) {
			comp.reset();
		} catch (SomkeException e) {
			throw new NoPlan("�޷�����" + e.getMessage());
		}
	}
}

public class Day09TestE {

	public static void main(String[] args) {
		Teacher te = new Teacher("xie");
		try {
			te.pre();
		} catch (NoPlan e) {
			System.out.println("�ؼ�" + e.getMessage());
		}
	}

}
