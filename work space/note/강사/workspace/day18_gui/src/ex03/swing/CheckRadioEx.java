package ex03.swing;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class CheckRadioEx extends JFrame {
	
	JCheckBox win, linux, solaris;
	JRadioButton man, woman;
	
	public CheckRadioEx(String str) {
		super(str);
		getContentPane().setLayout(new FlowLayout());
		win = new JCheckBox("윈도우", true);
		linux = new JCheckBox("linux", false);
		solaris = new JCheckBox("solaris", true);
		
		ButtonGroup group = new ButtonGroup();
		man = new JRadioButton("남자", true);
		woman = new JRadioButton("여자", false);
		group.add(man);
		group.add(woman);
		
		getContentPane().add(win);
		getContentPane().add(linux);
		getContentPane().add(solaris);
		getContentPane().add(man);
		getContentPane().add(woman);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300, 150, 250, 200);
		this.setVisible(true);
	} // end
	
	public static void main(String[] args) {
		new CheckRadioEx("체크박스와 라디오버튼 테스트");
	}
}











