package cn.alibaba.basic.Day25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo2 {

	public static void main(String[] args) {

		String str = "aaa ming as juy jin";
		String regex = "\\b[a-z]{3}\\b";
		// String regex = "[1-9][0-9]{4,14}";

		Pattern pattern = Pattern.compile(regex);

		// ������ʽ��Ҫ���õ��ַ������������ȡƥ��������
		Matcher matcher = pattern.matcher(str);

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println(matcher.start() + ".." + matcher.end());
		}

		/*
		 * System.out.println("find = " +matcher.find());
		 * System.out.println(matcher.group());
		 */

		// System.out.println(matcher.matches());

	}
}
