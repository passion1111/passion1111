package ex01.gui;

import java.awt.*;
import java.awt.event.*;

public class MainEntry {
	public static void main(String[] args) {
		Frame f = new Frame();
		
		f.setTitle("First Frame");
		f.setBackground(Color.yellow);
		f.setVisible(true);
		f.setBounds(500, 350, 500, 300);  //f.pack();  //f.setSize(500,400);
		//f.setLocation(800, 500); // setBounds()���� setLocation �Ƚᵵ �ȴ�.
		
		
		//�͸�(����) Ŭ���� - �ݱ� �̺�Ʈ ó��
		f.addWindowListener(new WindowAdapter() { 
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
}
