package ex02_IO;

import java.io.InputStream;

public class KeyInput {
	public static void main(String[] args) {
		InputStream is=System.in; //ǥ�� �Է�
		try { //read()�� ���̻� �Է¹����� ������ -1�� ���ϵȴ�.
			System.out.println("���� ���� �Է� ���:");
			int num=is.read()-48; //���ܹ߻��� '0'~'9' : 48~57(ASCII code)
//		�Է´����¿��� ���������� �޸𸮻󿡴� �ӽù��۰������ϴµ� �ӽù��ۿ��� 3�̵��� ���͵� ���̵�.
			is.read();//�����߻�ó�� - �ڹٴ� '����'2����Ʈ ó����.
			is.read();//�׷��� 2�� ����.
			int num2=is.read()-48;
			
			System.out.println(num+num2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
