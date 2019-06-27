package ex03.jdbc12;

import java.sql.SQLException;
import java.util.Scanner;

public class MainEntry {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		Scanner sc=new Scanner(System.in);
		int select;
		while(true) {
			do {
				System.out.println("1번.업데이트 2번.추가.3.목록보기4.삭제");
				
				while(!sc.hasNextInt()){
					System.out.println("숫자를 입력해주세요.");
					sc.next();
				}
			select=sc.nextInt();
			}while(select<1||select>4);
//		클래스로 나눴는데 함수로 만들고싶으면 그대로 내용 복붙.
		if(select==1) {	GiftUpdate gu=new GiftUpdate();}
		else if(select==2) {GiftInsert gi=new GiftInsert(args);} //args 1숫자 2.string 3 int   4 int로 입력
		else if(select==3){GiftSelect gs=new GiftSelect();}
		else if(select==4) {GiftDelete gd=new GiftDelete();}
		}
		//commit따로 만들지 정하면 됨.  그리고 insert시  gno중복검사를 위해서 not exist적용
		
		
		
		}
}
