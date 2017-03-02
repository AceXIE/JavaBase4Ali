package cn.alibaba.basic;
/***
 * @author Administrator
 * 需求：获取程序运行时间
 * 思路：获取开始和结束时间，相减即得到运行时间
 *
 */

abstract class GetTime {
	public final void getRunTime() {
		long start = System.currentTimeMillis();
		runCode();
		long end = System.currentTimeMillis();
		System.out.println("Run Time : " + (end - start));
	}

	public abstract void runCode();
}

class SubGetTime extends GetTime {
	public void runCode() {
		for (int i = 0; i < 1000000; i++) {

		}
	}
}

public class Template {

	public static void main(String[] args) {
		SubGetTime g = new SubGetTime();
		g.getRunTime();
	}

}
