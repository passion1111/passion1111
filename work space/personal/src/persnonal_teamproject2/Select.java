package persnonal_teamproject2;

import java.util.Scanner;

public class Select {
	Scanner sc=new Scanner(System.in);
	int Select;
	

	
	
	
	public int  Number() {
		

		System.out.println("���ڸ� �Է����ּ���");
		while(!sc.hasNextInt()){
			System.out.println("���ڸ� �Է����ּ���");
			sc.next();
		}
		Select=sc.nextInt();		
		
	
	
	return Select;
	}

	public int  Number(String msg) {
		
		
			System.out.println(msg+"�� ��ȣ�� �Է����ּ���");
			while(!sc.hasNextInt()){
				System.out.println("��ȣ�� �Է����ּ���.");
				sc.next();
			}
			Select=sc.nextInt();		
			
		
		
		return Select;
	}
	
	
	public int  Number(int min,int max) {
		
		do {
			System.out.println("��ȣ�� �Է����ּ���");
			while(!sc.hasNextInt()){
				System.out.println("���ڸ� �Էº�Ź�����.");
				sc.next();
			}
			Select=sc.nextInt();		
			
		}while(Select<min||Select>max);
		
		return Select;
	}
	
	
	public int  Number(String msg,int min,int max) {
		
		do {
			System.out.println(msg+"�� ��ȣ�� �Է����ּ���");
			while(!sc.hasNextInt()){
				System.out.println(msg+"�� �ִ� ���ڸ� �Էº�Ź�����.");
				sc.next();
			}
			Select=sc.nextInt();		
			
		}while(Select<min||Select>max);
		
		return Select;
	}
	
	
	
}



