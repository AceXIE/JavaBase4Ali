package cn.alibaba.basic.Day23;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class TcpClient {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket(InetAddress.getLocalHost(), 10003);

		OutputStream out = s.getOutputStream();
		out.write("tcp".getBytes());

/*		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);

		System.out.println(new String(buf,0, len));*/

		s.close();
	}
}


public class TcpServer {

	private static ServerSocket ss;

	public static void main(String[] args) throws IOException {
		ss = new ServerSocket(10003);

		Socket s = ss.accept();

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);

		System.out.println(s.getInetAddress().getHostAddress() + ":"
				+ new String(buf, 0, len));
		s.close();
	}

}
