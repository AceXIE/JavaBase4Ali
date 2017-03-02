package cn.alibaba.basic;

/**
 *
 * @author Administrator 接口，常量，抽象方法 常量：public static final 方法：public abstract
 */

interface Inter {

	public static final int NUM = 3;

	public abstract void show();
}

interface Inter1 {

	public static final int NUM2 = 4;

	public abstract void talk();
}

class ImplInter implements Inter, Inter1 {

	public void show() {

		System.out.println("ImplShow : " + "" + "  "
				+ ImplInter.class.getName());
	}

	public void talk() {

		System.out.println("ImplTalk :" + ImplInter.class.getName());
	}

}

public class TestInterface {

	public static void main(String[] args) {

		ImplInter implInter = new ImplInter();
		implInter.show();
		implInter.talk();
		System.out.println(Inter.NUM);

	}

}
