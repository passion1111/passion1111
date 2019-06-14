package ex01.gui;
import java.awt.*;
import java.awt.TextArea;
import javax.swing.JFrame;
public class JFrameMain extends JFrame {
	TextArea ta;
	
		public JFrameMain(String title) {
			setTitle(title);
			setBounds(350,200,400,300);
			setVisible(true);
			ta=new TextArea("문장을 넣으세요",50,30,TextArea.SCROLLBARS_BOTH);
			this.add(ta);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public static void main(String[] args) {
		new JFrameMain("JFrame은 닫기가 지원됩니다");
		
	}
	
	
}