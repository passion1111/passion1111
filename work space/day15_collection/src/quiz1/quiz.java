package quiz1;
//문제 video class
// title 비디오 제목 
// category 장르
// lend 대여여부
// lendname 대여자(고객명)
// lendDate 대여일자(오늘날짜 입력)
// map에 key값넣고 value는  videos로 넣어주면 됨.
// video 추가/삭제/video 리스트출력/수정/프로그램 종료 출력하는 프로그램 작성

import java.text.SimpleDateFormat;
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
		ArrayList<Im> arrlist=new ArrayList<Im>();
		arrlist.add(new Im());
			
		Scanner sc=new Scanner(System.in);
		System.out.println("타이틀을 입력해주세요");
		this.title=sc.nextLine();
//		this.category=sc.nextLine();
//		this.lend=sc.nextInt(); 나중에 구현
//		map.put(title, category);
		map.put(title, arrlist.get(0)); //타이틀값으로 arrlist값확인.
		
		
		//중복확인 메소드
		Set set=map.entrySet();
		Iterator it=set.iterator();
//		while(it.hasNext()) { //lental 클래스로 이동
//			Map.Entry e;
//		}
	
		while(it.hasNext()) {//
			Map.Entry e =(Map.Entry)it.next();//오브젝트타입을 Map.entry타입에 넣을려고하니까 오류뜸 형변환필수
			System.out.println("영화"+e.getKey()+",2차배열 나와라:"+e.getValue());//키가 셋타입이기떄문에 순서가 막나옴
			
		}
		
	
	}
	
	public void aa() {
		
	}
	
//	static void Category(String categoty) {
//		HashMap<String, String> category1=new HashMap<String, String>();
//		category1.put(sc.nextLine(),sc.nextLine() );
//		
//	}
//	
}

class Im {
	protected boolean lend;
	protected String lendname;
	protected String category;
	protected String formattedDate;
	
	
	
//	protected int lendDate;
	Im(){
		arrlist.set
		Calendar lendtalday=Calendar.getInstance();
		Calendar lendtaldate = Calendar.getInstance();
		Scanner sc=new Scanner(System.in);
		System.out.println("이름을 입력해주세요");
		this.lendname=sc.nextLine();
		System.out.println("카테고리를 입력해주세요");
		this.category=sc.nextLine();
		lendtaldate.add(Calendar.DATE, 1);//대출기한 1일
		SimpleDateFormat myDateFormat = new SimpleDateFormat("MM.dd.yyyy"); 
		this.formattedDate = myDateFormat.format(lendtaldate.getTime());
//		System.out.println(lendtaldate);
//		System.out.println(lendtalday);
		if(lendtalday.before(lendtaldate)) {
			lend=false;
			
		}
		else { lend=true; //렌탈 가능 불가능 계산메소드
		
		}
	}
	public boolean isLend() {
		return lend;
	}
	public void setLend(boolean lend) {
		this.lend = lend;
	}
	public String getLendname() {
		return lendname;
	}
	public void setLendname(String lendname) {
		this.lendname = lendname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFormattedDate() {
		return formattedDate;
	}
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}
	@Override
	public String toString() {
		return "Im [반납가능=" + lend + ", lendname=" + lendname + ", category=" + category + ", 반납예정일="
				+ formattedDate + "]";
	}
	
}

public class quiz {
	public static void main(String[] args) {
		Video v;
		Im i;
		int num=0;
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();
		
		
		if(num==1) {
//			if(i.ha)
			
			
			
		}else if(num==2) {
			
			
			
		}else if(num==3) {
			
			
			
		}else if(num==4) {
			
			
			
		}else if(num==5) {
			System.out.println("시스템을 종료합니다.");
			System.exit(0);
		}
	
		

		
		
		}//메인 end
	}//클래스 end


