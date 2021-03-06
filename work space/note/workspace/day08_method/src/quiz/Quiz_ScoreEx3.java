package quiz;

import java.util.Scanner;

public class Quiz_ScoreEx3 {
	
	public static void main(String[] args) {
		input();
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		System.out.print("전산점수 : ");
		int com = sc.nextInt();

		process(kor, eng, com, name);
	}

	public static void process(int kor, int eng, int com, String name) {
		int total = kor + eng + com;
		double avg = total / 3.0;
		System.out.println("\n이름 : " + name);
		System.out.println("kor : " + kor + "\teng : "+eng + "\tcom : " + com);
		System.out.printf("총점 : %d\t평균 : %.2f", total, avg);
		grade(avg);
	}

	public static void grade(double avg) {
		char grade = ' ';
		switch ((int) avg / 10) {
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
		}
		System.out.print("\t학점 : " + grade);
	}
}
