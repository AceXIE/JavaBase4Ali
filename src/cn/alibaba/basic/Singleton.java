package cn.alibaba.basic;



public class Singleton {
	private static Singleton singleDemo = null;
	private Singleton() {
		System.out.println("Singleton created.");
	}
//	public static synchronized Singleton getSingle() {
//		if(null == singleDemo)
//			singleDemo = new Singleton();
//		return singleDemo;
//	}
	public static Singleton getSingle() {
		if(null == singleDemo) {
			synchronized (Singleton.class) {
				if(null == singleDemo) {
					singleDemo = new Singleton();
				}
			}
		}
		return singleDemo;
	}
}

class SingletonDemo {

}