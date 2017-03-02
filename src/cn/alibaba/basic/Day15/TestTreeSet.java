package cn.alibaba.basic.Day15;

import java.util.Iterator;
import java.util.TreeSet;

class Student implements Comparable {
	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int compareTo(Object o) {
		if (!(o instanceof Student)) {
			throw new RuntimeException("不是学生");
		}
		Student s = (Student) o;
		if (this.age > s.age) {
			return 1;
		} else if (this.age < s.age) {
			return -1;
		} else {
			return this.name.compareTo(s.name);
//			return 0;
		}
	}

}

public class TestTreeSet {

	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(new Student("1", 1));
		ts.add(new Student("2", 2));
		ts.add(new Student("2", 3));
		ts.add(new Student("004", 3));
		ts.add(new Student("005", 3));

		Iterator it = ts.iterator();
		while (it.hasNext()) {
			Student s = (Student) it.next();
			System.out.println(s.getName() + "..." + s.getAge());
		}
	}

}
