package cn.alibaba.basic.Day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP发送
 * @author xiekai
 *
 */
/**
 * 通过UDP传输方式，发送文字数据 1. 建立UDPsocket服务 2. 提供数据，并封装数据包 3. 通过socket服务的发送功能，将数据包发送 4.
 * 关闭资源
 */
public class UDPSendDemo {

	private static DatagramSocket ds;

	public static void main(String[] args) throws IOException {
		ds = new DatagramSocket();

		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));
		String line = null;

		while ((line = bufr.readLine()) != null) {
			if ("886".equals(line)) {
				break;
			}
			byte[] data = line.getBytes();

			DatagramPacket dp = new DatagramPacket(data, data.length,
					InetAddress.getLocalHost(), 10000);
			ds.send(dp);
		}

		ds.close();
	}

}

/**
 * 接收端数据
 * 
 * @author xiekai
 * 
 */
class UDPReceiveDemo {

	private static DatagramSocket ds;

	public static void main(String[] args) throws IOException {
		ds = new DatagramSocket(10000);

		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(), 0, dp.getLength());
			int port = dp.getPort();
			System.out.println(ip + ":" + port + "::" + data);
		}

		// ds.close();
	}
}
