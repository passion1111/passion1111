package quiz.video.one;
import java.util.Scanner;

public class MainEntry {
	
	public static void main(String[] args) {
		
		while (true) {
			System.out.print("<1>�������� �߰� <2>�뿩���� ��� <3>�뿩���� ���� <4>���� ���� <5>EXIT : ");
			switch (new Scanner(System.in).nextInt() ) {
				case 1:
					VideoManager.insert();
					break;
				case 2:
					VideoManager.print();
					break;
				case 3:
					VideoManager.modify();
					break;
				case 4:
					VideoManager.delete();
					break;
				case 5:
					System.out.println("SEE YOU!!");
					System.exit(0);
					break;
			}// switch
		} // while
	}// main
}
