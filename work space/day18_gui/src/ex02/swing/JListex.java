
package ex02.swing;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class JListex extends JPanel {
	
	String[]str= {"���ѹα�","�߱�","����","�̱�","����","�߽���"};
	JList list;
	Vector info;
	
	public JListex() {
		this.setLayout(new BorderLayout());//borderlayout ���⼺�� ������,�÷ο췹�̾ƿ��� 
		//ī�巹�̾ƿ��� ���徿 �׸��巹�̾ƿ��� ����
		
		list=new JList();
		info=new Vector();
		for (int i = 0; i < str.length; i++) {
			info.addElement(str[i]);
			
		}
		
		list.setListData(info);
		add("Center",new JScrollPane(list));
		add("South",new JLabel("����Ʈ ����"));
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		JFrame f= new JFrame("jrist ����");
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
	
	String[] str = {"���ѹα�", "�߱�","����", "�̱�", "����", "ĳ����","�߽���", "�����"};
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
		add("South", new JLabel("����Ʈ ����"));
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("JList ����");
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






