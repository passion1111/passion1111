
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
		one.add(new JLabel("첫번째 탭입니다"));
		one.add(new JTextField("문자를 입력하세요"));
		one.setBackground(Color.pink);
		pane.addTab("One", one);
		
		two = new JPanel();
		two.add(new JLabel("두번째 탭입니다"));
		two.add(new JTextField("문자를 입력하세요"));
		two.setBackground(Color.cyan);
		pane.addTab("Two", two);
		
		three = new JPanel();
		three.add(new JLabel("세번째 탭입니다"));
		three.add(new JTextField("문자를 입력하세요"));
		three.setBackground(Color.yellow);
		pane.addTab("Three", three);
		
		pane.setSelectedIndex(0); //처음 보여줄 탭
		pane.addChangeListener(this);
		this.getContentPane().add("North", new JLabel("탭을 사용한 예"));
		this.getContentPane().add("Center", pane);
		this.getContentPane().add("South", lbl);
		
		this.setSize(300,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int index = pane.getSelectedIndex();//현재탭의 번호를 가져온다
		String msg = pane.getTitleAt(index); //index 위에 탭 문자열을 가져옴
		msg += " 탭이 선택 되었습니다.";
		lbl.setText(msg);
		pane.setSelectedIndex(index); //현재 선택한 탭으로 화면 출력 변경

	}
	
	public static void main(String[] args) {
		new TabWindows("탭 예제");
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
		one.add(new JLabel("첫번쨰 탭입니다"));
		one.add(new JTextField("문자를 입력하세요"));
		one.setBackground(Color.blue);
		pane.addTab("one", two);
		
		two=new JPanel();
		two.add(new JLabel("두번쨰 탭입니다"));
		two.add(new JTextField("문자를 입력하세요"));
		two.setBackground(Color.CYAN);
		pane.addTab("two", two);
		
		three=new JPanel();
		three.add(new JLabel("두번쨰 탭입니다"));
		three.add(new JTextField("문자를 입력하세요"));
		three.setBackground(Color.yellow);
		pane.addTab("three", three);
		
		pane.setSelectedIndex(0);//처음 보여줄 탭
		pane.addChangeListener(this);
		this.getContentPane().add("North",new JLabel("탭을 사용한 예"));
		this.getContentPane().add("Center",pane);
		this.getContentPane().add("South",lbl);
		
		this.setSize(300,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {//ChangeListener때문에 자동 오버라이드
		int index=pane.getSelectedIndex();//현재탭의 번호를 가져온다.
		String msg=pane.getTitleAt(index);//index위에 탭 문자열을 가져옴
		msg+="탭이 선택 되었습니다.";
		lbl.setText(msg);
		pane.setSelectedIndex(index);//현재 선택한 탭으로 화면 출력 변경
		
		
	}

	
	public static void main(String[] args) {
		new TapWindows("탭 예제");
	}
	
 */
 
