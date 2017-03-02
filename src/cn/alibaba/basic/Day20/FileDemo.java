package cn.alibaba.basic.Day20;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		File f = new File("e:\\code\\a.txt");

//		File[] files = 
		
		// create(f);
//		System.out.println("f path:" + f.getPath());
//		System.out.println("f:" + f.getAbsolutePath());
//		System.out.println("f parents:" + f.getParent());

	}

	public static void create(File f) throws IOException {
		System.out.println("f :" + f.exists());

		if (!f.exists()) {
			f.createNewFile();
		}

		System.out.println("f exists :" + f.exists());
	}

}
