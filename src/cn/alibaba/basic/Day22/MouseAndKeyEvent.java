package cn.alibaba.basic.Day22;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseAndKeyEvent {

	private Frame f;
	private Button but;
	private TextField tf;

	public MouseAndKeyEvent() {
		init();
	}

	public void init() {
		f = new Frame("My Frame");

		f.setBounds(200, 100, 500, 600);
		f.setLayout(new FlowLayout());

		but = new Button("MyButton");

		tf = new TextField(10);

		f.add(but);
		f.add(tf);

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

		tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(!(keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9)) {
					System.out.println("ÊäÈë·Ç·¨");
					e.consume();
				}
			}

		});

		but.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(KeyEvent.getKeyText(e.getKeyCode()) + ":" + e.getKeyCode());
			}

		});

/*		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action Event...");
			}
		});

		but.addMouseListener(new MouseAdapter() {
			private int cnt = 1;
			private int cnt1 = 0;

			@Override
			public void mouseEntered(MouseEvent e) {
				cnt++;
				System.out.println(cnt + "");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					System.out.println("Ë«»÷");
				}
			}

		});*/
	}

	public static void main(String[] args) {
		new MouseAndKeyEvent();
	}

}
