package quiz.three;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Reqular r;
		Sales s;
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.println("1.����������, 2.����������, 3.�Ƹ�����Ʈ �� ��� ���¸� �����ϼ���.: ");
		
		choice = sc.nextInt();
		
		switch ( choice ) {
			case 1: r = new Reqular();
					r.input();
					r.display();
				break;
				
			case 2: s = new Sales();
					s.display();
					break;
					
//			case 3: PartTime p = new PartTime();
//					p.display();
//					break;	
			default: System.out.println("1~3 �߿��� �����ϼ���.");
					System.exit(0);
					
		} //switch end
		
	}
}











