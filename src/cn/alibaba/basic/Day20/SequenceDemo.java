package cn.alibaba.basic.Day20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceDemo {

	public static void main(String[] args) throws IOException {

		Vector<FileInputStream> v = new Vector<>();

		v.add(new FileInputStream("a.txt"));
		v.add(new FileInputStream("buf.txt"));

		Enumeration<FileInputStream> e = v.elements();

		SequenceInputStream sis = new SequenceInputStream(e);

		FileOutputStream fos = new FileOutputStream("4.txt");
		byte[] buf = new byte[1024];

		int len = 0;

		while((len = sis.read(buf))!= -1) {
			fos.write(buf, 0 , len);
		}

		fos.close();
		sis.close();

	}

}
