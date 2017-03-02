package cn.alibaba.basic.Day18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * 拷贝文件
 *
 * @author xiekai
 *
 */

public class CopyText {

	public static void main(String[] args) {
			copy2();
	}

	public static void copy1() throws IOException {
		// 创建目的文件
		FileWriter fw = new FileWriter("Democopy.txt");
		FileReader fr = new FileReader("Demo.txt");

		int ch = 0;
		while ((ch = fr.read()) != -1) {
			fw.write(ch);
		}
		fw.close();
		fr.close();
	}

	public static void copy2() {
		FileWriter fw = null;
		FileReader fr = null;
		try {
			fw = new FileWriter("Democopy2.txt");
			fr = new FileReader("Demo1.txt");

			int len = 0;
			char[] cbuf = new char[1024];
			while ((len = fr.read(cbuf)) != -1) {
				fw.write(cbuf, 0, len);
			}

		} catch (IOException e) {
			throw new RuntimeException("读写失败");
		} finally {
			if (null != fr) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != fw) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
