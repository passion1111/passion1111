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
//		f.setLocation(600, 500);      //setbound()사용시 setloacation안써도 된다
		f.setBounds(500,350,500,300); //f.pack(); //f.setsize(500,400);
		
		
		f.addWindowListener(new WindowAdapter() {//익명(무명)클래스- 닫기 이벤트 처리
		
	
		
		
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
	});
	}
}
