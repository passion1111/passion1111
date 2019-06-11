package ex02.Interface;

public class Mainentry {
	public static void main(String[] args) {
		//1. 자기 자신으로 객체 생성
		BB b = new BB();
		b.draw();
		System.out.println(b.su);
		System.out.println("------------------------");
		//2. 부모 인터페이스로 객체 생성
		IDraw bb = new BB();
		bb.draw();
		System.out.println(bb.su);
	}
}
