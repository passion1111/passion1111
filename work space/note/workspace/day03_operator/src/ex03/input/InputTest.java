package ex03.input;
//import java.util.*; // util package�� �ִ� ���� ���� �÷�����
import java.util.Scanner; // util package�� �ִ� Scanner Ŭ���� ���� �÷�����

public class InputTest  {
	public static void main(String[] args) {
		
//		ǥ�� �Է� : System.in
		Scanner sc = new Scanner(System.in);  //�Է� �׸� ����
		System.out.print("���� ������ �Է� ��� : ");
		int su = sc.nextInt();
		
		System.out.println("\n\n�Է� ���� �� : " + su);
		
	}
}
