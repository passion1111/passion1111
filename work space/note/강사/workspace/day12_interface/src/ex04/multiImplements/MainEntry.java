package ex04.multiImplements;

import ex03.Abstract.Shape;

public class MainEntry {
	public static void main(String[] args) {
		Shape s = new MultiClass();
		s.show("도형이야");
		s.shview();
		
		System.out.println("--------------------");
		Test t = new MultiClass();
		t.view();
		System.out.println(t.str);
		
		System.out.println("--------------------");
		MultiClass mc = new MultiClass();
		mc.draw();
		System.out.println(mc.num);
		System.out.println(mc.su);
	}
}
