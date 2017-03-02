package cn.alibaba.basic.Day15;

class Worker {

}

class Farmer {

}

class Tool {
	private Object obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}

class Utils<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}

// class Tool {
// private Worker worker;
//
//
// public Worker getWorker() {
// return worker;
// }
//
// public void setWorker(Worker worker) {
// this.worker = worker;
// }
//
// }

public class GenericFun {

	public static void main(String[] args) {
		Utils<Worker> utils = new Utils<>();
		utils.setT(new Worker());
		Worker w = utils.getT();
//		Tool t = new Tool();
//		t.setObj(new Worker());
//		Worker w = (Worker) t.getObj();
	}

}
