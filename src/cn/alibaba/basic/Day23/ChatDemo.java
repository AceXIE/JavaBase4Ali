package cn.alibaba.basic.Day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class Send implements Runnable {
	private DatagramSocket ds;

	public Send(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));

		String line = null;

		try {
			while ((line = bufr.readLine()) != null) {
				if ("886".equals(line)) {
					break;
				}
				byte[] buf = line.getBytes();

				DatagramPacket dp = new DatagramPacket(buf, buf.length,
						InetAddress.getByName("192.168.1.255"), 10002);
				ds.send(dp);
			}
		} catch (IOException e) {
			throw new RuntimeException("∑¢ÀÕ ß∞‹");
		}

	}

}

class Receive implements Runnable {
	private DatagramSocket ds;

	public Receive(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			while (true) {
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);

				ds.receive(dp);

				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(), 0, dp.getLength());

				System.out.println(ip + ":" + data);
			}
		} catch (Exception e) {
			throw new RuntimeException("Ω” ’ ß∞‹");
		}
	}
}

public class ChatDemo {

	public static void main(String[] args) throws IOException {
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receiveSocket = new DatagramSocket(10002);

		new Thread(new Send(sendSocket)).start();
		new Thread(new Receive(receiveSocket)).start();

	}

}
