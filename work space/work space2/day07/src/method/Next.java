package method;

import java.util.Scanner;

public class Next {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name=sc.next();//���ۿ� ���� �ִ� ����ġ�� �޸𸮻� ���� 
        sc.next();      //�Է¹���next�� �����̽������������� �ԷµǴµ� �����̽��� ���İ� ���ۿ� �����־ ���� 
//		�Է� ���ɾ �ӽù��ۿ� �����־ ���� �Է±��� �Է¹������ϰ� �ӽù��ۿ� �ִ� ���� �����⋚����
//	   �����̽� �ϳ��������ǰ����� ���� �Է°����� ���޵ǰԵ�.
//		sc.nextLine();
		String s2=sc.next();//
		
		System.out.println(name+","+s2);
		
		
		
		
	}

}