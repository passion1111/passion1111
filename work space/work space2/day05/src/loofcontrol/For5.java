package loofcontrol;

import java.util.Scanner;

//원하는 단을 입력받아서 구구단출력하는 프로그램 작성
public class For5 {
	public static void main(String[] args) {
		
	
       Scanner scan=new Scanner(System.in);
       int  i=scan.nextInt();
       int j=0;
      
       for(j=1;j<=9;j++) {
    	 int  j0=i*j;
    	   System.out.println(i+"*"+j+"="+j0);  	   
       }
       
       
	}
}


