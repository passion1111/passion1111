package ex03_Exception;

import java.util.Scanner;

public class Exception_Try01 {
	public static void main(String[] args) {
		

		try {
			   System.out.println("x,y= ");
				int x=new Scanner(System.in).nextInt();
				int y=new Scanner(System.in).nextInt();;
				System.out.println(x/y);
		
		} catch(Exception e) {  //e는 예외의 모든것
			//System.out.println(e.getMessage());
			//System.out.println("0으로 나눌수 없습니다");
			e.printStackTrace();
		}

}
}


/*
System.out.print("x , y = ");
int x = new Scanner(System.in).nextInt(); 
int y = new Scanner(System.in).nextInt();
if(y==0) 
  System.out.println("0으로 나눌수없습니다");
  System.exit(0);
  
  */
