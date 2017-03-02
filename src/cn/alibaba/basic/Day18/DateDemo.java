package cn.alibaba.basic.Day18;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		Date date = new Date();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd W F D");
		String string = format.format(date);

		System.out.println(string);
	}

}
