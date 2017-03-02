package cn.alibaba.basic.Day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ¶ÁÈ¡¼üÅÌµÄÊäÈë
 * 
 * @author xiekai
 * 
 */

public class ReadIn {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;

		InputStreamReader inputStreamReader = new InputStreamReader(in);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String readLine = null;
		while ((readLine = bufferedReader.readLine()) != null) {
			System.out.println(readLine);
		}

	}

}
