package cn.alibaba.basic.Day25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Õ¯“≥≈¿≥Ê
 * 
 * @author xiekai
 * 
 */

public class RegexTest2 {

	public static void main(String[] args) throws Exception {
		getMails();
	}

	public static void getMails() throws Exception {
		BufferedReader bufr = new BufferedReader(new FileReader("mail.txt"));

		String line = null;
		
		String regex = "\\w+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile(regex);
		
		
		
		while ((line = bufr.readLine()) != null) {
			Matcher m = p.matcher(line);
			while(m.find()){
				System.out.println(m.group());
			}
		}
	}

}
