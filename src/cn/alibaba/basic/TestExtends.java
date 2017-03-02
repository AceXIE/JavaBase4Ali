package cn.alibaba.basic;

class Father {
	int num = 1;

	Father() {
		System.out.println();
	}

	void show() {
		System.out.println(this.num);
		// return 1;
	}
}

class Sun extends Father {
	int num = 2;

	public void show() {
		System.out.println(this.num);
	}
}

public class TestExtends extends Father {

	public static void main(String[] args) {
		Sun s = new Sun();
		s.show();
	}
}
