package cn.alibaba.basic;

public class Person {
	private String name = "haha";
	private int age;
	private static String country = "CN";

	static {
		System.out.println("static code");
	}
	{
		System.out.println("code block");
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Person");
	}

	public static void show() {
		System.out.println(country);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("zhang",20);
	}

}
