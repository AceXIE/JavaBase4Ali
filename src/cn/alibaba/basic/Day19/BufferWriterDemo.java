package cn.alibaba.basic.Day19;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterDemo {

	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bufw = null;
		try {
			// 创建字符写入流对象
			fw = new FileWriter("buf.txt");
			//
			bufw = new BufferedWriter(fw);

			bufw.write("1234");
			bufw.newLine();
			bufw.write("newLine");
			bufw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				bufw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
