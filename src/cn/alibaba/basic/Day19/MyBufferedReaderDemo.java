package cn.alibaba.basic.Day19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

class MyBufferedReader {
	private Reader fr;

	public MyBufferedReader(Reader r) {
		this.fr = r;
	}

	// 可以一次读一行
	public String myReadLine() throws IOException {

		StringBuilder stringBuilder = new StringBuilder();
		int ch = 0;
		while ((ch = fr.read()) != -1) {
			if (ch == '\r') {
				continue;
			}
			if (ch == '\n') {
				return stringBuilder.toString();
			} else {
				stringBuilder.append((char) ch);
			}
		}
		if (stringBuilder.length() != 0) {
			return stringBuilder.toString();
		}

		return null;
	}

	public void myClose() throws IOException {
		fr.close();
	}
}

public class MyBufferedReaderDemo {

	public static void main(String[] args) {
		try {
			MyBufferedReader mbfr = new MyBufferedReader(new FileReader(
					"buf.txt"));
			String s = null;
			while ((s = mbfr.myReadLine()) != null) {
				System.out.println(s);

			}
			mbfr.myClose();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
