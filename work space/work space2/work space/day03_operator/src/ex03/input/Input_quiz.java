package ex03.input;

// 다음을 입력받아서 출력하는 프로그램 작성
//이름,국어,영어,전산점수 입력받아서 총점,평균까지 출력하는 프로그램만들기
//result
//   이도연님의 성적표*****
//   국어 : 100, 영어: 100, 전산: 100
//   총점: 300 , 평균: 100.00
import java.util.Scanner;

public class Input_quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("이름을 입력하세요: ");
		String name = sc.next();
		// System.out.println(name);

		System.out.println("국어 점수를 입력하세요: ");
		int a = sc.nextInt();
		// System.out.println(a);
		System.out.println("영어 점수를 입력하세요: ");
		int b = sc.nextInt();
		// System.out.println(b);
		System.out.println("전산 점수를 입력하세요: ");
		int c = sc.nextInt();
		// System.out.println(c); 값 확인
		System.out.println("****"+name+"님의 성적표입니다.****");
		System.out.println("이름:" + name);
		System.out.println("국어 :" + a + "\t영어: " + b + "\t전산: " + c);
		int sum = a + b + c;
		float ave = (float) sum / 3;

		System.out.printf("총점: " + sum + "\t평균: %.2f", ave);

	}

}
