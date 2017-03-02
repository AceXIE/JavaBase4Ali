package cn.alibaba.basic.Day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP����
 * @author xiekai
 *
 */
/**
 * ͨ��UDP���䷽ʽ�������������� 1. ����UDPsocket���� 2. �ṩ���ݣ�����װ���ݰ� 3. ͨ��socket����ķ��͹��ܣ������ݰ����� 4.
 * �ر���Դ
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
 * ���ն�����
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
