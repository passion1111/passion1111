package quiz.gugudan;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GuGuFrame extends Frame implements ActionListener {
	TextArea tx=new TextArea("---������---",7,30);
	
	public GuGuFrame(String title){
		super(title);
		Panel p=new Panel();
		Panel p1=new Panel();
		
		Button btn2 = new Button("2��");
		Button btn3 = new Button("3��");
		Button btn4 = new Button("4��");
		Button btn5 = new Button("5��");
		Button btn6 = new Button("6��");
		Button btn7 = new Button("7��");
		Button btn8 = new Button("8��");
		Button btn9 = new Button("9��");
		
		setLayout(new BorderLayout());
		setBounds(350, 250, 320, 200);   //setSize(320, 200);
		setResizable(false);  //ũ�� ���� ����
		p.add(tx);
		add("North",p); 
		p1.add(btn2); p1.add(btn3); p1.add(btn4); p1.add(btn5); p1.add(btn6);
		p1.add(btn7); p1.add(btn8); p1.add(btn9);
		add("South",p1);
		btn2.addActionListener(this); btn3.addActionListener(this); btn4.addActionListener(this);
		btn5.addActionListener(this); btn6.addActionListener(this); btn7.addActionListener(this);
		btn8.addActionListener(this); btn9.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {  //�ݱ� �̺�Ʈ ó�� (�͸� Ŭ����)
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}	
		}); 
	
	}
	
	public void actionPerformed(ActionEvent e) {
		char chk = e.getActionCommand().charAt(0);
		int dan = (int)chk - 48;
		System.out.println(dan);
			tx.append("\n---" + chk + "�� ---");
			for (int i = 1; i < 10; i++) {
				tx.append("\n" + chk + " * " + i + " = " + dan*i);
			}
	}
}
