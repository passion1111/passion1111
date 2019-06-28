package ex02.awt;
import java.awt.*;
class  LabelEx1 extends Frame{
	Label label1,label2,label3,label4;
	public LabelEx1(String str){
		super(str);
		setLayout(new FlowLayout());
		label1 = new Label("<봄>");
		label2 = new Label("<여름>");
		label3 = new Label("<가을>");
		label4 = new Label("<겨울>");
		
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		setSize(300,200);
		show();
	}
	public static void main(String[] args) {
		new LabelEx1("레이블 예제1");
	}
}
