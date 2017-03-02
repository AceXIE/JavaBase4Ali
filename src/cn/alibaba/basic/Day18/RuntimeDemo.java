package cn.alibaba.basic.Day18;

import java.io.IOException;

public class RuntimeDemo {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		try {
			Process p = rt.exec("notepad SystemDemo.java");
			Thread.sleep(1000);
//			p.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
