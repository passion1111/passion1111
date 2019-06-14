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
		AbstractButton btn=new JButton("확인");//추상이니까 j버튼으로
		add(btn);//판넬에 붙임
		btn= new JButton("취소");
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
