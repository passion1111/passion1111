package ex04.While;
//성적 입력 프로그램을 do while써서입력실수방지
//자료구조 static const는  heap영역은 gc가 알아서 관리해줌
//시스템쪽에는 블럭이 닫히지않았을떄만 살아있음.
//밑에 while(do)에 su가 선언됐어도 블럭닫았을떄까지만 살아있어서 선언위에서 선언안해줬을떄 메모리에서 사라짐. 
import java.util.Scanner;

public class While03 {
	public static void main(String[] args) {
		
		int su=new Scanner(System.in).nextInt();
		char grade=' ';
		do {
			System.out.println("당신의 점수 입력 요망 : ");
		}while(0<su ||su<101);                 //     
		
		switch (su/10) {
		case 10: 
		case 9:   grade='A';break;
		case 8:  grade='B';break;
		case 7:  grade='C';break;
		case 6:  grade='D';break;
		default:grade='F';
		}
		System.out.println("\n당신의 점수 : "+su+"==>"+grade+" 학점");
		}
}
