package cn.alibaba.basic.Day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 实现Comparator接口，来进行比较
 *
 * @author xiekai
 *
 */
class MyCompare implements Comparator {

	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;

		int num = s1.getName().compareTo(s2.getName());

		if (num == 0) {
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
			// return s1.getAge() - s2.getAge();
		}

		return num;
	}

}

public class TestTreeSet1 {

	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new MyCompare());

		ts.add(new Student("1", 1));
		ts.add(new Student("2", 3));
		ts.add(new Student("2", 2));
		ts.add(new Student("2", 5));

		Iterator it = ts.iterator();
		while (it.hasNext()) {
			Student s = (Student) it.next();
			System.out.println(s.getName() + "..." + s.getAge());
		}
	}

}
