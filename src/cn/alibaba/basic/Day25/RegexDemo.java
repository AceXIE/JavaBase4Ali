package cn.alibaba.basic.Day25;

public class RegexDemo {

	public static void main(String[] args) {

	String str = "";
	String regex = "";
	


//		replaceAll("ekkklxxxgwwwsdfs", "(.)\\1+", "$1");
//		replaceAll("ekkklxxxgwwwsdfs", "(.)\\1+", "&");
//		replaceAll("awerawe123e23asdf234", "\\d{3,}", "#");//���������Լ���������

		// splitDemo("xk.w.a","\\.");
		// splitDemo("c:\\abc\\a\\c.txt", "\\\\");//�ַ����У�\��ʶת��
		// splitDemo("erkkkktyxxui", "(.)\\1+");

		// checkQQ();
	}
	
	

	public static void replaceAll(String str, String regex, String newStr) {
		str = str.replaceAll(regex, newStr);
		System.out.println(str);
	}

	public static void splitDemo(String str, String regex) {
		// String str = "";//"xk.w.a";
		// String regex = " +";//һ�λ��߶��
		// String regex = "\\.";

		String[] arrs = str.split(regex);
		System.out.println(arrs.length);
		for (String s : arrs) {
			System.out.println(s);
		}
	}

	public static void checkQQ() {
		String qq = "123234a";
		String regex = "[1-9][0-9]{4,14}";

		boolean matches = qq.matches(regex);
		if (matches) {
			System.out.println("OK");
		} else {
			System.out.println("NO....");
		}
	}

}
