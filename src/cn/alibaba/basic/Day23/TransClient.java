package cn.alibaba.basic.Day23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TransClient {

	private static Socket s;

	public static void main(String[] args) throws IOException, IOException {
		s = new Socket(InetAddress.getLocalHost(), 10005);

		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));

		//定义目的，将数据写入到socket的输出流
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));
		//定义Socket读取流，读取服务端返回的大写字母
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));

		String line = null;
		while ((line = bufr.readLine()) != null) {

			if ("over".equals(line)) {
				break;
			}

			bufOut.write(line);
			bufOut.newLine();
			bufOut.flush();

			String str = bufIn.readLine();
			System.out.println("server:" + str);

		}

		bufr.close();
		s.close();//socket流有结束标记
	}

}

class TransServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10005);

		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "connected!");

		// 读取Socket读取流中的数据
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));

		// 目的：将大写数据写入到Socket输出流，同时发送到客户端
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));

		String line = null;
		while ((line = bufIn.readLine()) != null) {
			bufOut.write(line.toUpperCase());
			bufOut.newLine();
			bufOut.flush();
		}

		s.close();
		ss.close();
	}
}
