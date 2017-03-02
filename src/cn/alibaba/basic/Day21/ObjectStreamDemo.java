package cn.alibaba.basic.Day21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
	
	static final long serialVersionUID = 12332212L;
	
	private String name;
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

public class ObjectStreamDemo {

	public static void main(String[] args) throws Exception {
//		 writeObj();
		readObj();
	}

	public static void writeObj() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"obj.txt"));

		oos.writeObject(new Person("xk", 24));

		oos.close();
	}

	public static void readObj() throws IOException, IOException,
			ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"obj.txt"));

		Person p = (Person) ois.readObject();

		System.out.println(p);

		ois.close();
	}

}
