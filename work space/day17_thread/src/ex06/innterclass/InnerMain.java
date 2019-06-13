//*
package ex06.innterclass;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerMain { // outer class
	
	
	
	public static void main(String[] args) {
		
		Frame frame = new Frame("이벤트 처리 - 이너클래스");
		Button btn = new Button("Button-Start");
		
		//2.
//		EventHandler handler = new InnerMain().new EventHandler();
//		btn.addActionListener(handler);
		
		//button event
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("ActionEvent 발생했습니다.");
				System.out.println(e.getActionCommand());
				System.out.println(e.getSource());
				
			}
		});
		
		//frame event
		frame.addWindowListener(new WindowAdapter() { //익명 클래스

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowlistener는 인터페이스7개 살려서 클래스로만듬
			
		});
		frame.add(btn);
		frame.setVisible(true);
		frame.setSize(300, 200);
		frame.setLocation(300, 150);
		
	}
}





//*/



/*
package ex06.innterclass;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerMain { // outer class
	
	
	
	public static void main(String[] args) {
		
		Frame frame = new Frame("이벤트 처리 - 이너클래스");
		Button btn = new Button("Button-Start");
		
		//2.
//		EventHandler handler = new InnerMain().new EventHandler();
//		btn.addActionListener(handler);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //익명(무명)클래스
				//System.out.println("ActionEvent 발생했습니다.");
				System.out.println(e.getActionCommand());
				System.out.println(e.getSource());
				
			}
		});
		
		
		frame.add(btn);
		frame.setVisible(true);
		frame.setSize(300, 200);
		frame.setLocation(300, 150);
		
	}
}
/*/



/*
package ex06.inner;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerMain { // outer class
	
	class EventHandler implements ActionListener { //inner class

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("ActionEvent 발생했습니다.");			
		}
	}
	
	public static void main(String[] args) {
		
		Frame frame = new Frame("이벤트 처리 - 이너클래스");
		Button btn = new Button("Button-Start");
		
		//1.
		EventHandler handler = new InnerMain().new EventHandler();
		btn.addActionListener(handler);
		
		
		frame.add(btn);
		frame.setVisible(true);
		frame.setSize(300, 200);
		frame.setLocation(300, 150);
		
	}
}
//*/




