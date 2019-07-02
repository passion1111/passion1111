package persnonal_teamproject2;

import java.util.Scanner;

public class Select {
	Scanner sc=new Scanner(System.in);
	
	public int  Number() {
		int Select=0;
		do {
			System.out.println("번호를 입력해주세요");
			while(!sc.hasNextInt()){
				System.out.println("숫자만 입력부탁드려요.");
				sc.next();
			}
			Select=sc.nextInt();
			
			
			
		}while(Select<1||Select>4);//메뉴와 선택지가 몇개까지 있을지 모르니 합칠떄 고쳐야함. 오른쪽 select >4 <-- 4부분을메뉴 최댓값으로 바꿔야함.
		
		
		
	return Select;	
	}
	
}



