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
		//f.setLocation(800, 500); // setBounds()사용시 setLocation 안써도 된다.
		
		
		//익명(무명) 클래스 - 닫기 이벤트 처리
		f.addWindowListener(new WindowAdapter() { 
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
}
