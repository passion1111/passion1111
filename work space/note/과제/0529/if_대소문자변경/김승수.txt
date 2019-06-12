package quiz;

import java.util.Scanner;

//대문자<-->소문자 변경 프로그램 작성(if)	
public class Quiz_char {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);	
	  char a;
		a=sc.next().charAt(0);
		

		if((a<=90)&&(a>=65)) { a=(char) (a+32);System.out.println(a);}
		else if((97<=a)&&(a<=132) ) {a=(char)(a-32); System.out.println(a);}
		else System.out.println("문자를 입력해주세요.");
		
		
		
}

}
