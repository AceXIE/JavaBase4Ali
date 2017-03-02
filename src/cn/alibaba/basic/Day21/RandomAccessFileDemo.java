package cn.alibaba.basic.Day21;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		writeFile();
		readFile();
	}

	public static void readFile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "r");

		raf.seek(6);

		byte[] buf = new byte[4];

		raf.read(buf);

		String s = new String(buf);

		System.out.println(s);

		raf.close();

	}


	public static void writeFile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");

		raf.write("xk".getBytes());

		raf.writeInt(97);

		raf.write("asdf".getBytes());

		raf.close();
	}

}
