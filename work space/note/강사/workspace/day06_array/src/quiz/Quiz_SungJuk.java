/*����1] �̸�, ���� 3��(����,����,����) 
   ����, ��� , ����(����) ���ϴ� ���α׷� �ۼ�*/

/*
package quiz;

import java.util.Scanner;

public class Quiz_SungJuk {
	public static void main(String[] args) {
		//���� ���� �� �޼��� ���, �Է� �ޱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("name = ");
		String name = sc.nextLine();

		System.out.print("kor, eng, com score = ");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int com = sc.nextInt();
		
		//ó��(���)
		int total = kor + eng + com;
		double avg = total / 3.0;
		char grade = ' ';
		
		if( avg >= 90 ) 		grade = 'A';		
		else if( avg >= 80 )   	grade = 'B';
		else if(  avg >= 70 ) 	grade = 'C';
		else if( avg >= 60 ) 	grade = 'D';		
		else 	grade = 'F';

		//��� ��� 
		System.out.println("\n\n***** " + name + "���� ����ǥ *****");

		System.out.println("���� : " + kor + "��   ���� : " + eng + "��   ���� : " + com + "��");

		System.out.printf("���� : %d  ��� : %.2f  ����(����) : %c", total, avg, grade);
		
		sc.close();
	}
}
//*/



/*
package quiz;

import java.util.Scanner;

public class Quiz_SungJuk {
	public static void main(String[] args) {
		//���� ���� �� �޼��� ���, �Է� �ޱ�
		Scanner sc = new Scanner(System.in);  //�Է� ��ü ����
		System.out.print("name = ");
		String name = sc.nextLine(); 

		System.out.print("kor, eng, com score = ");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int com = sc.nextInt();
		
		//ó��(���)
		int total = kor + eng + com;
		double avg = total / 3.0;
		char grade = ' ';
		
		if((avg >= 90) && (avg < 100)) 		grade = 'A';		
		else if((avg >= 80) && (avg < 90))   grade = 'B';
		else if((avg >= 70) && (avg < 80)) {
			grade = 'C';
		}	
		else if((avg >= 60) && (avg < 70)) {
			grade = 'D';		
		}	
		else {
			grade = 'F';
		}

		//��� ��� 
		System.out.println("\n\n***** " + name + "���� ����ǥ *****");

		System.out.println("���� : " + kor + " ���� : " + eng + " ���� : " + com);

		System.out.printf("���� : %d ��� : %.2f  ����(����) : %c", total, avg, grade);
		
		sc.close();
	}
}
//*/
