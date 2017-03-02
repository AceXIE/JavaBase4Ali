package cn.alibaba.basic.Day09;

import cn.alibaba.basic.Day09.Outer.Inner;

/**
 * ÄÚ²¿Àà
 *
 * @author xiekai
 *
 */

class Outer {
	static int num = 1;

	static class Inner {
		int x = 2;

		public void interMethod() {
			System.out.println("Inter : " + num);
		}
	}

	interface haha {
		public abstract void say();
	}

	public void method() {
		System.out.println(getClass().getName() + " " + num);
		Inner in = new Inner();
		in.interMethod();
		// System.out.println(in.x);
	}
}

public class Day09InterClass {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method();
		new Outer.Inner().interMethod();

		// Outer.Inner outInner = new Outer().new Inner();
		// outInner.interMethod();
	}

}
