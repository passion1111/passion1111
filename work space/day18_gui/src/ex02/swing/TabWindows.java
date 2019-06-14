
package ex02.swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabWindows extends JFrame 
						implements ChangeListener {
	JTabbedPane pane;
	JLabel lbl;
	
	public TabWindows(String str) {
		super(str);
		JPanel one, two, three;
		pane = new JTabbedPane();
		lbl= new JLabel("          ");
		
		one = new JPanel();
		one.add(new JLabel("ù��° ���Դϴ�"));
		one.add(new JTextField("���ڸ� �Է��ϼ���"));
		one.setBackground(Color.pink);
		pane.addTab("One", one);
		
		two = new JPanel();
		two.add(new JLabel("�ι�° ���Դϴ�"));
		two.add(new JTextField("���ڸ� �Է��ϼ���"));
		two.setBackground(Color.cyan);
		pane.addTab("Two", two);
		
		three = new JPanel();
		three.add(new JLabel("����° ���Դϴ�"));
		three.add(new JTextField("���ڸ� �Է��ϼ���"));
		three.setBackground(Color.yellow);
		pane.addTab("Three", three);
		
		pane.setSelectedIndex(0); //ó�� ������ ��
		pane.addChangeListener(this);
		this.getContentPane().add("North", new JLabel("���� ����� ��"));
		this.getContentPane().add("Center", pane);
		this.getContentPane().add("South", lbl);
		
		this.setSize(300,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int index = pane.getSelectedIndex();//�������� ��ȣ�� �����´�
		String msg = pane.getTitleAt(index); //index ���� �� ���ڿ��� ������
		msg += " ���� ���� �Ǿ����ϴ�.";
		lbl.setText(msg);
		pane.setSelectedIndex(index); //���� ������ ������ ȭ�� ��� ����

	}
	
	public static void main(String[] args) {
		new TabWindows("�� ����");
	}

}





/*
 * 
 * package ex02.swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TapWindows extends JFrame implements ChangeListener {

	
	JTabbedPane pane;
	JLabel lbl;
	
public TapWindows(String str){
		super(str);
		JPanel one,two,three;
		pane=new JTabbedPane();
		lbl=new JLabel("           ");
		
		one=new JPanel();
		one.add(new JLabel("ù���� ���Դϴ�"));
		one.add(new JTextField("���ڸ� �Է��ϼ���"));
		one.setBackground(Color.blue);
		pane.addTab("one", two);
		
		two=new JPanel();
		two.add(new JLabel("�ι��� ���Դϴ�"));
		two.add(new JTextField("���ڸ� �Է��ϼ���"));
		two.setBackground(Color.CYAN);
		pane.addTab("two", two);
		
		three=new JPanel();
		three.add(new JLabel("�ι��� ���Դϴ�"));
		three.add(new JTextField("���ڸ� �Է��ϼ���"));
		three.setBackground(Color.yellow);
		pane.addTab("three", three);
		
		pane.setSelectedIndex(0);//ó�� ������ ��
		pane.addChangeListener(this);
		this.getContentPane().add("North",new JLabel("���� ����� ��"));
		this.getContentPane().add("Center",pane);
		this.getContentPane().add("South",lbl);
		
		this.setSize(300,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {//ChangeListener������ �ڵ� �������̵�
		int index=pane.getSelectedIndex();//�������� ��ȣ�� �����´�.
		String msg=pane.getTitleAt(index);//index���� �� ���ڿ��� ������
		msg+="���� ���� �Ǿ����ϴ�.";
		lbl.setText(msg);
		pane.setSelectedIndex(index);//���� ������ ������ ȭ�� ��� ����
		
		
	}

	
	public static void main(String[] args) {
		new TapWindows("�� ����");
	}
	
 */
 
