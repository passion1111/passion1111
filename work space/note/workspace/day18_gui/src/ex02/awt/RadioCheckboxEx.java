package ex02.awt;
import java.awt.*;
public class RadioCheckboxEx{
	public static void main(String[] args){
		Frame f=new Frame("라디오형 체크박스 테스트");
		Panel p=new Panel();
		CheckboxGroup group = new CheckboxGroup();
		Checkbox radio1=new Checkbox("여자",group,false);
		Checkbox radio2=new Checkbox("남자",group,false);
		Checkbox radio3=new Checkbox("중성",group,true);
		p.add(radio1);
		p.add(radio2);
		p.add(radio3);	
		f.add(p);
		
		f.setSize(300,100);
		f.setVisible(true);
	}
}
