package ex01.gui;

import java.awt.TextArea;

import javax.swing.JFrame;

public class JFrameMain extends JFrame {
	
	TextArea ta;
	
	public JFrameMain(String title) { //�������Լ�
		setTitle(title);
		setBounds(350, 200, 400, 300);
		setVisible(true);
		ta = new TextArea("������ ��������", 5, 30, TextArea.SCROLLBARS_BOTH);
		this.add(ta);
		
		//�ݱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JFrameMain("JFrame�� �ݱⰡ �����˴ϴ�.");
	}

}








