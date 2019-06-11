package ex04_multiimplements;
//다른패키지에있으면 임포트해야함.
public class MainEntry {
	public static void main(String[] args) {
		Shape s=new Multiclass();
		s.show("도형");
		s.shview();//Shape는 부모에게만 불러서 써서 메소드사용이 협소
		            
		
		
		System.out.println("==========");
		Multiclass mc=new Multiclass();
		mc.draw();
		System.out.println(mc.num);
		System.out.println(mc.su);
		System.out.println("===============");
		TEst t=new Multiclass();
		t.view();
		System.out.println(t.str);
		
	}
}
