package ex02.swing;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jbuttonex extends JPanel {
	
	public Jbuttonex() {
		setLayout(new GridLayout(1,2));
		AbstractButton btn=new JButton("Ȯ��");//�߻��̴ϱ� j��ư����
		add(btn);//�ǳڿ� ����
		btn= new JButton("���");
		add(btn);
	
	}
	
	
	@Override
	public Dimension getPreferredSize() {
		
		return new Dimension(400,300);
		
	}


	public static void main(String[] args) {
		JFrame f=new JFrame("JBotton sample");
		Jbuttonex panel=new Jbuttonex();
		
		f.setSize(panel.getPreferredSize());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.getContentPane().add(panel);
		
		
		
	}
}
