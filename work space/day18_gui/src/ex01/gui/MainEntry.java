package ex01.gui;
import java.awt.*;
import java.awt.event.*;
public class MainEntry {
	public static void main(String[] args) {
		Frame f=new Frame();
		
		System.out.println("first frame");
		f.setBackground(Color.red);
		f.setVisible(true);
		f.setSize(500, 400);
//		f.setLocation(600, 500);      //setbound()���� setloacation�Ƚᵵ �ȴ�
		f.setBounds(500,350,500,300); //f.pack(); //f.setsize(500,400);
		
		
		f.addWindowListener(new WindowAdapter() {//�͸�(����)Ŭ����- �ݱ� �̺�Ʈ ó��
		
	
		
		
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
	});
	}
}
