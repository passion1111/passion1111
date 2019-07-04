package MenuManager_dao;

import java.sql.SQLException;
import java.util.Scanner;

public class Menumngmain {
	
	public Menumngmain() throws SQLException, InterruptedException {
		makeedit();
	}

	private void makeedit()throws SQLException, InterruptedException  {
		MenuManager mgr = new MenuManager();
		Scanner sc = new Scanner(System.in);
		mgr.getConnection();// 커넥션은 메인에서 한 번 얻어옴
		boolean memumng=true;
		while (memumng) {
			int num;
			System.out.println("\n*** 관리자 모드 입니다. 원하는 메뉴를 선택하세요. ***\n<1> 전체보기 <2> 메뉴추가  <3> 메뉴수정  <4> 메뉴삭제  <0> 종료");
			do {
				while (!sc.hasNextInt()) {
					System.out.println("메뉴에 있는 숫자만 입력할 수 있습니다. 다시 입력해주세요.");
					Thread.sleep(2000);
					System.out.println("<1> 전체보기 <2> 메뉴추가  <3> 메뉴수정  <4> 메뉴삭제  <0> 종료");
					sc.next();
				}
				num = sc.nextInt();
				if(num <0 || num >4) {
					System.out.println("메뉴에 있는 숫자만 입력할 수 있습니다. 다시 입력해주세요.");
					Thread.sleep(2000);
					System.out.println("<1> 전체보기 <2> 메뉴추가  <3> 메뉴수정  <4> 메뉴삭제  <0> 종료");
				}
			} while (num < 0 || num > 4);
			
			if (num == 1) {
				mgr.list();
			} else if (num == 2) {
				mgr.addMenu();
			} else if (num == 3) {
				mgr.modifyMenu();
			} else if (num == 4) {
				mgr.deleteMenu();
			} else if (num == 0) {
				mgr.close();
				memumng=false;
				System.out.println("메뉴 관리를 종료합니다.");
				
			} 
		}//end while
	}// end main
		
	

	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) throws SQLException, InterruptedException {
		MenuManager mgr = new MenuManager();
		Scanner sc = new Scanner(System.in);
		mgr.getConnection();// 커넥션은 메인에서 한 번 얻어옴
		while (true) {
			int num;
			System.out.println("\n*** 관리자 모드 입니다. 원하는 메뉴를 선택하세요. ***\n<1> 전체보기 <2> 메뉴추가  <3> 메뉴수정  <4> 메뉴삭제  <0> 종료");
			do {
				while (!sc.hasNextInt()) {
					System.out.println("메뉴에 있는 숫자만 입력할 수 있습니다. 다시 입력해주세요.");
					Thread.sleep(2000);
					System.out.println("<1> 전체보기 <2> 메뉴추가  <3> 메뉴수정  <4> 메뉴삭제  <0> 종료");
					sc.next();
				}
				num = sc.nextInt();
				if(num <0 || num >4) {
					System.out.println("메뉴에 있는 숫자만 입력할 수 있습니다. 다시 입력해주세요.");
					Thread.sleep(2000);
					System.out.println("<1> 전체보기 <2> 메뉴추가  <3> 메뉴수정  <4> 메뉴삭제  <0> 종료");
				}
			} while (num < 0 || num > 4);
			
			if (num == 1) {
				mgr.list();
			} else if (num == 2) {
				mgr.addMenu();
			} else if (num == 3) {
				mgr.modifyMenu();
			} else if (num == 4) {
				mgr.deleteMenu();
			} else if (num == 0) {
				mgr.close();
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			} 
		}//end while
	}// end main
}// end class MainEntry
//
