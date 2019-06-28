package ex03.swing;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class JListEx extends JPanel {
	
	String[] str = {"대한민국", "중국","영국", "미국", "북한", "캐나다","멕시코", "브라질"};
	JList list;
	Vector info;
		
	public JListEx() {
		this.setLayout(new BorderLayout());
		list = new JList();
		info = new Vector();
		
		for (int i = 0; i < str.length; i++) {
			info.addElement(str[i]);
		}
		
		list.setListData(info);
		add("Center", new JScrollPane(list));
		add("South", new JLabel("리스트 예제"));
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("JList 예제");
		JListEx pane = new JListEx();
		
		f.setForeground(Color.blue);
		f.setBackground(Color.lightGray);
		f.getContentPane().add(pane);
		f.setSize(pane.getPreferredSize());
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}










