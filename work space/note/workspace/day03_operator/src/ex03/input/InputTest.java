package ex03.input;
//import java.util.*; // util package에 있는 모든것 갖다 올려놓음
import java.util.Scanner; // util package에 있는 Scanner 클래스 갖다 올려놓음

public class InputTest  {
	public static void main(String[] args) {
		
//		표준 입력 : System.in
		Scanner sc = new Scanner(System.in);  //입력 그릇 생성
		System.out.print("정수 데이터 입력 요망 : ");
		int su = sc.nextInt();
		
		System.out.println("\n\n입력 받은 수 : " + su);
		
	}
}
