package ex05_Apiobject;

class Circle{
	int x,y;
	
}

public class EqualsMain {
	public static void main(String[] args) {
		Circle c1=new Circle();
		Circle c2=new Circle();
		
		System.out.println("c1 :"+c1.hashCode());
		System.out.println("c2 :"+c2.hashCode());
		
		
		if(c1==c2)System.out.println("같다");
		else System.out.println("다르다");//다른이유는 주소참조가 다르기떄문.
		
		int x=3,y=3;
		System.out.println("기본 자료형 비교");
		if(x==y)System.out.println("같다");//같다.
		else System.out.println("다르다");
		
		System.out.println("참조자료형 비교");
		String str1=new String("Korea");
		String str2=new String("Korea");
		if(str1==str2)System.out.println("같다");
		else System.out.println("다르다");//다르다 
		
		System.out.println("*******equlas() method 비교**********");
		if(str1.equals(str2))System.out.println("같다");//eqals.는 똑같아야함.
		else System.out.println("다르다");// equalsignorecase는 문자열만 똑같으면됨
	}
}
