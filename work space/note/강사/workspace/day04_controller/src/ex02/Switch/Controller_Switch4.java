package ex02.Switch;

import java.util.Scanner;

public class Controller_Switch4 {
	public static void main(String[] args) {
		System.out.print("input jumsu(k,e,c) = ");
		Scanner sc = new Scanner(System.in);
		int total = ( sc.nextInt() + sc.nextInt() + sc.nextInt() );
		double avg = total / 3.0;
		char grade;
		
		switch ( (int)avg / 10 ) { //�Ǽ��� �ȵ�
			case 10:	
			case 9 : grade ='A'; break;
			case 8 : grade ='B'; break;
			case 7 : grade ='C'; break;
			case 6 : grade ='D'; break;
			default : grade ='F';
		} //switch end
		
		System.out.println("\n\n" + total + " ==> " + grade +"����");
		System.out.println(avg + "��� ---> " + grade + "����");
	}
}







