package ex04.While;
//while문을 이용하여 구구단 만들기
import java.util.Scanner;

public class While_gugu {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("원하는 단을 입력해주세요");
		int i=sc.nextInt();
		int j=1;
			while(j<=9) {
				System.out.println(i+"*"+j+"= "+(i*j));
					j++;	
	}
}
}