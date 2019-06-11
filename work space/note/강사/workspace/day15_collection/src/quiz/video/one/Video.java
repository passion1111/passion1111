package quiz.video.one;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Video {
	protected String title; //비디오제목
	protected String category; //장르
	protected String lend; //대여여부
	protected String lendName; //대여자(고객명)
	protected String lendDate; //오늘날짜
	static Scanner scan = new Scanner(System.in);
	
	public Video() {}
	
	
	public Video(String title, String category) {
		this.title = title;
		this.category = category;
		System.out.print("대여 여부를 입력하세요 <Y/N>: ");
		this.lend = scan.next();
		if(this.lend.equalsIgnoreCase("y")){
			System.out.print("대여자(고객명)을 입력하세요 : ");
			this.lendName = scan.next();
			this.lendDate = todayDate();//오늘 날짜 입력됨
		}
	} // constructor end
	
	public void input(String title){
		//return video;
	}

	private String todayDate() {
		Calendar cal = Calendar.getInstance();
		Date day = cal.getTime();
		SimpleDateFormat today;
		today = new SimpleDateFormat("yy-MM-dd EEEE");
		return today.format(day);
	}
}//class




