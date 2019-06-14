package ex03.swing;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.Transient;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JButtonEx extends JPanel {
	
	public JButtonEx() {
		setLayout(new GridLayout(2, 1));
		AbstractButton btn = new JButton("Ȯ��");
		add(btn);
		btn = new JButton("���");
		add(btn);
	}
	
	@Override
	@Transient
	public Dimension getPreferredSize() {
		
		return new Dimension(400, 300);
	}



	public static void main(String[] args) {
		JFrame f = new JFrame("JBtton sample");
		JButtonEx panel = new JButtonEx();
		
		f.setSize(panel.getPreferredSize());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.getContentPane().add(panel);
	}

}






