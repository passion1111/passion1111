package ex04.While;
//���� �Է� ���α׷��� do while�Ἥ�Է½Ǽ�����
//�ڷᱸ�� static const��  heap������ gc�� �˾Ƽ� ��������
//�ý����ʿ��� ������ �������ʾ������� �������.
//�ؿ� while(do)�� su�� ����ƾ �����ݾ����������� ����־ ���������� ������������� �޸𸮿��� �����. 
import java.util.Scanner;

public class While03 {
	public static void main(String[] args) {
		
		int su=new Scanner(System.in).nextInt();
		char grade=' ';
		do {
			System.out.println("����� ���� �Է� ��� : ");
		}while(0<su ||su<101);                 //     
		
		switch (su/10) {
		case 10: 
		case 9:   grade='A';break;
		case 8:  grade='B';break;
		case 7:  grade='C';break;
		case 6:  grade='D';break;
		default:grade='F';
		}
		System.out.println("\n����� ���� : "+su+"==>"+grade+" ����");
		}
}