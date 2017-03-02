package cn.alibaba.basic;

abstract class Student {
	abstract void study();
	abstract void study1();

	public void sleep() {
		System.out.println("sleep");
	}

}

class BaseStudent extends Student {
	void study() {
		System.out.println("base Stu");
	}

	void study1() {

	}
}

public class TestAbstract {

	public static void main(String[] args) {
		Student s = new Student() {

			void study() {
				System.out.println("s");

			}

			void study1() {

			}
		};
		s.study();
		s.sleep();
	}

}
