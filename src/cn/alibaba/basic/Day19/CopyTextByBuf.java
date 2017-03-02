package cn.alibaba.basic.Day19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextByBuf {

	public static void main(String[] args) {
		BufferedReader bufr = null;
		BufferedWriter bufw = null;

		try {
			bufr = new BufferedReader(new FileReader("buf.txt"));
			bufw = new BufferedWriter(new FileWriter("buf_copy.txt"));
			String s = null;
			while ((s = bufr.readLine()) != null) {
				bufw.write(s);
				bufw.newLine();
				bufw.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != bufr) {
				try {
					bufr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != bufw) {
				try {
					bufw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
