package cn.alibaba.basic.Day09;

abstract class AbsInner {
	abstract void show();
}

class Outer1 {
	public int x = 1;

	public void fun() {

		new AbsInner() {
			void show() {
				System.out.println("Inner Class");
			}

			void show1() {
				System.out.println("Inner show1");
			}
		}.show1();
	}
}

public class Day09InnerClass {

	public static void main(String[] args) {
		// new Outer1().fun();
		run(new AbsInner() {

			void show() {
				System.out.println("hiahia");
			}
		});
	}

	public static void run(AbsInner absInner) {
		absInner.show();
	}

}
