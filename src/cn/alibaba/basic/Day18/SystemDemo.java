package cn.alibaba.basic.Day18;

import java.util.Properties;


public class SystemDemo {

	public static void main(String[] args) {
		Properties properties = System.getProperties();

		String ss = System.getProperty("os.name");
		System.out.println("osname=" + ss);

		for(Object obj : properties.keySet()) {
			String s = (String)properties.get(obj);
			System.out.println(obj + "..." + s);
		}

	}

}
