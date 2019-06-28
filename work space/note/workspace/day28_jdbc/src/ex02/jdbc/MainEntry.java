package ex02.jdbc;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ConnectionUtil jdbc = new ConnectionUtil();
		jdbc.connect(); //�����
		//System.out.println("���� ����");
		
		while(true) {
			jdbc.menu();
			int choice = sc.nextInt();
			
			switch (choice) {
			case 0:
				jdbc.close();
				System.exit(0);
				break;

			case 1:
				
				jdbc.insert();
				break;
			case 2:
				jdbc.update();
				break;
			case 3:
				jdbc.selectAll();
				break;
			case 4:
				jdbc.delete();
				break;
				
			case 5:
				System.out.println("�˻� ���ϴ� dcode �Է� ��� : ");
				int code = sc.nextInt();
				jdbc.selectByDcode(code);
				break;
				
			case 6:
				jdbc.update2();
				break;
				
			default:
				System.out.println("==== menu�� �ִ� ���� �Է� �ϼ���. ====");
				break;
			} // switch end
			
		} // while end
	}
}















