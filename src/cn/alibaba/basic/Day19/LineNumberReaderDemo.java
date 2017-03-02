package cn.alibaba.basic.Day19;

import java.io.FileReader;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("buf.txt");

		LineNumberReader lnr = new LineNumberReader(fr);

		String s = null;
		while((s = lnr.readLine())!=null) {
			System.out.println(lnr.getLineNumber()+":"+s);
		}
		fr.close();

	}

}
