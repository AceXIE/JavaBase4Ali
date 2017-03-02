package cn.alibaba.basic.Day21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student> {
	private String name;
	private int math, cn, en;
	private int sum;

	public Student(String name, int math, int cn, int en) {
		this.name = name;
		this.math = math;
		this.cn = cn;
		this.en = en;
		this.sum = math + cn + en;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public int compareTo(Student o) {

		int num = new Integer(this.sum).compareTo(new Integer(o.sum));
		if (num == 0) {
			return this.name.compareTo(o.name);
		}

		return num;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + sum * 79;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Student)) {
			throw new ClassCastException("¿‡–Õ≤ª∆•≈‰");
		}

		Student s = (Student) obj;

		return this.name.equals(s.name) && this.sum == s.sum;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", math=" + math + ", cn=" + cn
				+ ", en=" + en + ", sum=" + sum + "]";
	}

}

class StudentInfoTool {
	public static Set<Student> getStudents() throws IOException {
		return getStudents(null);
	}


	public static Set<Student> getStudents(Comparator<Student> cmp) throws IOException {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));
		String line = null;
		Set<Student> stus = null;

		if(cmp == null) {
			stus = new TreeSet<Student>();
		} else {
			stus = new TreeSet<>(cmp);
		}


		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			String[] info = line.split(",");

			Student stu = new Student(info[0], Integer.parseInt(info[1]),
					Integer.parseInt(info[1]), Integer.parseInt(info[2]));

			stus.add(stu);
		}

		bufr.close();

		return stus;
	}

	public static void write2File(Set<Student> stus) throws IOException {
		BufferedWriter bufw = new BufferedWriter(new FileWriter("Stuinfo.txt"));

		for (Student s : stus) {
			bufw.write(s.toString() + "\t");
			bufw.write(s.getSum()+"");
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
	}
}

public class StudentDemo {

	public static void main(String[] args) throws IOException {
		Comparator<Student> cmp = Collections.reverseOrder();

		Set<Student> stus = StudentInfoTool.getStudents(cmp);
		StudentInfoTool.write2File(stus);
	}

}
