package ex4.coolection.map;
//문제 video class
// title 비디오 제목 
// category 장르
// lend 대여여부
// lendname 대여자(고객명)
// lendDate 대여일자(오늘날짜 입력)
// map에 key값넣고 value는  videos로 넣어주면 됨.
// video 추가/삭제/video 리스트출력/수정/프로그램 종료 출력하는 프로그램 작성

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//큰틀 비디오로 전체정보확인하고 
class Video{
	protected String title;
//	protected String category;
//	protected int lend;
//	protected String lendname;
//	protected int lendDate;
	Video(){
		HashMap map=new HashMap();
		HashMap map2=new HashMap();
		ArrayList<Lental> arrlist=new ArrayList<Lental>();
		arrlist.add(new Lental());
			
		Scanner sc=new Scanner(System.in);
		System.out.println("타이틀을 입력해주세요");
		this.title=sc.nextLine();
//		this.category=sc.nextLine();
//		this.lend=sc.nextInt(); 나중에 구현
//		map.put(title, category);
		map.put(title, arrlist); //타이틀값으로 arrlist값확인.
		
		
		//중복확인 메소드
		Set set=map.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext()) {
			Map.Entry e;
		}
		
//		while(it.hasNext()) {
//			
//		}
				
	}
	
	
//	static void Category(String categoty) {
//		HashMap<String, String> category1=new HashMap<String, String>();
//		category1.put(sc.nextLine(),sc.nextLine() );
//		
//	}
//	
}
class Lental{
	protected boolean lend;
	protected String lendname;
	protected String category;
//	protected int lendDate;
	Lental(){
		Calendar lendtalday=Calendar.getInstance();
		Calendar lendtaldate = Calendar.getInstance();
		Scanner sc=new Scanner(System.in);
		System.out.println("이름을 입력해주세요");
		this.lendname=sc.nextLine();
		System.out.println("카테고리를 입력해주세요");
		this.category=sc.nextLine();
		lendtaldate.add(Calendar.DATE, 1);//대출기한 1일
		
		if(lendtaldate.before(lendtalday)) {
			lend=false;
		}
		else lend=true;  //렌탈 가능 불가능 계산메소드
	}
	
}

public class quiz {
	public static void main(String[] args) {
		Video v=new Video();
		
	   
		}
	}

