package ex03.swing;

import javax.swing.*;
import java.awt.*;

public class JTableEx extends JFrame {
	
	JTable table;
	String[] fieldName= {"학번","국어","전산","수학" };
	String[][] data = { {"001", "60", "70", "80"},
						{"002", "70", "70", "69"},
						{"003", "88", "90", "100"},
						{"004", "50", "77", "85"},
						{"005", "95", "70", "80"},
						};
	
	public JTableEx(String str) {
		super(str);
		table = new JTable(data, fieldName);
		JScrollPane sp = new JScrollPane(table);
		getContentPane().add(sp, "Center");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTableEx("테이블예제");
	}
}











