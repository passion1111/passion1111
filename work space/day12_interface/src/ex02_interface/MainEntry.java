package ex02_interface;

public class MainEntry {
	public static void main(String[] args) {
		//1.자기자신으로 객체 생성
		BB b=new BB();
//		b.draw();
		System.out.println(b.su);
		System.out.println("*****************");
		//2.부모 인터페이스로 객체생성
		IDraw bb=new BB();
//		IDraw d=new IDraw();//클래스가아니기떄문에 생성안됨.
		bb.draw();
		System.out.println(bb.su);
		
	}
}
