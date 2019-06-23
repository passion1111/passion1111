package persnonal_teamproject2;

import java.util.Scanner;
import java.util.Vector;

public class MenuSelection  {
		
		

	
	public   int MenuSelection(Vector ProductVector ) {
		int MenuSelect = 0;
		do {
			Scanner sc=new Scanner(System.in);
			
			
		    System.out.println("원하시는 메뉴의 번호를 입력해주세요.,서비스 선택을 원하시면 4번을 입력해주세요.");
		    while (!sc.hasNextInt()  ||  MenuSelect>ProductVector.size() || MenuSelect<0) {
		        System.out.println("메뉴에 있는 번호를 선택바랍니다.");
		        sc.next(); 
		    }//Exception대신사용하는 유효성검사.
		MenuSelect=sc.nextInt();	
		
	}while(MenuSelect <= 0||MenuSelect>ProductVector.size());
		return MenuSelect;

		
	}
}
