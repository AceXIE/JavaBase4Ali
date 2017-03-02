package cn.alibaba.basic.Day18;

import java.io.FileWriter;
import java.io.IOException;

/**
 * ×Ö½ÚÁ÷£ºInputStream, OutputStream ×Ö·ûÁ÷£ºReader, Writer
 *
 * @author xiekai
 *
 */

public class ReaderWriterDemo {

	public static void main(String[] args) {

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter("demo.txt", true);

			fileWriter.write("123");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fileWriter) {
					fileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
