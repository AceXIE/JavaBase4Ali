package cn.alibaba.basic.Day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPic {

	public static void main(String[] args) {

		FileOutputStream fos = null;
		FileInputStream fin = null;

		try {
			fin = new FileInputStream("1.jpg");
			fos = new FileOutputStream("1_copy.jpg");

			byte[] buf = new byte[1024];

			int len = 0;

			while((len = fin.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != fin) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


	}

}
