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
//		    System.out.println("���� ������ �ϳ��� �Է����ּ���.");
//		    while (!sc.hasNextInt()) {
//		        System.out.println("���ڸ� �Է����ּ���.");
//		        sc.next(); //  sc������ nextint������ �ƴҶ����� ������ �� �Է¹޾ƾ��ؿ�.
////		                    ��ȿ���˻� sc�� int ���̸� sc�� int���� ���� string�̶� ����ᵵ �ȵ�.
////		                    try catch�Ƚᵵ �ǰ� ����.
//		        
//		    }
//		    number = sc.nextInt();
//		} while (number <= 0);
//		System.out.println("���ڰ� ��µ˴ϴ�. " + number);
//		
//		
//	}
//
//}
