package oop;

public class MainEntry_Tv {
	public static void main(String[] args) {
		Tv tv = new Tv();
		tv.disp();
		
		tv.setChannel(15);
		tv.setColor("���");
		tv.disp();
		System.out.println("=========================");
		Tv tv2=new Tv(11,"green");
		tv2.disp();                       //�Ű�����2���� Tv�޼ҵ�
		System.out.println("============");
		Tv tv3=new Tv("red");
		tv3.disp();
		
	}
	
	
}




