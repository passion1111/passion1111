//*
package ex01.operator;

// 최단산쉬관논삼대콤
public class OperatorTest {

	public static void main(String[] args) { // 시작점(진입점)
		//산술연산자 : +, - , *, /, %, ^,....
		int x = 10, y = 20;
		int gob = x * y;
		
		System.out.println(gob);
		
		System.out.println("x * y = " + gob);
		System.out.println("x * y = " + (x * y));
		
		System.out.println(x + " * " +  y +" = " + (x * y));
		
		System.out.println("\n\n3 + 4 * 5 = " + (3+4*5));
		System.out.println("(3 + 4) * 5 = " + ( (3+4)*5 ));
		
		System.out.println("\n7 / 3 = " + ( 7 / 3 )); //몫
		System.out.println("7 % 3 = " + ( 7 % 3 ));  // 나머지
		
		//정수(+, -, *, /, %,.....) 정수 = 정수 
		System.out.println("\n7 / 3 = " + ( 7 / 3 ));  //2
		System.out.println("7 / 3.0 = " + ( 7 / 3.0 )); //2.333
		System.out.println("7. / 3. = " + ( 7. / 3. ));
		
	} // end main
} // end class
//*/

/*
package ex01.operator;

// 최단산쉬관논삼대콤
public class OperatorTest {

	public static void main(String[] args) { // 시작점(진입점)
		//단항연산자 : 증감 ==> ++, --, ~ ,....
		int x = 10, y;
		
		y = ~x;  //비트부정 :  -(원래값 + 1) ==> 출력 결과
		
		System.out.println("x = " + x + "\ty = " + y);
		
	} // end main
} // end class
//*/


/*
package ex02.operator;

// 최단산쉬관논삼대콤
public class OperatorTest {

	public static void main(String[] args) { // 시작점(진입점)
		//단항연산자 : 증감 ==> ++, --, ~ ,....
		int x = 10, y;
		
		//y = x++;  // 후위연산 : 대입먼저, 연산나중
		//y = ++x;    // 전위연산 : 연산먼저, 대입나중
		//y = x--; 
		
		++x; //x++;
		y = x;
		
		System.out.println("x = " + x + "\ty = " + y);
		
	} // end main
} // end class
//*/