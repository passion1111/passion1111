package ex01.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.List;
import java.awt.Panel;

import javax.swing.JFrame;

public class BorderLayoutMain extends JFrame {
	
	public BorderLayoutMain() { //»ý¼ºÀÚÇÔ¼ö
		
		Button btn1 = new Button("EAST");
		Button btn2 = new Button("West");
		Button btn3 = new Button("Center");
		Button btn4 = new Button("South");
		Button btn5 = new Button("North");
		
		Panel p = new Panel();
		List list = new List(5, true);
		list.add("±è¿¬¾Æ");
		list.add("¹ÚÅÂÈ¯");
		list.add("ÇÑÁö¹Î");
		list.add("±è¿µ»ï");
		list.add("ÀÌ½Â¸¸");
		
		p.add(list);
		add(p);
		
		add(btn1, BorderLayout.EAST);
		add(btn2, BorderLayout.WEST);
		add(p, BorderLayout.CENTER);
		
		add("South", btn4);
		add("North", btn5);
		
		setTitle("BoarderLayout Test");
		setBounds(350, 200, 400, 300);
		setVisible(true);
		
		//´Ý±â
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BorderLayoutMain();
	}
}









