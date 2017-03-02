package cn.alibaba.basic.Day08;

abstract class Animal {
	abstract void eat();
}

class Cat extends Animal {

	void eat() {
		System.out.println("Eat fish");
	}

	void catchMouse() {
		System.out.println("catch mouse");
	}

}

class Dog extends Animal {

	void eat() {
		System.out.println("Eat meat");
	}

	void watchHouse() {
		System.out.println("watch House");
	}
}

public class Day08Polymorphic {

	public static void main(String[] args) {
		Animal a = new Cat();
		a.eat();
		fun(a);
//		Cat c = (Cat)a;//强制转化
//		c.catchMouse();

		fun(new Dog());
	}

	public static void fun(Animal c) {

		c.eat();
		if(c instanceof Cat) {
			Cat cc = (Cat)c;
			cc.catchMouse();
		} else if (c instanceof Dog) {
			Dog d = (Dog)c;
			d.watchHouse();
		}
	}

}
