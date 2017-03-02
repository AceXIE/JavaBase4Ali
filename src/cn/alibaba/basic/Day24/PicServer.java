package cn.alibaba.basic.Day24;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用多线程技术
 *
 * @author xiekai
 *
 */
class PicThread implements Runnable {
	private Socket s;

	public PicThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		int count = 1;
		String ip = s.getInetAddress().getHostAddress();
		try {

			System.out.println(ip + "...connected!");

			InputStream in = s.getInputStream();
			File file = new File(ip + "(" + count + ")" + ".jpg");

			while (file.exists()) {
				file = new File(ip + "(" + (count++) + ")" + ".jpg");
			}

			FileOutputStream fos = new FileOutputStream(file);

			byte[] buf = new byte[1024];

			int len = 0;
			while ((len = in.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}

			OutputStream out = s.getOutputStream();
			out.write("上传成功".getBytes());

			fos.close();
			s.close();
		} catch (Exception e) {
			throw new RuntimeException(ip + "上传失败");
		}
	}

}

class PicClient {
	public static void main(String[] args) throws IOException, IOException {

		Socket s = new Socket(InetAddress.getLocalHost(), 10007);

		FileInputStream fis = new FileInputStream("1.jpg");

		OutputStream out = s.getOutputStream();

		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fis.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		// 告诉服务器端结束
		s.shutdownOutput();

		InputStream in = s.getInputStream();

		byte[] bufIn = new byte[1024];
		int num = in.read(bufIn);
		System.out.println(new String(bufIn, 0, num));

		fis.close();
		s.close();

	}
}

public class PicServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10007);
		while (true) {
			Socket s = ss.accept();

			new Thread(new PicThread(s)).start();

		}
		// ss.close();
	}

}
