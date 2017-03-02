package cn.alibaba.basic.Day23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class TextClient {
	public static void main(String[] args) throws IOException, IOException {
		Socket s = new Socket(InetAddress.getLocalHost(), 10006);

		BufferedReader bufr = new BufferedReader(new FileReader("buf.txt"));

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

/*		// �ȷ��������
		long time = System.currentTimeMillis();
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		dos.writeLong(time);*/

		String line = null;
		while ((line = bufr.readLine()) != null) {
			out.println(line);
		}

		s.shutdownOutput();//�൱�ڼ���������

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));
		String tr = bufIn.readLine();
		System.out.println(tr);

		bufr.close();
		s.close();
	}
}

public class TextServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10006);

		Socket s = ss.accept();

//		System.out.println(s.getInetAddress().getHostAddress()
//				+ "...connected!");

/*		// ���ո��������
		DataInputStream dis = new DataInputStream(s.getInputStream());
		long readLong = dis.readLong();*/

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));

		PrintWriter out = new PrintWriter(new FileWriter("server.txt"), true);

		String line = null;
		while ((line = bufIn.readLine()) != null) {
			out.println(line);
		}

		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		pw.println("�ϴ��ɹ�");

		out.close();
		s.close();
		ss.close();
	}

}
