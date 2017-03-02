package cn.alibaba.basic.Day23;

import java.io.IOException;
import java.net.InetAddress;

public class IPDemo {

	public static void main(String[] args) throws IOException {
		InetAddress inetAddress = InetAddress.getLocalHost();

		System.out.println(inetAddress);
		System.out.println(InetAddress.getByName("www.baidu.com"));
	}

}
