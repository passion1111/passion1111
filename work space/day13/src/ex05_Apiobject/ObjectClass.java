package ex05_Apiobject;

class Point{
	
}

public class ObjectClass {
	public static void main(String[] args) {
		Point pt=new Point();
		System.out.println("포인트 pt 정보");
		System.out.println("class name:"+pt.getClass());//해당클래스의 전체주소나옴.
		System.out.println("hash code"+pt.hashCode());//객체가 생성된 위치값을 10진수값으로보여줌.													//실제로 메모리체계는 16진수이다.
		System.out.println("object String:"+pt.toString());//16진수로 표시해줌. toString과 hashcode는동일
		System.out.println("object String:"+pt);			//차이는 10진수로 보여주냐 16진수로 보여주느냐
		System.out.printf("10진수 %d \n", 0x15db9742);
		System.out.println("=============================");
		Point pt2=new Point();//1과2
		System.out.println("포인트 pt2 정보");
		System.out.println("class name:"+pt2.getClass());//해당클래스의 전체주소나옴.
		System.out.println("hash code"+pt2.hashCode());//객체가 생성된 위치값을 10진수값으로보여줌.													//실제로 메모리체계는 16진수이다.
		System.out.println("object String:"+pt2.toString());//16진수로 표시해줌. toString과 hashcode는동일
		System.out.println("object String:"+pt2);
	
		System.out.println("=============================");
		System.out.println("pt2.tostring() : tostring()의 의미");
		System.out.println(pt2.getClass().getName()+'@'
				+Integer.toHexString(pt2.hashCode()));
		System.out.println("////////////////////////////////");
		Point pt3=new Point();
	
		if(pt.hashCode()==pt3.hashCode())    System.out.println("같다");
		else    	System.out.println("다르다");
		System.out.println("*************************************");
		Point pt4;//그릇만 선언 pt4번이라고 pt는 있었음. 힙영역어딘가에 pt에대한것이 있었을것.
		pt4=pt;//결국 pt와 pt4을 같은 주소참조를 하라고 선언해준것.
		if(pt.hashCode()==pt4.hashCode())System.out.println("같다");
		else System.out.println("다르다");
	}
	
}
