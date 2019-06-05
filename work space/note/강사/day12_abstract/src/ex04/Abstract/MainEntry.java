package ex04.Abstract;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		
//		Transport[] t = new Transport[4];
//		t[0] = new Subway();
//		t[1] = new Bus();
//		t[2] = new Bicycle();
//		t[3] = new Airplane();
//		
//		String[] str = {"지하철", "버스", "자전거", "비행기"};
//		
//		for (int i = 0; i < t.length; i++) {
//			t[i].start(str[i]);
//			t[i].stop(str[i]);
//			t[i].display(str[i]);
//		} // for end
		
		Scanner sc = new Scanner(System.in);
		int num;
		Transport tr;		
		
		do {
			System.out.println("오늘의 교통편 선택.(1.지하철/ 2.버스 / 3.자전거 / 4.비행기 : ");
			num = sc.nextInt();
			switch (num) {
				case 1 :
					tr = new Subway();
					tr.start("지하철");
					tr.stop("지하철");
					tr.display("지하철");break;
				case 2 :
					tr = new Bus();
					tr.start("버스");
					tr.stop("버스");
					tr.display("버스");break;
					
				case 3 :
					tr = new Bicycle();
					tr.start("자전거");
					tr.stop("자전거");
					tr.display("자전거");break;
					
				case 4 :
					tr = new Airplane();
					tr.start("비행기");
					tr.stop("비행기");
					tr.display("비행기");break;
	
				default: System.out.println("숫자를 다시 입력하세요. ");
			} //switch end
			
		}while(num != 1 && num != 2 && num != 3 && num != 4 );
		
	}
}






