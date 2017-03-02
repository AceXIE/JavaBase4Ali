package cn.alibaba.basic.Day14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestCollection {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();

		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");

		sop("Size : " + al.size());

		ListIterator lit = al.listIterator();
		sop("hasPre() : " + lit.hasPrevious());
		while(lit.hasNext()) {
			Object obj = lit.next();
			if(obj.equals("2")) {
				lit.set("666");
			}
		}
		while(lit.hasPrevious()) {
			sop("pre :" + lit.previous());
		}
//		sop(al);


//		Iterator it = al.iterator();
//		while(it.hasNext()) {
//			sop(it.next());
//		}

	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
