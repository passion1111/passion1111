package ex03.input;

// 다음을 입력받아서 출력하는 프로그램 작성
//이름,국어,영어,전산점수 입력받아서 총점,평균까지 출력하는 프로그램만들기
//result
//   이도연님의 성적표*****
//   국어 : 100, 영어: 100, 전산: 100
//   총점: 300 , 평균: 100.00
import java.util.Scanner;

public class Input_quiz2_teacher {
	public static void main(String[] args) {
		System.out.println("name=");
		String name= new Scanner(System.in).nextLine();
		int kor,eng,com;
		System.out.println("kor,eng.com score= ");
		kor=new Scanner(System.in).nextInt();
		eng=new Scanner(System.in).nextInt();
		com=new Scanner(System.in).nextInt();


			int total= kor+eng+com;
			float avg=(float) (total/3.0);
		
		System.out.println("****"+name+"님의 성적표입니다.****");
		System.out.println("이름:" + name);
		System.out.println("국어 :" + kor + "\t영어: " + eng + "\t전산: " + com);
	


		System.out.printf("총점: " + total + "\t평균: %.2f", avg);

	}

}
