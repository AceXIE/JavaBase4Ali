package cn.alibaba.basic.Day20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ProperiesDemo {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();

		File f = new File("count.ini");
		if (!f.exists()) {
			f.createNewFile();
		}

		FileInputStream fis = new FileInputStream("count.ini");

		prop.load(fis);

		int count = 0;
		String value = prop.getProperty("time");
		if (null != value) {
			count = Integer.parseInt(value);
			if (count >= 5) {
				System.out.println("你好，使用次数已到。");
				return;
			}
		}
		count++;
		prop.setProperty("time", count + "");

		FileOutputStream fos = new FileOutputStream(f);
		prop.store(fos, "add");

		fos.close();
		fis.close();

	}

}
