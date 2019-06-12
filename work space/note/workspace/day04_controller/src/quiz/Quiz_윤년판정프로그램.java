/*문제2] 윤년/평년 판정 프로그램 작성
   if( year % 4 == 0 ) 
	if( year % 100 != 0) || if( year % 400 == 0)
		"윤년" 
*/
package quiz;

import java.util.Scanner;

public class Quiz_윤년판정프로그램 {
	public static void main(String[] args) {
		//1. 변수선언
		int year;
		String str ="";
		boolean flag = false;
		//2. 메시지 출력 및 입력 받기
		System.out.print("년도 입력 하세요 : ");
		year = new Scanner(System.in).nextInt();
		
		//3. 처리(계산)
		if( (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
					flag = true;		
		} // if  end
		
//		if( year % 4 == 0 ) {
//			if( (year % 100 != 0) || ( year % 400 == 0) ) {
//				flag = true;
//			} // if in end				
//		} // if out end
		
		str = ( flag == true ) ? "윤년" : "평년";
		
		//4. 결과출력
		System.out.println(year + "년 ===> " + str);		
	}
}








