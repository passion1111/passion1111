package ex06_Wraper;

class Point{
	
}

public class MainEntry {
	public static void main(String[] args) {
		
		Integer Ia=new Integer(10);
		Integer Ib=new Integer("10");
		//기본자료형을 레퍼자료형으로 바꾸려면 무조건 메소드의 도움을 받았어야했다.
		//지금은 굳이 그러지않고 
		String su="30";
		Point pt=new Point();
		
		System.out.println(pt);
		System.out.println(pt.toString());
		System.out.println(Ia);
		System.out.println(Ia.getClass().getName()+'@'+Integer.toHexString(Ia.hashCode()));
		//클래스의 주소가아닌 값이 나온다.
		int x=77;
		double y=5.5;
		System.out.println(x+","+y);
//		y=x;는 묵시적으로 형변환이 일어나는데
		x=(int)y;//는 명시적형변환이 필요함
		System.out.println(x+","+y);
		
		//Boxing vs Unboxing
		int c=Ia.intValue();//jdk4.x이전에 사용하던 메소드. 클래스형 자료형을 기본형자료형으로 저장한다.
		int d=Ib;//jdk 5.x이후부터 autoboxing,unboxing된다.
		int num=Integer.parseInt(su);
		
		System.out.println(c+num);
		System.out.println(c+d);
		System.out.println(Ia.MAX_VALUE);//21억~
		System.out.println(Ia.MIN_VALUE);//-21억~
		
//		Double dd=12.34;
		Double dd=new Double(12.34);
		
		System.out.println(dd.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		
		System.out.println("================================");
		c=(int)dd.doubleValue();
		System.out.println("형변환돤 c의값은?"+c);
		int e=Integer.parseInt("123");// 이것은 문자를 숫자로.
		int f=Integer.parseInt("111111", 2);//2진수의값을 10진수값으로 계산
		System.out.println(e+20);//그래서 숫자계산이됨 e는 123+숫자해봄
		System.out.println(f);
		
		int xx=3;//stack memory;
		Integer yy=new Integer(3); //heap memory
		
		xx=yy.intValue();//jdk 4.0이전에는 변환하는 함수 사용해야했음.
		xx=yy;//autoboxing /unboxing <-- jdk5.0이후부터~
	}

}
