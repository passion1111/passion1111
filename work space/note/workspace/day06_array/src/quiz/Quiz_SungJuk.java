/*문제1] 이름, 점수 3개(국어,영어,전산) 
   총점, 평균 , 학점(평점) 구하는 프로그램 작성*/

/*
package quiz;

import java.util.Scanner;

public class Quiz_SungJuk {
	public static void main(String[] args) {
		//변수 선언 및 메세지 출력, 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.print("name = ");
		String name = sc.nextLine();

		System.out.print("kor, eng, com score = ");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int com = sc.nextInt();
		
		//처리(계산)
		int total = kor + eng + com;
		double avg = total / 3.0;
		char grade = ' ';
		
		if( avg >= 90 ) 		grade = 'A';		
		else if( avg >= 80 )   	grade = 'B';
		else if(  avg >= 70 ) 	grade = 'C';
		else if( avg >= 60 ) 	grade = 'D';		
		else 	grade = 'F';

		//결과 출력 
		System.out.println("\n\n***** " + name + "님의 성적표 *****");

		System.out.println("국어 : " + kor + "점   영어 : " + eng + "점   전산 : " + com + "점");

		System.out.printf("총점 : %d  평균 : %.2f  학점(평점) : %c", total, avg, grade);
		
		sc.close();
	}
}
//*/



/*
package quiz;

import java.util.Scanner;

public class Quiz_SungJuk {
	public static void main(String[] args) {
		//변수 선언 및 메세지 출력, 입력 받기
		Scanner sc = new Scanner(System.in);  //입력 객체 생성
		System.out.print("name = ");
		String name = sc.nextLine(); 

		System.out.print("kor, eng, com score = ");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int com = sc.nextInt();
		
		//처리(계산)
		int total = kor + eng + com;
		double avg = total / 3.0;
		char grade = ' ';
		
		if((avg >= 90) && (avg < 100)) 		grade = 'A';		
		else if((avg >= 80) && (avg < 90))   grade = 'B';
		else if((avg >= 70) && (avg < 80)) {
			grade = 'C';
		}	
		else if((avg >= 60) && (avg < 70)) {
			grade = 'D';		
		}	
		else {
			grade = 'F';
		}

		//결과 출력 
		System.out.println("\n\n***** " + name + "님의 성적표 *****");

		System.out.println("국어 : " + kor + " 영어 : " + eng + " 전산 : " + com);

		System.out.printf("총점 : %d 평균 : %.2f  학점(평점) : %c", total, avg, grade);
		
		sc.close();
	}
}
//*/
