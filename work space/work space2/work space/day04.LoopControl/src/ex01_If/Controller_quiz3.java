package ex01_If;
//문제3
//전산,영어,국어 점수 입력받아서 평균 60점이상이고, 각 과목 과락은 40점이하
//
// 
// 
import java.util.Scanner;

public class Controller_quiz3 {
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
		  

		
		  if(a<=40) a1="과락";
		  else if((60<=a)&&(a<=100)) a1="합격점수입니다.";
		  	  
		  if(b<=40) b1="과락";
		  else if((60<=b)&&(a<=100)) b1="합격점수입니다.";
		  
		  if(c<=40) c1="과락";
		  else if((60<=c)&&(a<=100)) c1="합격점수입니다.";
		  
		  if(60<=ave) {
			  if((40<a)&&(40<b)&&(40<c))
			  			  ave1="합격입니다";
			  else if(a<=40)
				  ave1="국어떄문에 불합격하셨습니다.";
			  else if(b<=40)
				  ave1="영어떄문에 불합격하셨습니다.";
			  else if(c<=40)
				  ave1="전산떄문에 불합격하셨습니다.";
		  }
		     
		   else 
			   		   ave1="불합격입니다.";

		  
		   System.out.println("****"+name+"님의 성적표입니다.****");
			System.out.println("이름:" + name);
			System.out.println("국어 :" + a + "\t영어: " + b + "\t전산: " + c);
			System.out.println(name+"님의 합격여부는 ");
			System.out.println("국어 :" + a1 + "\t영어: " + b1 + "\t전산: " + c1);
			System.out.println("당신의 평균 점수는 : "+ave);
			System.out.printf("당신은"+ave1);
			
			
		sc.close();
		  
		  
		
		  

		  
		

	}

}
