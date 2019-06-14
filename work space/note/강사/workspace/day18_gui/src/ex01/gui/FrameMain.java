package ex01.gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameMain extends Frame {
	TextArea ta; //선언
	Button btn;
	
	public FrameMain(String str) {  // 생성자함수 
		super(str);
		setBounds(350, 200, 400, 300);
		setVisible(true);
		btn = new Button("Button1");
		ta = new TextArea("문장을 넣으세요", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		this.add(ta);
		//this.add(btn);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		//FrameMain fm = new FrameMain("새창 띄우기");
		new FrameMain("새창 띄우기");
	}
}





