package ex01.method;

import java.util.Scanner;

public class MethodQuiz1 {

	static int[] score = new int[3];	//전역변수로 선언
	static String name;
	static int total;
	static double avg;
	static char grade;

	public static void main(String[] args) {	
//	문제4] 성적처리 프로그램을 함수로 분할(분리)할 것
//	입력함수 input() - 이름, 국어, 영어, 전산 점수	

	input();
//	총점함수 total() - 국어+영어+전산
	total(score);
//	평균함수 average() - total / 3
	average(total);
//	평점 grade() - 평점 구하는 함수
	grade(avg);
//	출력함수 output() - 결과 출력
	output(name, score, total, avg, grade);
	
	// end main
}

	public static int[] input() {
		Scanner sc = new Scanner(System.in);	
		System.out.print("학생 이름 입력 : ");
		name = sc.nextLine();
		System.out.print("국어 점수 입력 : ");
		score[0] = sc.nextInt();
		while(score[0]>100||score[0]<0) {
			System.out.println("0~100까지의 숫자로 다시 입력해주세요.");
			score[0] = sc.nextInt();
		}
		System.out.print("영어 점수 입력 : ");
		score[1] = sc.nextInt();
		while(score[1]>100||score[1]<0) {
			System.out.println("0~100까지의 숫자로 다시 입력해주세요.");
			score[1] = sc.nextInt();
		}
		System.out.print("전산 점수 입력 : ");
		score[2] = sc.nextInt();
		while(score[2]>100||score[2]<0) {
			System.out.println("0~100까지의 숫자로 다시 입력해주세요.");
			score[2] = sc.nextInt();
		}
		sc.close();
		return score;	//배열 리턴		
	}
//input end
	
	public static int total(int[] score) {		
		for(int i=0; i < 3 ; i++) {
			total+=score[i];
		}
//		System.out.println(total);
		return total;
	}	//total end
	
	public static double average(int total) {
		avg = total / 3.0;
//		System.out.println(avg);
		return avg;
	}	//total end
	
	public static char grade(double avg) {
		
		if (avg >= 90 && avg <=100) grade = 'A';
		else if (avg >= 80 && avg <90) grade = 'B';
		else if (avg >= 70 && avg <80) grade = 'C';
		else if (avg >= 60 && avg <70) grade = 'D';
		else grade = 'F';
		
		return grade;
	}	//grade end
	
	public static void output(String name, int[] score, int total, double avg, char grade){
		System.out.println("*********************" + name + "님의 성적표 *********************");
		System.out.printf("%s %3d\t%s %3d\t%s %3d\t", "국어:", score[0], "영어:", score[1], "전산:", score[2]);
		System.out.println();
		System.out.printf("%s%d\t%s%.2f\t%s%c", "총점: ", total, "평균:  ", avg, "평점:  ", grade);
	}
} // end class
