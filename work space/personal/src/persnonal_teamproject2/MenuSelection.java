package persnonal_teamproject2;

import java.util.Scanner;
import java.util.Vector;

public class MenuSelection  {
		
		

	
	public   int MenuSelection(Vector ProductVector ) {
		int MenuSelect = 0;
		do {
			Scanner sc=new Scanner(System.in);
			
			
		    System.out.println("���Ͻô� �޴��� ��ȣ�� �Է����ּ���.,���� ������ ���Ͻø� 4���� �Է����ּ���.");
		    while (!sc.hasNextInt()  ||  MenuSelect>ProductVector.size() || MenuSelect<0) {
		        System.out.println("�޴��� �ִ� ��ȣ�� ���ùٶ��ϴ�.");
		        sc.next(); 
		    }//Exception��Ż���ϴ� ��ȿ���˻�.
		MenuSelect=sc.nextInt();	
		
	}while(MenuSelect <= 0||MenuSelect>ProductVector.size());
		return MenuSelect;

		
	}
}
