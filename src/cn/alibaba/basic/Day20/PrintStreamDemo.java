package cn.alibaba.basic.Day20;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));

		PrintWriter out = new PrintWriter(new FileWriter("a.txt"),true);

		String line = null;
		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line))
				break;
			out.println(line.toUpperCase());
			// out.flush();
		}

		out.close();
		bufr.close();
	}

}
