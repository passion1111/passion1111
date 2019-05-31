
package day03.operator;


	//최단산쉬관논삼대콤
public class Ex01_Opearator {
	public static void main(String[] args) {
		   					//산술연산자:+,-,*,/,%,^...
		  int x= 10,y=20;  //변수선언하면 메모리할당시작. y는 초기화는안했지만 메모리만 확보.
		  						 //나중에 선언하면 값이정해짐.
		  int gob=x*y;
		System.out.println("x*y= " +gob);  //
		System.out.println("x*y= " +x*y);
		System.out.println(x+"*"+y+"="+(x*y));
		System.out.println("\n\n3+4+*5=" +(3+4*5));
		System.out.println("(3+4)+*5=" +( (3+4)*5 ));
		
		System.out.println("7/3="+ (7/3));//몫
		System.out.println("7%3=" + (7%3));//나머지
		
		//정수(+,-,*,/,%,...) 정수=정수
		
		
		System.out.println("7/3="+ (7/3));
		System.out.println("7/3.0="+ (7/3.0)); //점만찍어도됨.
		System.out.println("7.0/3="+ (7.0/3));
		
	}

}



/*  증감연산자
package day03.operator;


	//최단산쉬관논삼대콤
public class Opearator_test {
	public static void main(String[] args) {
		  //최단[] {} ()
		 //단항 연상자: 증감=> ++,--,~(비트부정,틸드),...
		int x = 10,y ;
		 
		
		    //y=x++;  //후위 연산 :대입먼저,연산 나중 x11,y10
		    //y=++x;  //전위 연산 :연산먼저,대입 나중 x11,y11 
		y=x--;         //마이너스 상관없음 y10,x9
		                 //단독으로 사용하면 전위 후위 상관없음.
		System.out.println("x= "+x+ "\t =" +y);  //
		
	}

}
*/


/* 비트부정
package day03.operator;


	//최단산쉬관논삼대콤
public class Ex01_Opearator {
	public static void main(String[] args) {
		  
		  int x= -7,y;
		  y=~x;  //비트부정 0을 비트부정하면 -1 ,부호연산바뀌고 마지막 8비트짜리가 1로바뀌기떄문
		           //비트부정: -(원래값+1) 출력 결과
		System.out.println("x= "+x+ "\t =" +y);  //
		
	}

}
*/
