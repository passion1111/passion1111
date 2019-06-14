package ex02.swing;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class CheckRadioEx extends JFrame {
	JCheckBox win,linux,solaris;
	JRadioButton man,woman;
	
	public CheckRadioEx(String str) {
		super(str);
		getContentPane().setLayout(new FlowLayout());
		win=new JCheckBox("������",true);
		linux=new JCheckBox("������",false);
		solaris=new JCheckBox("�ֶ󸮽�",false);
		
		ButtonGroup group=new ButtonGroup();
		man=new JRadioButton("����",true);
		woman=new JRadioButton("����",false);
		group.add(man);
		group.add(woman);
		
		getContentPane().add(win);
		getContentPane().add(linux);
		getContentPane().add(solaris);
		getContentPane().add(man);
		getContentPane().add(woman);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300,150,250,200);
		this.setVisible(true);
	
	}
	public static void main(String[] args) {
		new CheckRadioEx("üũ�ڽ��� ���� ��ư �׽�Ʈ");
	}
}
