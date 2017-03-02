package cn.alibaba.basic.Day22;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * 转到文件夹
 *
 * @author xiekai
 *
 */

public class MyWindowDemo {

	private Frame f;
	private Button but;
	private TextField tf;
	private TextArea ta;

	private Dialog d;
	private Label label;
	private Button okButton;

	public MyWindowDemo() {
		init();
	}

	public void init() {
		f = new Frame("MyWindow");
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());

		tf = new TextField(30);
		ta = new TextArea(25, 80);
		but = new Button("转到");

		f.add(tf);
		f.add(but);
		f.add(ta);

		myEvent();

		f.setVisible(true);

	}

	private void myEvent() {

		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				show();
			}

		});

		tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					show();
				}
			}

		});

		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});

	}

	public void show() {
		String string = tf.getText();

		File dir = new File(string);
		if (dir.exists() && dir.isDirectory()) {
			ta.setText("");
			String[] list = dir.list();
			for (String name : list) {
				ta.append(name + "\r\n");
				// ta.setText(name + "\r\n");
			}
		} else {
			d = new Dialog(f, "提示", true);
			d.setBounds(400, 200, 100, 100);
			d.setLayout(new FlowLayout());
			label = new Label();
			okButton = new Button("确定");
			errorDialog();

			d.add(label);
			d.add(okButton);

			String info = "你输入的" + string + "错误";
			label.setText(info);

			d.setVisible(true);
		}

		tf.setText("");
	}

	public void errorDialog() {
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});

		d.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				d.setVisible(false);
			}

		});
	}

	public static void main(String[] args) {
		new MyWindowDemo();
	}

}
