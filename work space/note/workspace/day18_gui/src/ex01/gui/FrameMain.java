package ex01.gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameMain extends Frame {
	TextArea ta; //����
	Button btn;
	
	public FrameMain(String str) {  // �������Լ� 
		super(str);
		setBounds(350, 200, 400, 300);
		setVisible(true);
		btn = new Button("Button1");
		ta = new TextArea("������ ��������", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
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
		//FrameMain fm = new FrameMain("��â ����");
		new FrameMain("��â ����");
	}
}





