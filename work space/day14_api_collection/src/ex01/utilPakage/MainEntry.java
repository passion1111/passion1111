package ex01.utilPakage;

import java.util.*;

public class MainEntry {
	
		public static void main(String[] args) {
			
			Calendar c=Calendar.getInstance();// System(운영체제)가 가지고있는 날짜 얻어옴.ㅋ
			System.out.println(c);
			
			System.out.println(c.get(Calendar.YEAR)+"년");
			System.out.println((c.get(Calendar.MONTH)+1)+"월"); //월은 0부터 시작함
			System.out.println(c.get(Calendar.DATE)+"일"); 
			System.out.println("****************************************");
			
			Date date=new Date();
			int h=date.getHours();
			int m=date.getMinutes();
			int s=date.getSeconds();
			System.out.println("현재시간은"+h+":"+m+":"+s);
			
			Calendar c1=Calendar.getInstance();
			Calendar c2=Calendar.getInstance();
			
			c2.set(2018, 12,20,0,0);//after, before 년월일시분.
			if(c1.after(c2))System.out.println("현재 시간은 2018 1월1일 이후입니다");
			else if(c1.before(c2))System.out.println("현재 시간은 2018 1월1일 이전입니다");
			else if(c1.equals(c2))System.out.println("현재 시간은 2018년 1월1일입니다.");
		}
}
