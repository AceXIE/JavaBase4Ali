package cn.alibaba.basic.Day08;

interface PCI {
	public void open();

	public void close();
}

class MainBoard {
	public void run() {
		System.out.println("MainBoard Run");
	}

	public void usePCI(PCI pci) {
		if (pci != null) {
			pci.open();
			pci.close();
		}
	}
}

class NetCard implements PCI {
	public void open() {
		System.out.println("NetCard open");
	}

	public void close() {
		System.out.println("NetCard close");
	}
}

class SoundCard implements PCI {

	public void open() {
		System.out.println("SoundCard open...");
	}

	public void close() {
		System.out.println("SoundCard close...");
	}

}

public class Day08TestMainboard {

	public static void main(String[] args) {
		MainBoard mb = new MainBoard();
		mb.run();
		mb.usePCI(new NetCard());
		mb.usePCI(new SoundCard());
	}

}
