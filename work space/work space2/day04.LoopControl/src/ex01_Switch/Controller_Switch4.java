

package ex01_Switch;

import java.util.Scanner;

public class Controller_Switch4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("당신의 점수는: ");
		int total=(sc.nextInt()+sc.nextInt()+sc.nextInt());
		double avg = total/3.0;
		char grade;
		
		switch ((int)avg/10) { // 일렬로 쭉쓰면 다음에 만나는 세미콜론까지가 같은 명령어
//		                             줄이고싶으면 지금같은경우 안줄이면 40개까지적어야하니 10으로 나눠서 케이스적는거줄이기.
		
		case 10:
		case 9: grade='A'; break;
		case 8: grade='B'; break;
		case 7: grade='C'; break;
		case 6: grade='D'; break;
		default :grade='F'; break;
		
			
		
	
		
			

		}// switch end
	System.out.println("total="+total);
	System.out.println("grade="+grade);
	}
}

