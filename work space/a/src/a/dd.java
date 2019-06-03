package a;

import java.util.InputMismatchException;
import java.util.Scanner;

public class dd {
	
	
	

		public static void main(String[] args) {

			input();

		}

		public static void input() {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("이름 국어 영어 전산 점수를 차례대로 입력하세요");
				String user = sc.next();
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				int num3 = sc.nextInt();
				System.out.println(user + " 님의 점수");
				System.out.println("국어\t 영어 \t 전산");
				System.out.println(num1 + "\t" + num2 + "\t" + num3 + "\t");
				output(num1, num2, num3);
			} catch (InputMismatchException e) {

				e.printStackTrace();
			}
		}

		public static int Total(int num1, int num2, int num3) {

			int sum = num1 + num2 + num3;
			return sum;

		}

		public static double Average(int sum) {

			double avg = sum / 3;
			return avg;

		}

		public static char Grade(double avg) {
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
			return grade;
		}

		public static void output(int num1, int num2, int num3) {
			int to = Total(num1, num2, num3);
			double avg = Average(to);
			char grade = Grade(avg);
			System.out.println("총점은 = " + to);
			System.out.printf("평균은 = %.2f", avg);
			System.out.println("\n학점은 = " + grade);
			System.out.println("");

		}

	}



