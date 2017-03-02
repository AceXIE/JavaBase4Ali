package cn.alibaba.basic.Day24;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");

		URLConnection urlConnection = url.openConnection();
		
		InputStream in = urlConnection.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		
		System.out.println(new String(buf,0,len));

//		System.out.println(urlConnection);


	}

}
