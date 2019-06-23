package personal_ins;

import java.util.LinkedList;
import java.util.Scanner;

public class insprction {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number;
		LinkedList l1=new LinkedList();
		
		l1.add(1);
		l1.add(2);
		System.out.println(l1.get(0));
		
		
	}
}
//		do {
//		    System.out.println("다음 숫자중 하나를 입력해주세요.");
//		    while (!sc.hasNextInt()) {
//		        System.out.println("숫자를 입력해주세요.");
//		        sc.next(); //  sc형식이 nextint형식이 아닐때까지 돌리고 값 입력받아야해요.
////		                    유효성검사 sc가 int 값이면 sc가 int값을 가짐 string이랑 섞어써도 안됨.
////		                    try catch안써도 되게 만듦.
//		        
//		    }
//		    number = sc.nextInt();
//		} while (number <= 0);
//		System.out.println("숫자가 출력됩니다. " + number);
//		
//		
//	}
//
//}
