package ex01.gui;

import java.awt.TextArea;

import javax.swing.JFrame;

public class JFrameMain extends JFrame {
	
	TextArea ta;
	
	public JFrameMain(String title) { //생성자함수
		setTitle(title);
		setBounds(350, 200, 400, 300);
		setVisible(true);
		ta = new TextArea("문장을 넣으세요", 5, 30, TextArea.SCROLLBARS_BOTH);
		this.add(ta);
		
		//닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JFrameMain("JFrame은 닫기가 지원됩니다.");
	}

}








