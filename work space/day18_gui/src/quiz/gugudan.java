package quiz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.text.StyledEditorKit.ForegroundAction;


public class gugudan extends JFrame implements ActionListener {
	JFrame f;
	Panel p;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	Panel p2;
	JTextArea ta;
	
	
//	static String [] string = {"1��","2��","3��","4��","5��","6��","7��","8��","9��"};
//	JButton [] btn = new JButton[9]; �����丵�ҷ��� �̰� �ʿ�.

	
	
	JScrollPane scrollPane=new JScrollPane();
	public gugudan() {

		
		
		p2=new Panel();
		ta=new JTextArea();		
		f=new JFrame("������");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		f.getContentPane().setBackground(Color.black);	
		p=new Panel();
		JScrollPane scrollPane = new JScrollPane(ta);  //��ũ���� �߰�
		f.add(scrollPane);		
		ta.setEditable(false);
		 b1=new JButton("1��");
		b1.addActionListener(this);
		b2=new JButton("2��");
		b2.addActionListener(this);
		b3=new JButton("3��");
		b3.addActionListener(this);
		b4=new JButton("4��");
		b4.addActionListener(this);
		b5=new JButton("5��");
		b5.addActionListener(this);
		b6=new JButton("6��");
		b6.addActionListener(this);
		b7=new JButton("7��");
		b7.addActionListener(this);
		b8=new JButton("8��");
		b8.addActionListener(this);
		b9=new JButton("9��");
		b9.addActionListener(this);		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b8);
		p.add(b9);
//		for (int i = 1; i < 10; i++) {
//			String a=string[i];
//			btn[i]=new JButton(a);
//			btn[i].addActionListener(this);		
//			p.add(btn[i]);
//		}

		f.getContentPane().add(p);
		f.setBounds(500, 500, 600, 600);		
		p2.add(scrollPane);
		f.setVisible(true);
		f.setLayout(new BorderLayout());
		f.add("South",p);
		f.add("Center",p2);
		scrollPane.setPreferredSize(new Dimension(300, 500)); //�гξ��� ����� Ű��� Ŀ��.

		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //��ư�����°��� ���� ����
		
		if (e.getSource() == b1) {
			if (b1.getText().contentEquals("1��")) {
				for (int i = 1; i < 10; i++) {
					ta.append((b1.getText().charAt(0)-48)+"x"+i+"="+(b1.getText().charAt(0)-48)*i+"\n");
				}}}//�ؽ�Ʈ �޾ƿ��� char���� ��ȯ �� ���ڵ������� �ƽ�Ű���� ���缭48�M
		else if (e.getSource() == b2) {
			if (b2.getText().contentEquals("2��")) {
				for (int i = 1; i < 10; i++) {
					ta.append((b2.getText().charAt(0)-48)+"x"+i+"="+(b2.getText().charAt(0)-48)*i+"\n");
				}}}
		else if (e.getSource() == b3) {
			if (b3.getText().contentEquals("3��")) {
				for (int i = 1; i < 10; i++) {
					ta.append((b3.getText().charAt(0)-48)+"x"+i+"="+(b3.getText().charAt(0)-48)*i+"\n");
				}}}
		else if (e.getSource() == b4) {
			if (b4.getText().contentEquals("4��")) {
				for (int i = 1; i < 10; i++) {
					ta.append((b4.getText().charAt(0)-48)+"x"+i+"="+(b4.getText().charAt(0)-48)*i+"\n");
				}}}
		else if (e.getSource() == b5) {
			if (b5.getText().contentEquals("5��")) {
				for (int i = 1; i < 10; i++) {
					ta.append((b5.getText().charAt(0)-48)+"x"+i+"="+(b5.getText().charAt(0)-48)*i+"\n");
				}}}
		else if (e.getSource() == b6) {
			if (b6.getText().contentEquals("6��")) {
				for (int i = 1; i < 10; i++) {
					ta.append((b6.getText().charAt(0)-48)+"x"+i+"="+(b6.getText().charAt(0)-48)*i+"\n");
				}}}
		else if (e.getSource() == b7) {
			if (b7.getText().contentEquals("7��")) {
				for (int i = 1; i < 10; i++) {
					ta.append((b7.getText().charAt(0)-48)+"x"+i+"="+(b7.getText().charAt(0)-48)*i+"\n");
				}}}
		else if (e.getSource() == b8) {
			if (b8.getText().contentEquals("8��")) {
				for (int i = 1; i < 10; i++) {
					ta.append((b8.getText().charAt(0)-48)+"x"+i+"="+(b8.getText().charAt(0)-48)*i+"\n");
				}}}
		else if (e.getSource() == b9) {
			if (b9.getText().contentEquals("9��")) {
				for (int i = 1; i < 10; i++) {
					ta.append((b9.getText().charAt(0)-48)+"x"+i+"="+(b9.getText().charAt(0)-48)*i+"\n");
				}}}

		}
		
	public static void main(String[] args) {
		gugudan g=new gugudan();
		
		
	}
}
