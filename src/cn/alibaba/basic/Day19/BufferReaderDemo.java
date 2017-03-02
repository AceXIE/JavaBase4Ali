package cn.alibaba.basic.Day19;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * �ַ���ȡ��������
 *
 * @author xiekai
 *
 */
public class BufferReaderDemo {

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("buf.txt");

		BufferedReader bufr = new BufferedReader(fr);

		String s = null;
		while ((s = bufr.readLine()) != null) {
			System.out.println(s);
		}
		bufr.close();
	}

}
