/*����2] ������ �Է� �޾Ƽ� ����ϴ� ���α׷� �ۼ�
  �̸�, ����, ����, ���� ���� �Է� �޾Ƽ�
  ����, ��� ���� ����ϴ�


 result>
  �̵������� ����ǥ *****
  ���� : 100, ����: 100, ���� : 100
  ���� : 300, ���: 100.00 
*/
package operator;

import java.util.Scanner;

public class Quiz_Scanner {
	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in); //�Է� ��ü ����
		int kor, eng, com;
		
		System.out.print("name = ");
		String name = sc.nextLine();
		
		System.out.print("kor, eng, com score = ");

		int total = sc.nextInt() + sc.nextInt() + sc.nextInt();
		double avg = total / 3.0;
				
		System.out.println("\n\n***** " + name + "���� ����ǥ *****");
		//System.out.println("���� : " + kor + " ���� : " + eng + " ���� : " + com);
		System.out.printf("���� : %d ��� : %.2f", total, avg); */
		
		
	  System.out.print("name = "); 
	  String name = new Scanner(System.in).nextLine();

	  System.out.print("kor, eng, com score = "); 
	  int kor = new Scanner(System.in).nextInt(); 
	  int eng = new Scanner(System.in).nextInt(); 
	  int com = new Scanner(System.in).nextInt();
	  
	  int total = kor + eng + com; double avg = total / 3.0;
	  
	  System.out.println("\n\n***** " + name + "���� ����ǥ *****");
	  
	  System.out.println("���� : " + kor + " ���� : " 
			  						+ eng + " ���� : " + com);
	  
	  System.out.printf("���� : %d ��� : %.2f", total, avg);
		 
	}

}









