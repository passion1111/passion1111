package quiz;

import java.util.Scanner;

public class Quiz_ScoreEx3 {
	
	public static void main(String[] args) {
		input();
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("�������� : ");
		int kor = sc.nextInt();
		System.out.print("�������� : ");
		int eng = sc.nextInt();
		System.out.print("�������� : ");
		int com = sc.nextInt();

		process(kor, eng, com, name);
	}

	public static void process(int kor, int eng, int com, String name) {
		int total = kor + eng + com;
		double avg = total / 3.0;
		System.out.println("\n�̸� : " + name);
		System.out.println("kor : " + kor + "\teng : "+eng + "\tcom : " + com);
		System.out.printf("���� : %d\t��� : %.2f", total, avg);
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
		System.out.print("\t���� : " + grade);
	}
}