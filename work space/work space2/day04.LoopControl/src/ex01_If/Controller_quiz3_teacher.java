package ex01_If;
//문제3
//전산,영어,국어 점수 입력받아서 평균 60점이상이고, 각 과목 과락은 40점이하
//
// 
// 
import java.util.Scanner;

public class Controller_quiz3_teacher {
	public static void main(String[] args) {

       
		

		System.out.println("국어 점수를 입력하세요: ");
		int a=new Scanner(System.in).nextInt();
		// System.out.println(a);
		System.out.println("영어 점수를 입력하세요: ");
		int b=new Scanner(System.in).nextInt();
		// System.out.println(b);
		System.out.println("전산 점수를 입력하세요: ");
		int c=new Scanner(System.in).nextInt();
		// System.out.println(c); 값 확인
	
		int sum = a + b + c;
		double ave=(a+b+c)/3.0; 
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
		  
		  if(60<=ave) {      //3과목 평균 60점 이상이어야함
               if(40<=a&&40<=b&&40<=c) {
			  System.out.printf("모든과목이 40점 이상이며 "+
					  				"평균이 %.2f로 [합격]입니다\n",ave);
               } 
               else {
            	            System.out.printf("평균은 %.2f이지만 ,",ave);
            	             if(a<40) System.out.print("국어"+a+" 점");
            	             else if(b<40) System.out.print("영어"+a+" 점");
            	             else if(c<40) System.out.print("전산"+a+" 점");
            	             System.out.println("으로 [과락 탈락]입니다.");
               }
		  }
		   else 
			   System.out.printf("평균이 %.2f로 [평균 미달로 불합격입]니다\n",ave);

		  
		  
			
		
		  
		  
		
		  

		  
		

	
}
}

//에러 고치기
