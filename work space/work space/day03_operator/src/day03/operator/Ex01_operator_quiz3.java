package day03.operator;
import java.util.*;

public class Ex01_operator_quiz3 {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		String b;
		b=(a>0)? "양수" :(a<0)?"음수" : "0" ;
		System.out.println(b);
		
	}

}
