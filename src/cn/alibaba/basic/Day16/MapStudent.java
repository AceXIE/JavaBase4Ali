package cn.alibaba.basic.Day16;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Student implements Comparable<Student> {
	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {

		return this.name.hashCode() + this.age;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
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

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Student o) {

		return this.age - o.age;
	}

}

class StuComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int num = o1.getName().compareTo(o2.getName());
		if (num == 0) {
			return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
		}
		return num;
	}

}

public class MapStudent {

	public static void main(String[] args) {
		HashMap<Student, String> hashMap = new HashMap<>();

		hashMap.put(new Student("x1", 1), "haha");
		hashMap.put(new Student("x2", 2), "hah2");

		Set<Student> keySet = hashMap.keySet();
		Iterator<Student> it = keySet.iterator();

		while (it.hasNext()) {
			Student s = it.next();
			System.out.println(s + "...");
		}

		TreeMap<Student, String> tm = new TreeMap<>(new StuComparator());
		tm.put(new Student("x1", 1), "haha");
		tm.put(new Student("x2", 4), "hah2");
		tm.put(new Student("x2", 2), "hah2");

		Set<Map.Entry<Student, String>> entries = tm.entrySet();

		Iterator<Map.Entry<Student, String>> iterator = entries.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Student, String> maEntry = iterator.next();
			System.out.println(maEntry.getKey() + "....");
		}
	}

}
