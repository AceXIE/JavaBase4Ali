package cn.alibaba.basic.Day24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class LogInClient {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket(InetAddress.getLocalHost(), 10008);

		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));

		for (int i = 0; i < 3; i++) {
			String line = bufr.readLine();
			if (line == null) {
				break;
			}
			out.println(line);

			String info = bufIn.readLine();
			System.out.println(info);
			if (info.contains("»¶Ó­"))
				break;
		}

		s.close();
		bufr.close();

	}

}

class UserThread implements Runnable {
	private Socket s;

	public UserThread(Socket s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "...connected!");
		try {
			for (int i = 0; i < 3; i++) {
				BufferedReader bufIn = new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				String name = bufIn.readLine();
				if (name == null)
					break;

				PrintWriter out = new PrintWriter(s.getOutputStream(), true);

				BufferedReader bufr = new BufferedReader(new FileReader(
						"users.txt"));

				String line = null;
				boolean flag = false;
				while ((line = bufr.readLine()) != null) {
					if (line.equals(name)) {
						flag = true;
						break;
					}
				}
				if (flag) {
					System.out.println(name + ",ÒÑ¾­µÇÂ½");
					out.println("»¶Ó­µÇÂ½");
					break;
				} else {
					System.out.println(name + ",³¢ÊÔµÇÂ½");
					out.println(name + "ÓÃ»§Ãû²»´æÔÚ");
				}
			}
			s.close();
		} catch (Exception e) {
			throw new RuntimeException(ip + "µÇÂ½Ê§°Ü");
		}
	}

}

class LogInServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10008);

		while (true) {
			Socket s = ss.accept();

			new Thread(new UserThread(s)).start();
		}

	}
}
