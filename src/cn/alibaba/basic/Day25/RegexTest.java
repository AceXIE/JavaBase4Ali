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
	 * ��IP��ַ�ν������� 1.�������0���в��� 2.ֻ����3λ
	 */
	public static void test2() {
		String ip = "10.10.1.12 192.168.23.123 2.2.3.2 8.8.8.8";

		// ��ʾ���������֣�������Ҫ�õ�ǰ���������������Ҫ���з�װ����
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
		String str = "����...ѧϰ...����.....����.";

		str = str.replaceAll("\\.+", "");

		str = str.replaceAll("(.)\\1+", "$1");

		System.out.println(str);
	}

}
