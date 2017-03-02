package cn.alibaba.basic.Day10;

class NoValueException extends RuntimeException {

	public NoValueException(String message) {
		super(message);
	}

}

interface Shape {
	double getArea();
}

class Rec implements Shape {
	private int len, wid;

	Rec(int len, int wid) {
		if (len < 0 || wid < 0) {
			throw new NoValueException("¸ºÊýÀ²");
		}
		this.len = len;
		this.wid = wid;
	}

	public double getArea() {

		return len * wid;
	}
}

class Arc implements Shape {
	private double r;

	Arc(double r) {
		if(r <= 0) {
			throw new NoValueException(null);
		}
		this.r = r;
	}

	public double getArea() {
		return Math.PI * r * r;
	}

}

public class TestFinally {

	public static void main(String[] args) {
		Rec rc;
		rc = new Rec(-1, 2);
		System.out.println(rc.getArea());

		System.out.println("over~~~~");
	}

}
