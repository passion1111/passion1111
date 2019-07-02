package persnonal_teamproject2;

import java.util.Scanner;

public class Select {
	Scanner sc=new Scanner(System.in);
	int Select;
	

	
	
	
	public int  Number() {
		

		System.out.println("숫자를 입력해주세요");
		while(!sc.hasNextInt()){
			System.out.println("숫자를 입력해주세요");
			sc.next();
		}
		Select=sc.nextInt();		
		
	
	
	return Select;
	}

	public int  Number(String msg) {
		
		
			System.out.println(msg+"의 번호를 입력해주세요");
			while(!sc.hasNextInt()){
				System.out.println("번호를 입력해주세요.");
				sc.next();
			}
			Select=sc.nextInt();		
			
		
		
		return Select;
	}
	
	
	public int  Number(int min,int max) {
		
		do {
			System.out.println("번호를 입력해주세요");
			while(!sc.hasNextInt()){
				System.out.println("숫자만 입력부탁드려요.");
				sc.next();
			}
			Select=sc.nextInt();		
			
		}while(Select<min||Select>max);
		
		return Select;
	}
	
	
	public int  Number(String msg,int min,int max) {
		
		do {
			System.out.println(msg+"의 번호를 입력해주세요");
			while(!sc.hasNextInt()){
				System.out.println(msg+"에 있는 숫자만 입력부탁드려요.");
				sc.next();
			}
			Select=sc.nextInt();		
			
		}while(Select<min||Select>max);
		
		return Select;
	}
	
	
	
}



