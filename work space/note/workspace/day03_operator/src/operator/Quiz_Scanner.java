/*문제2] 다음을 입력 받아서 출력하는 프로그램 작성
  이름, 국어, 영어, 전산 점수 입력 받아서
  총점, 평균 까지 출력하는


 result>
  이도연님의 성적표 *****
  국어 : 100, 영어: 100, 전산 : 100
  총점 : 300, 평균: 100.00 
*/
package operator;

import java.util.Scanner;

public class Quiz_Scanner {
	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in); //입력 객체 생성
		int kor, eng, com;
		
		System.out.print("name = ");
		String name = sc.nextLine();
		
		System.out.print("kor, eng, com score = ");

		int total = sc.nextInt() + sc.nextInt() + sc.nextInt();
		double avg = total / 3.0;
				
		System.out.println("\n\n***** " + name + "님의 성적표 *****");
		//System.out.println("국어 : " + kor + " 영어 : " + eng + " 전산 : " + com);
		System.out.printf("총점 : %d 평균 : %.2f", total, avg); */
		
		
	  System.out.print("name = "); 
	  String name = new Scanner(System.in).nextLine();

	  System.out.print("kor, eng, com score = "); 
	  int kor = new Scanner(System.in).nextInt(); 
	  int eng = new Scanner(System.in).nextInt(); 
	  int com = new Scanner(System.in).nextInt();
	  
	  int total = kor + eng + com; double avg = total / 3.0;
	  
	  System.out.println("\n\n***** " + name + "님의 성적표 *****");
	  
	  System.out.println("국어 : " + kor + " 영어 : " 
			  						+ eng + " 전산 : " + com);
	  
	  System.out.printf("총점 : %d 평균 : %.2f", total, avg);
		 
	}

}









