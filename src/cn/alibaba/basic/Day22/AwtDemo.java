package cn.alibaba.basic.Day22;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtDemo {

	public static void main(String[] args) {
		Frame f = new Frame("my awt");

		f.setSize(500, 200);
		f.setLocation(300, 200);
		f.setLayout(new FlowLayout());

		Button b = new Button("myButton");

		f.add(b);

		f.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.out.println("Closing......");
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("Opened...");
			}

			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("Activated.");
			}

		});

		f.setVisible(true);
		// System.out.println("hello");
	}

}
