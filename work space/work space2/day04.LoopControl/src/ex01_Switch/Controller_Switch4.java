

package ex01_Switch;

import java.util.Scanner;

public class Controller_Switch4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("����� ������: ");
		int total=(sc.nextInt()+sc.nextInt()+sc.nextInt());
		double avg = total/3.0;
		char grade;
		
		switch ((int)avg/10) { // �Ϸķ� �߾��� ������ ������ �����ݷб����� ���� ���ɾ�
//		                             ���̰������� ���ݰ������ �����̸� 40������������ϴ� 10���� ������ ���̽����°����̱�.
		
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
