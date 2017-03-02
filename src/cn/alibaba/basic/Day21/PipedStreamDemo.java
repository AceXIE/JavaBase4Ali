package cn.alibaba.basic.Day21;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道通讯，最好使用两个线程来进行通讯
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
			System.out.println("读取前...没有数据阻塞");
			len = in.read(buf);
			System.out.println("读到数据");
			String s = new String(buf, 0, len);

			System.out.println(s);
		} catch (IOException e) {
			throw new RuntimeException("管道输入流失败");
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
			System.out.println("开始写入数据");
			Thread.sleep(5000);
			out.write("Piped come".getBytes());
		} catch (Exception e) {
			throw new RuntimeException("管道输出流失败");
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
