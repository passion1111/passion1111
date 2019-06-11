package quiz.video.two;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class VideoManager extends Video {
	public static void main(String[] args) {
		//비디오정보 추가/삭제/수정
		HashMap<String, Video> video = new HashMap<String, Video>();
		Scanner scan = new Scanner(System.in);
		
		Video temp = null;  //비디오 객체 선언
		int choise = 0;
		
		while(true){
			do{
				System.out.println("(1)비디오정보 추가 (2)비디오정보 수정(3)비디오 삭제 (4)모든비디오 보기 (5)끝");
				choise = scan.nextInt();
			}while(choise<1 || choise>5);
			
			switch(choise){
				case 1:
					temp = new Video(); //객체 생성
					System.out.println("비디오 제목을 입력해주세요. ");
					temp.title = scan.next();
					System.out.println("비디오 장르를 입력해주세요. ");
					temp.category= scan.next();
					System.out.println("비디오 대여여부를 입력해주세요. ");
					temp.lend= scan.next();
					temp.lendName = "";
					temp.lendDate = "";
					video.put(temp.title, temp);
					break;
				case 2:
					System.out.println("수정할 비디오 타이틀을 입력해주세요.");
					String tit = scan.next();
					
					temp = video.get(tit);
					
					System.out.println("비디오 제목을 입력해주세요. ");
					temp.title = scan.next();
					System.out.println("비디오 장르를 입력해주세요. ");
					temp.category= scan.next();
					System.out.println("비디오 대여여부를 입력해주세요. ");
					temp.lend= scan.next();
					if( temp.lend.equalsIgnoreCase("y")) {
						video.put(temp.title, temp);
						SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
						temp.setLendDate(sdf.format(new Date()));
					}
					video.put(temp.title, temp);
					
					break;
				case 3:
					System.out.println("삭제할 비디오제목을 입력해주세요.");
					String removeName = scan.next();
					
					video.remove(removeName);
					break;
				case 4:
					Set keys = video.keySet();
					Iterator<String> it = keys.iterator();
					while(it.hasNext()){
						temp = video.get(it.next());
						System.out.println(temp.title+" | "+temp.category+" | "+temp.lend+" | "+temp.lendName+" | "+temp.lendDate);
					}
					break;
					
					default:
						System.exit(0);
	
				}// switch end
		}//
	}
}
