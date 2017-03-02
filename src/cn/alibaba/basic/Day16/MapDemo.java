package cn.alibaba.basic.Day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Map
//	|-HashTable
//	|-HashMap
//	|-TreeMap



public class MapDemo {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("01", "xie1");
		map.put("02", "xie02");
		map.put("03", "xie4");

		Set<Map.Entry<String, String>> entries = map.entrySet();

		Iterator<Map.Entry<String, String>> it = entries.iterator();

		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("key :" + entry.getKey() + " value :"
					+ entry.getValue());
		}

		// Set<String> keySet = map.keySet();
		//
		// Iterator<String> it = keySet.iterator();
		//
		// while (it.hasNext()) {
		// String key = it.next();
		// System.out.println("key :" + key + "value :" + map.get(key));
		// }

	}

}
