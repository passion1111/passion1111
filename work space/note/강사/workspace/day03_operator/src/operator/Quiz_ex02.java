package operator;

import java.util.Scanner;

public class Quiz_ex02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		System.out.print("국어 점수를 입력해주세요 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력해주세요 : ");
		int eng = sc.nextInt();
		System.out.print("전산 점수를 입력해주세요 : ");
		int com = sc.nextInt();

		int total = kor + eng + com;
//		double avg = total / 3.0;
		double avg = (double)(total / 3);

		System.out.println("\n\n***** " + name + "님의 성적표 *****");
		System.out.println("국어 : " + kor + " 영어 : " + eng + " 전산 : " + com);
		System.out.printf("총점 : %d 평균 : %.2f", total, avg);

		sc.close();
	}

}


/*/
package operator;

import java.util.Scanner;

public class Quiz_ex02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("이름을 입력해주세요:");

		String name = sc.nextLine();

		System.out.println("국어 점수를 입력해주세요:");

		int kor = sc.nextInt();

		System.out.println("영어 점수를 입력해주세요:");

		int eng = sc.nextInt();

		System.out.println("전산 점수를 입력해주세요:");

		int jun = sc.nextInt();

		int sum = kor + eng + jun;

		double avg = (kor + eng + jun) / 3.0;

		System.out.printf("\n\n이름\t\t국어\t영어\t전산\t총점\t평균\n");
		System.out.printf("%s\t%3d\t%3d\t%3d\t%3d\t%.2f", name, kor, eng, jun, sum, avg);

	}

}
//*/
