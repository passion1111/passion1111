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
//		String[] str = {"����ö", "����", "������", "�����"};
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
			System.out.println("������ ������ ����.(1.����ö/ 2.���� / 3.������ / 4.����� : ");
			num = sc.nextInt();
			switch (num) {
				case 1 :
					tr = new Subway();
					tr.start("����ö");
					tr.stop("����ö");
					tr.display("����ö");break;
				case 2 :
					tr = new Bus();
					tr.start("����");
					tr.stop("����");
					tr.display("����");break;
					
				case 3 :
					tr = new Bicycle();
					tr.start("������");
					tr.stop("������");
					tr.display("������");break;
					
				case 4 :
					tr = new Airplane();
					tr.start("�����");
					tr.stop("�����");
					tr.display("�����");break;
	
				default: System.out.println("���ڸ� �ٽ� �Է��ϼ���. ");
			} //switch end
			
		}while(num != 1 && num != 2 && num != 3 && num != 4 );
		
	}
}






