package cn.alibaba.basic.Day18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) {
		FileReader fr = null;

		try {
			fr = new FileReader("demo.txt");

			/*
			 * int ch;
			 * while((ch = fr.read()) != -1) {
			 * 		System.out.println("ch = " + (char) ch);
			 *  }
			 */

			char[] cbuf = new char[4];
			int num;
			while ((num = fr.read(cbuf)) != -1) {
				System.out.println("num = " + num + ";"
						+ new String(cbuf, 0, num));

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
