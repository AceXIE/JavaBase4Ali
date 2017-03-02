package cn.alibaba.basic.Day22;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {

	private Frame f;
	private Button but;

	public FrameDemo() {
		init();
	}

	public void init() {
		f = new Frame("My Frame");

		f.setBounds(200, 100, 500, 600);
		f.setLayout(new FlowLayout());

		but = new Button("MyButton");

		f.add(but);
		myEvent();
		f.setVisible(true);

	}

	private void myEvent() {
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});

		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("exit from button.");
				System.exit(0);

			}
		});
	}

	public static void main(String[] args) {
		new FrameDemo();
	}

}
