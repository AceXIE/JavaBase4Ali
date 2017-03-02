package cn.alibaba.basic;
/**
 * @author xiekai
 *
 */
abstract class Students {
	abstract void study();
	void sleep(){
		System.out.println("sleep");
	}
}

interface Smoke {
	public abstract void smoke();
}

class Zhang extends Students implements Smoke {

	void study() {
		System.out.println("Zhang" + " study");
	}

	public void smoke() {
		System.out.println(Zhang.class.getName());
	}

}

public class TestInterfaceStudents {

	public static void main(String[] args) {
		Zhang zhang = new Zhang();
		zhang.study();
	}

}
