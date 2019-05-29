package ex01_If;
//문제 이름,점수3개(국어,영어,전산)
//총점,평균,학점(평점)구하는 프로그램 작성.
import java.util.Scanner;

public class Controller_if3 {
	public static void main(String[] args) {
			Scanner scan=new Scanner(System.in);
		System.out.print("integer su1,su2 data input : ");
		
		    int su1=scan.nextInt();
		    int su2=scan.nextInt();
		    //합산 평균이 불합격-x<40, 1회 기회 제공 75<x,2회 기회 제공<60 75이상 합격
		          double avg=(su1+su2)/2.;
		             String msg=null;
		             if(avg<=40) msg="불합격";
		             else if((60<=avg)&&(avg<75))  msg="2회 기회 제공";		            	  
		             else if((40<=avg)&&(avg<=60))msg="1회 기회 제공" ;
		             else msg="합격";
		             System.out.println("\n\n 평균"+avg+"\n결과는 : "+msg);
		             
		            	 
		            	 
		            	   
		          
		    
						}

}
