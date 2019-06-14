
package ex02.swing;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class JListex extends JPanel {
	
	String[]str= {"대한민국","중국","영국","미국","북한","멕시코"};
	JList list;
	Vector info;
	
	public JListex() {
		this.setLayout(new BorderLayout());//borderlayout 방향성을 가진것,플로우레이아웃은 
		//카드레이아웃은 한장씩 그리드레이아웃은 양쪽
		
		list=new JList();
		info=new Vector();
		for (int i = 0; i < str.length; i++) {
			info.addElement(str[i]);
			
		}
		
		list.setListData(info);
		add("Center",new JScrollPane(list));
		add("South",new JLabel("리스트 예제"));
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		JFrame f= new JFrame("jrist 예제");
		JListex pane=new JListex();
		
		
		f.setForeground(Color.blue);
		f.setBackground(Color.RED);
		f.getContentPane().add(pane);
		f.setSize(pane.getPreferredSize());
		f.setVisible(true);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}



/*
package ex02.swing;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class JListex extends JPanel {
	
	String[] str = {"대한민국", "중국","영국", "미국", "북한", "캐나다","멕시코", "브라질"};
	JList list;
	Vector info;
		
	public JListex() {
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
		JListex pane = new JListex();
		
		f.setForeground(Color.blue);
		f.setBackground(Color.lightGray);
		f.getContentPane().add(pane);
		f.setSize(pane.getPreferredSize());
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}




*/






