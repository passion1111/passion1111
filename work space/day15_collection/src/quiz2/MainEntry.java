package quiz2;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�̸��� �Է����ּ���");
		String name=sc.next();
		
		Emp.insert(name);
		Emp.modify();
		Emp.display();
		
		
	}

	
}
