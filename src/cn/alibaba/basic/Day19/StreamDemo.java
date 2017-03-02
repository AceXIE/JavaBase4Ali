package cn.alibaba.basic.Day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamDemo {

	public static void main(String[] args) {
//		writeFile();

		readFile();



	}

	public static void readFile() {
		FileInputStream fin = null;

		try {
			fin = new FileInputStream("Output.txt");
			int num = fin.available();
			byte[] bs = new byte[num];

			fin.read(bs);

			System.out.println(new String(bs));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeFile() {
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("Output.txt");

			fos.write("abcde".getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fos)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
