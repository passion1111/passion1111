package ex01.gui;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class FrameMain extends Frame {
	
		TextArea ta;
		Button btn;
		public FrameMain(String str) { //생성자 함ㅅ
			super(str);
			setBounds(350,200,400,300);
			setVisible(true);
			btn=new Button("Button");
			ta=new TextArea("문장을 넣으세요",5,30,TextArea.SCROLLBARS_VERTICAL_ONLY);
			this.add(ta); //this <-frame
			this.add(btn);
			this.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					super.windowClosing(e);
				}
				
			});
		}
		
	public static void main(String[] args) {
//		 FrameMain fm=new FrameMain("새창 띄우기");
		 new FrameMain("새창 띄우기");
		 
	}
		
		
	
}

/*
 * package ex01.gui;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameMain extends Frame {
	TextArea ta; //선언
	
	public FrameMain(String str) {
		super(str);
		setBounds(350, 200, 400, 300);
		setVisible(true);
		ta = new TextArea("문장을 넣으세요", 5, 30);
		this.add(ta);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		FrameMain fm = new FrameMain("새창 띄우기");
		
	}
}





*/
