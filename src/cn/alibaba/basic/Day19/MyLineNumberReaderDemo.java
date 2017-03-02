package cn.alibaba.basic.Day19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

class MyLineNumberReader extends MyBufferedReader{
	private int lineNumber;

	public MyLineNumberReader(Reader r) {
		super(r);
	}

	public String myReaderLine() throws IOException {
		lineNumber++;
		return super.myReadLine();
	}

	public void myClose() throws IOException {
		super.myClose();
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

}

public class MyLineNumberReaderDemo {

	public static void main(String[] args) throws IOException {
		MyLineNumberReader mlr = new MyLineNumberReader(new FileReader(
				"buf.txt"));
		String s = null;

		while ((s = mlr.myReaderLine()) != null) {
			System.out.println(mlr.getLineNumber() + ":" + s);
		}

		mlr.myClose();
	}

}
