package ex02.awt;
import java.awt.*;
import java.awt.event.*;
class ContainerEx1 extends Frame implements ContainerListener, ActionListener{
	Panel p;
	Button b1, b2;
	public ContainerEx1(String str){
		super(str);
		p = new Panel();
		p.setSize(200,200);
		add("Center",p);
		p.addContainerListener(this);
		b1 = new Button("컴포넌트 추가");
		b1.addActionListener(this);
		add("South",b1);
		setSize(300,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("컴포넌트 추가")){
			p.add("Center",b2 = new Button("추가버튼"));
			b1.setLabel("컴포넌트 제거");
		}else{
			p.remove(b2);
			b1.setLabel("컴포넌트 추가");
		}
	}
	public void componentAdded(ContainerEvent e){
		setTitle("컴포넌트 컨터이너에 추가");
	}
	public void componentRemoved(ContainerEvent e){
		setTitle("컴포넌트 컨터이너에서 제거");
	}
	public static void main(String[] args) {
		new ContainerEx1("컨테이너 이벤트");
	}
}
