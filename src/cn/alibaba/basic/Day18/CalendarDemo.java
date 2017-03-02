package cn.alibaba.basic.Day18;

import java.util.Calendar;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();

//		sop(calendar);

		calendar.add(Calendar.DATE, 18);

		sop(calendar.get(Calendar.YEAR) +".."+ calendar.get(Calendar.DAY_OF_MONTH));
	}
	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
