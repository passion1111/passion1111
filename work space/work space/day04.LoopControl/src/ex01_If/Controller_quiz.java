package ex01_If;

// 이름, 과목3개입력받고 ,총점 평균 평점 구하기.
import java.util.Scanner;

public class Controller_quiz {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("이름을 입력하세요: ");
		String name = sc.nextLine();
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
	
		int sum = a + b + c;
		float ave = (float) sum / 3;
		String a1=null;
		String b1=null;
		String c1=null;
		String ave1=null;
		  

		
		  if(a<=59) a1="F";
		  else if((60<=a)&&(a<69)) a1="D";
		  else if((70<=a)&&(a<79)) a1="C";
		  else if((80<=a)&&(a<89)) a1="B";
		  else if(90<a) a1="A";
		  
		  if(b<=59) b1="F";
		  else if((60<=b)&&(a<69)) b1="D";
		  else if((70<=b)&&(a<79)) b1="C";
		  else if((80<=b)&&(a<89)) b1="B";
		  else if(90<a) b1="A";
		  
		  if(c<=59) c1="F";
		  else if((60<=c)&&(a<69)) c1="D";
		  else if((70<=c)&&(a<79)) c1="C";
		  else if((80<=c)&&(a<89)) c1="B";
		  else if(90<a) c1="A";
		  
		  
		  if(ave<=59) ave1="F";
		  else if((60<=ave)&&(ave<69)) ave1="D";
		  else if((70<=ave)&&(ave<79)) ave1="C";
		  else if((80<=ave)&&(ave<89)) ave1="B";
		  else if(90<ave) ave1="A";
		
		  
		   System.out.println("****"+name+"님의 성적표입니다.****");
			System.out.println("이름:" + name);
			System.out.println("국어 :" + a + "\t영어: " + b + "\t전산: " + c);
			System.out.println(name+"님의 학점은 ");
			System.out.println("국어 :" + a1 + "\t영어: " + b1 + "\t전산: " + c1);
			System.out.printf("총점: " + sum + "\t평균: %.2f ", ave ,"\t 평균학점 : "+ave1 );
			System.out.println("평균학점:"+ave1);
			
		  
		

	}

}
