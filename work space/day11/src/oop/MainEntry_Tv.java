package oop;

public class MainEntry_Tv {
	public static void main(String[] args) {
		Tv tv = new Tv();
		tv.disp();
		
		tv.setChannel(15);
		tv.setColor("흰색");
		tv.disp();
		System.out.println("=========================");
		Tv tv2=new Tv(11,"green");
		tv2.disp();                       //매개변수2개의 Tv메소드
		System.out.println("============");
		Tv tv3=new Tv("red");
		tv3.disp();
		
	}
	
	
}




