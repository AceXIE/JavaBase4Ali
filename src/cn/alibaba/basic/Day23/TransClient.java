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

		//����Ŀ�ģ�������д�뵽socket�������
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));
		//����Socket��ȡ������ȡ����˷��صĴ�д��ĸ
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
		s.close();//socket���н������
	}

}

class TransServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10005);

		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "connected!");

		// ��ȡSocket��ȡ���е�����
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));

		// Ŀ�ģ�����д����д�뵽Socket�������ͬʱ���͵��ͻ���
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
