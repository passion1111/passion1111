package ex01.method;

import java.util.Scanner;

public class MethodQuiz1 {

	static int[] score = new int[3];	//���������� ����
	static String name;
	static int total;
	static double avg;
	static char grade;

	public static void main(String[] args) {	
//	����4] ����ó�� ���α׷��� �Լ��� ����(�и�)�� ��
//	�Է��Լ� input() - �̸�, ����, ����, ���� ����	

	input();
//	�����Լ� total() - ����+����+����
	total(score);
//	����Լ� average() - total / 3
	average(total);
//	���� grade() - ���� ���ϴ� �Լ�
	grade(avg);
//	����Լ� output() - ��� ���
	output(name, score, total, avg, grade);
	
	// end main
}

	public static int[] input() {
		Scanner sc = new Scanner(System.in);	
		System.out.print("�л� �̸� �Է� : ");
		name = sc.nextLine();
		System.out.print("���� ���� �Է� : ");
		score[0] = sc.nextInt();
		while(score[0]>100||score[0]<0) {
			System.out.println("0~100������ ���ڷ� �ٽ� �Է����ּ���.");
			score[0] = sc.nextInt();
		}
		System.out.print("���� ���� �Է� : ");
		score[1] = sc.nextInt();
		while(score[1]>100||score[1]<0) {
			System.out.println("0~100������ ���ڷ� �ٽ� �Է����ּ���.");
			score[1] = sc.nextInt();
		}
		System.out.print("���� ���� �Է� : ");
		score[2] = sc.nextInt();
		while(score[2]>100||score[2]<0) {
			System.out.println("0~100������ ���ڷ� �ٽ� �Է����ּ���.");
			score[2] = sc.nextInt();
		}
		sc.close();
		return score;	//�迭 ����		
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
		System.out.println("*********************" + name + "���� ����ǥ *********************");
		System.out.printf("%s %3d\t%s %3d\t%s %3d\t", "����:", score[0], "����:", score[1], "����:", score[2]);
		System.out.println();
		System.out.printf("%s%d\t%s%.2f\t%s%c", "����: ", total, "���:  ", avg, "����:  ", grade);
	}
} // end class
