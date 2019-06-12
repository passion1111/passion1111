package ex01.oop;

public class MainEntry {
	public static void main(String[] args) {
					//default constructor(디폴트생성자함수)
		TV tv = new TV(); //객체생성, 메모리에할당, 생성자함수 자동호출
		tv.disp();  //멤버변수 초기값 출력
		System.out.println("========================");
		tv.setChannel(15);
		tv.setColor("흰색");
		tv.disp();
		System.out.println("========================");
		
		TV tv2 = new TV(11, "yellow");
		tv2.disp();
		System.out.println("========================");
		
		TV tv3 = new TV("red");
		tv3.disp();
		
	}
}









