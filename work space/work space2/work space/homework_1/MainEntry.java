package ex05_break_continue;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch =' ';
		String str = null;
		int count =0;
		
		System.out.println("�ƹ� ���̳� �Է��ϼ���. "
								+ "'!' �� ������ Ż�� : ");
		
		
		while( true ) { // ���ѷ���.. <-- Ż�� ������ �־��
			str = sc.next();
			ch = str.charAt(0);
//			ch = sc.next().charAt(0);
			
			count = str.length();  // 1���� ���� - !
			
			//Ż�� ���� 
			if( ch == '!' ) break; //if( ch == 'q' ) break;
//			count = str.length();
			
		} // while end
		
		System.out.println("�Է� ���� ���� ������ : " + count + "��.");
		
	}
}








