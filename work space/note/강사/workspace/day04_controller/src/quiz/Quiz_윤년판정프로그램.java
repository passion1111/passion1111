/*����2] ����/��� ���� ���α׷� �ۼ�
   if( year % 4 == 0 ) 
	if( year % 100 != 0) || if( year % 400 == 0)
		"����" 
*/
package quiz;

import java.util.Scanner;

public class Quiz_�����������α׷� {
	public static void main(String[] args) {
		//1. ��������
		int year;
		String str ="";
		boolean flag = false;
		//2. �޽��� ��� �� �Է� �ޱ�
		System.out.print("�⵵ �Է� �ϼ��� : ");
		year = new Scanner(System.in).nextInt();
		
		//3. ó��(���)
		if( (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
					flag = true;		
		} // if  end
		
//		if( year % 4 == 0 ) {
//			if( (year % 100 != 0) || ( year % 400 == 0) ) {
//				flag = true;
//			} // if in end				
//		} // if out end
		
		str = ( flag == true ) ? "����" : "���";
		
		//4. ������
		System.out.println(year + "�� ===> " + str);		
	}
}








