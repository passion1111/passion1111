package quiz;

import java.util.Scanner;

public class SungjukArrayExam {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("입력할사람 수를 정하시오 : ");
		int saramsu = scan.nextInt();
		
		// 배열 선언 및 생성. 메모리에 할당
		String namearr[] = new String[saramsu];
		int korscore[] = new int[saramsu];
		int engscore[] = new int[saramsu];
		int matscore[] = new int[saramsu];
		int totalarr[] = new int[saramsu];
		float avgarr[] = new float[saramsu];
		// input 
		for (int i = 0; i < saramsu; i++) {
			System.out.println("이름을 입력하세요 : ");
			namearr[i] = scan.next();

			System.out.println("국어 점수를 입력하세요 : ");
			korscore[i] = scan.nextInt();

			System.out.println("영어 점수를 입력하세요 : ");
			engscore[i] = scan.nextInt();

			System.out.println("전산 점수를 입력하세요 : ");
			matscore[i] = scan.nextInt();

			totalarr[i] = korscore[i] + engscore[i] + matscore[i];

			avgarr[i] = totalarr[i] / 3.0f;

		} 
		// output
		for (int i = 0; i < saramsu; i++) {
			System.out.println(namearr[i] + "님의 성적표");
			System.out.printf("국어 : %d, 영어 : %d, 전산 : %d \n", korscore[i], engscore[i], matscore[i]);
			System.out.printf("총점 : %d, 평균 : %.2f\n", totalarr[i], avgarr[i]);
		}

	}
}
