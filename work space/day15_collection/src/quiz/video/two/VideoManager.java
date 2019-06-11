package quiz.video.two;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class VideoManager extends Video {
	public static void main(String[] args) {
		//�������� �߰�/����/����
		HashMap<String, Video> video = new HashMap<String, Video>();
		Scanner scan = new Scanner(System.in);
		
		Video temp = null;  //���� ��ü ����
		int choise = 0;
		
		while(true){
			do{
				System.out.println("(1)�������� �߰� (2)�������� ����(3)���� ���� (4)������ ���� (5)��");
				choise = scan.nextInt();
			}while(choise<1 || choise>5);
			
			switch(choise){
				case 1:
					temp = new Video(); //��ü ����
					System.out.println("���� ������ �Է����ּ���. ");
					temp.title = scan.next();
					System.out.println("���� �帣�� �Է����ּ���. ");
					temp.category= scan.next();
					System.out.println("���� �뿩���θ� �Է����ּ���. ");
					temp.lend= scan.next();
					temp.lendName = "";
					temp.lendDate = "";
					video.put(temp.title, temp);
					break;
				case 2:
					System.out.println("������ ���� Ÿ��Ʋ�� �Է����ּ���.");
					String tit = scan.next();
					
					temp = video.get(tit);
					
					System.out.println("���� ������ �Է����ּ���. ");
					temp.title = scan.next();
					System.out.println("���� �帣�� �Է����ּ���. ");
					temp.category= scan.next();
					System.out.println("���� �뿩���θ� �Է����ּ���. ");
					temp.lend= scan.next();
					if( temp.lend.equalsIgnoreCase("y")) {
						video.put(temp.title, temp);
						SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
						temp.setLendDate(sdf.format(new Date()));
					}
					video.put(temp.title, temp);
					
					break;
				case 3:
					System.out.println("������ ���������� �Է����ּ���.");
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
