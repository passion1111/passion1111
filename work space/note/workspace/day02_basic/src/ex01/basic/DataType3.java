//*
package ex01.basic;

public class DataType3 {
	// ����ȯ 
	public static void main(String[] args) {
		short sh = 3;  // -32768 ~ 32767 : 2byte
		int num = 32769;  // -21�� ~ 21�� : 4byte
		//���� �ڷ����� ū�ڷ�����...�ڵ�����ȯ(����������ȯ) �ȴ�.
		num = sh;   // int(4byte) = short(2byte)
		System.out.println("sh = " + sh);
		System.out.println("num = " + num);
		
		num = 32769; 
		//ū�ڷ����� ���� �ڷ����� �������� ���������ȯ �ؾ��Ѵ�.
		//������ �ս� �߻�
		sh = (short)num;  // short(2byte) = int(4byte)
		System.out.println("sh = " + sh);
		System.out.println("num = " + num);
	}
}
//*/

/*
package ex01.basic;

public class DataType3 {
	// ��� �ڷ����� �ڽ��� ����(ũ��)�� �ȹ����.
	public static void main(String[] args) {
		short sh = 32767;   //-32,768 ~ 32,767
		int num = 50000;  // -21�� ~ 21��
		
		System.out.println(sh + " : " + num);
		
		num = -32769; 
		sh = (short)num;  //����� ����ȯ
		System.out.println(sh + " : " + num);  // ??
	}
}
//*/




