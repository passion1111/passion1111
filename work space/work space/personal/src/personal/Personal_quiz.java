package personal;
//�밡��62��¥��.
import java.util.Scanner;

public class Personal_quiz {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("x�� �Է����ּ���: ");
		int x=sc.nextInt();
		System.out.println("y�� �Է����ּ���: ");
		int y=sc.nextInt();
		System.out.println("z���Է����ּ���: ");
		int z=sc.nextInt();
if( 0!=x&& 0!=y && 0!=z ){
	if (x > y) {
			if (x > z) {
				if (y > z)
					System.out.println("x>y>z");
				else
					System.out.println("x>z>y");
			} else if(y<z)
				System.out.println("z>y>x");
			else System.out.println("�ٽ��Է����ּ���");
		}

	else if (x > z) {
			if (x > y) {
				if (y > z)
					System.out.println("x>y>z");
				else
					System.out.println("x>z>y");
			} else if(y>z)
				System.out.println("y>x>z");
			else System.out.println("�ٽ��Է����ּ���");
		} 
	else if (x < z) {
			if (x < y) {
				if (y > z)
					System.out.println("y>z>x");
				else
					System.out.println("z>y>x");
			} else if(z<y)
				System.out.println("z>y>x");
			 else System.out.println("�ٽ��Է����ּ���");
		} 
	else if (x < y) {
			if (x < z) {
				if (y > z)
					System.out.println("y>z>x");
				else
					System.out.println("z>y>x");
			} else if(z<y)
				System.out.println("y>x>y");
			else System.out.println("�ٽ��Է����ּ���");
		}
	else System.out.println("�ٽ��Է����ּ���");
		
	}
else System.out.println("������ �Է����ּ���");
}
}