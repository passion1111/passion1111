/*����3] ����,����,���� ���� �Է� �޾Ƽ� ��� 60���̻��̰�,
     �� ���� ���� 40�����ϸ� ���� ���հ� ó���ϴ� ���α׷� �ۼ�
*/
package quiz;

import java.util.Scanner;

public class Quiz_�հ�_���հ��������α׷� {
	public static void main(String[] args) {
		System.out.print("kor = ");		int kor = new Scanner(System.in).nextInt();
		System.out.print("eng = ");		int eng = new Scanner(System.in).nextInt();
		System.out.print("com = ");		int com = new Scanner(System.in).nextInt();
		//double avg = (double)( kor + eng + com ) / 3;
		double avg = ( kor + eng + com ) / 3.0;
		
		if( avg >= 60 ) {  //3���� ��� 60�� �̻��̾����
			
			if( kor >= 40 && eng >= 40 && com >= 40 ) {
				System.out.printf("��� ������ 40�� �̻��̸�,"
						+" ����� %.2f�� [�հ�]�Դϴ�\n",avg);
			} else {
				System.out.printf("����� %.2f ������, ", avg);
				if( kor < 40 ) System.out.print("���� " + kor + "��");
				if( eng < 40 ) System.out.print("���� " + eng + "��");
				if( com < 40 ) System.out.print("���� " + com + "��");
				System.out.print("���� [����Ż��]�Դϴ� \n");
			} // in if end
			
		} else {
			System.out.printf("����� %.2f�� [��� �̴� Ż��]�Դϴ�\n",avg);
		}// out if end
	}
}









