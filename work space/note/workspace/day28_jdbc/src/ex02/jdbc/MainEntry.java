package ex02.jdbc;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ConnectionUtil jdbc = new ConnectionUtil();
		jdbc.connect(); //연결됨
		//System.out.println("연결 성공");
		
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
				System.out.println("검색 원하는 dcode 입력 요망 : ");
				int code = sc.nextInt();
				jdbc.selectByDcode(code);
				break;
				
			case 6:
				jdbc.update2();
				break;
				
			default:
				System.out.println("==== menu에 있는 숫자 입력 하세요. ====");
				break;
			} // switch end
			
		} // while end
	}
}















