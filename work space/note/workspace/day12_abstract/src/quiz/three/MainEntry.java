package quiz.three;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Reqular r;
		Sales s;
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.println("1.내근정규직, 2.영업부직원, 3.아르바이트 중 사원 형태를 선택하세요.: ");
		
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
			default: System.out.println("1~3 중에서 선택하세요.");
					System.exit(0);
					
		} //switch end
		
	}
}











