package cn.alibaba.basic.Day21;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * �ܵ�ͨѶ�����ʹ�������߳�������ͨѶ
 *
 * @author xiekai
 *
 */

class Read implements Runnable {
	private PipedInputStream in;

	public Read(PipedInputStream in) {
		this.in = in;
	}

	@Override
	public void run() {
		byte[] buf = new byte[1024];

		int len;
		try {
			System.out.println("��ȡǰ...û����������");
			len = in.read(buf);
			System.out.println("��������");
			String s = new String(buf, 0, len);

			System.out.println(s);
		} catch (IOException e) {
			throw new RuntimeException("�ܵ�������ʧ��");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

class Write implements Runnable {
	private PipedOutputStream out;

	public Write(PipedOutputStream out) {
		this.out = out;
	}

	@Override
	public void run() {
		try {
			System.out.println("��ʼд������");
			Thread.sleep(5000);
			out.write("Piped come".getBytes());
		} catch (Exception e) {
			throw new RuntimeException("�ܵ������ʧ��");
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

public class PipedStreamDemo {

	public static void main(String[] args) throws IOException {
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();

		in.connect(out);

		Read r = new Read(in);
		Write w = new Write(out);

		new Thread(r).start();
		new Thread(w).start();

	}

}
