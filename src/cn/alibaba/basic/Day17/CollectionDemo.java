package cn.alibaba.basic.Day17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class myComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
//		return 0;
	}

}

public class CollectionDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("z");
		list.add("ad");
		list.add("adfas");

		Collections.sort(list, new myComp());
		sop(list);

		int index = Collections.binarySearch(list, "ad");

		sop(index);

		int index1 = Collections.binarySearch(list, "ad", new myComp());

		sop(index1);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
