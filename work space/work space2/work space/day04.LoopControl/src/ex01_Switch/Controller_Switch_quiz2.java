

package ex01_Switch;
//문제5
//  년도/월 입력받으면  몇일까지 있는지 출력하는 프로그램 짜기.
//   2월은 윤년이 있기떄문에 2월까지는 몇년까지있는지 물어봐서 윤년이면 29일까지 평년이면 28일까지있다고 출력하기.
import java.util.Scanner;

public class Controller_Switch_quiz2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("원하는 달을 입력해주세요: ");
		int moon=sc.nextInt();
	    String day=null;
	
		
		switch (moon) {
		
		case 1:  case 3:  case 5: case 7: case 8: case 10: 		case 12:
			day="31";
			break;
		case 2: {
			System.out.println("년도를 입력해주세요");
			  int year=sc.nextInt();
			if(year%4==0&&(year%100!=0)|| (year%400==0)) {
			day="28";
			}
			day="29";
			break;
			
			
		
		}
		case 4:  case 6: case 9:  case 11: day="30"; break;
		
		
	
		
		default :day="다시입력해주세요"; break;
		
		}
		
	
		
		System.out.println(moon+"월달은"+day+"까지 있습니다.");

		}// switch end
	

	}

/*    다른 예제 생각해보기 
 *    인풋 값 받고
 *     if(((input%2&&input!=8)==0)){
 *       if(input==2){
 *       	입력받고
 *           %4==0&& %400 ||또는 %100!=0이면
 *            29일}
 *            else 28일
 *           }
 *           else  30일
 *     day=30일까지입니다.
 *     else if(input%2
 */
 
