package cn.alibaba.basic.Day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * ·Ö¸îÎÄ¼þ
 *
 * @author xiekai
 *
 */

public class SplitFile {

	public static void main(String[] args) throws IOException {
		splitFile();
		merge();
	}

	public static void splitFile() throws IOException {
		FileInputStream fis = new FileInputStream("1.jpg");
		FileOutputStream fos = null;

		byte[] buf = new byte[1024];
		int len = 0;
		int count = 1;
		while ((len = fis.read(buf)) != -1) {
			fos = new FileOutputStream("files\\" + (count++) + ".part");
			fos.write(buf, 0, len);
			fos.close();
		}
		fis.close();

	}

	public static void merge() throws IOException {
		
		ArrayList<FileInputStream> al = new ArrayList<>();

		for (int i = 1; i <= 8; i++) {
			al.add(new FileInputStream("files\\" + i + ".part"));
		}

		final Iterator<FileInputStream> it = al.iterator();

		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {


			public boolean hasMoreElements() {
				return it.hasNext();
			}

			public FileInputStream nextElement() {
				return it.next();
			}

		};

		SequenceInputStream sis = new SequenceInputStream(en);

		FileOutputStream fos = new FileOutputStream("233.jpg");

		byte[] buf = new byte[1024];

		int len = 0;

		while ((len = sis.read(buf)) != -1) {
			fos.write(buf, 0, len);
			fos.flush();
		}

		fos.close();
		sis.close();

	}

}
