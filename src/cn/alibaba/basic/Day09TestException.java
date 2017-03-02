package cn.alibaba.basic;

class ExceptionDemo {
	int div(int a, int b) throws MyException {

		if (b <= 0)
			throw new MyException("b·ÇÕýÊý", b);

		return a / b;
	}
}

class MyException extends Exception {
	private int val;
	public MyException(String msg) {
		super(msg);
	}
	public MyException(String msg, int val) {
		super(msg);
		this.val = val;
	}
	public String getMessage() {
		return Integer.toString(val);
	}
	public String toString() {
		return "MyException [getMessage()=" + getMessage() + ", toString()="
				+ super.toString() + "]";
	}

}

public class Day09TestException {

	public static void main(String[] args) {
		ExceptionDemo ed = new ExceptionDemo();
		int x;
		try {
			x = ed.div(4, -1);
			System.out.println("x = " + x);
		} catch (MyException e) {
			e.printStackTrace();
		}
		System.out.println("over~");
	}

}
