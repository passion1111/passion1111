package persnonal_teamproject2;

import java.util.Scanner;

public class Select {
	Scanner sc=new Scanner(System.in);
	
	public int  Number() {
		int Select=0;
		do {
			System.out.println("��ȣ�� �Է����ּ���");
			while(!sc.hasNextInt()){
				System.out.println("���ڸ� �Էº�Ź�����.");
				sc.next();
			}
			Select=sc.nextInt();
			
			
			
		}while(Select<1||Select>4);//�޴��� �������� ����� ������ �𸣴� ��ĥ�� ���ľ���. ������ select >4 <-- 4�κ����޴� �ִ����� �ٲ����.
		
		
		
	return Select;	
	}
	
}



