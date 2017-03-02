package cn.alibaba.basic.Day25;

import java.util.TreeSet;

public class RegexTest {

	public static void main(String[] args) {

		checkMail();
		// test2();
		// test1();
	}

	public static void checkMail() {
		String mail = "adfa@s.com.cn.cn";
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";

		System.out.println(mail.matches(regex));
	}

	/*
	 * 将IP地址段进行排序 1.按照最多0进行补充 2.只保留3位
	 */
	public static void test2() {
		String ip = "10.10.1.12 192.168.23.123 2.2.3.2 8.8.8.8";

		// 显示找连续数字，后面需要用到前面规则结果，所以需要进行封装成组
		ip = ip.replaceAll("(\\d+)", "00$1");

		ip = ip.replaceAll("0*(\\d{3})", "$1");

		String[] arr = ip.split(" ");

		TreeSet<String> ts = new TreeSet<>();
		for (String s : arr) {
			ts.add(s);
		}
		for (String string : ts) {
			string = string.replaceAll("0*(\\d+)", "$1");
			System.out.println(string);
		}

		// System.out.println(ip);
	}

	public static void test1() {
		String str = "哈哈...学习...我我.....爱爱.";

		str = str.replaceAll("\\.+", "");

		str = str.replaceAll("(.)\\1+", "$1");

		System.out.println(str);
	}

}
