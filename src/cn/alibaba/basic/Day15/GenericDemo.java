package cn.alibaba.basic.Day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * ���ͣ������ȫ������,���Ͱ�ȫ����
 *
 * @author xiekai
 *
 *         ��ȫ����Ч������д
 */

class MyComp implements Comparator<String> {
	public int compare(String s1, String s2) {
		return -1;

	}
}

public class GenericDemo {

	public static void main(String[] args) {
		TreeSet<String> arrayList = new TreeSet<>(new MyComp());

		arrayList.add("1");
		arrayList.add("2");
		arrayList.add("4");

		Iterator<String> it = arrayList.iterator();
		while (it.hasNext()) {
			String s = it.next();
			sop(s + " : " + s.length());
		}

	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}


