package method;

import java.util.Scanner;

//quiz2 max(){�ΰ� ���� �Է¹޾Ƽ� ū�� �����ϴ� �Լ�}
public class Mainentry_quiz2{
	public static int max() {
		System.out.println("x,y=");
		int x=new Scanner(System.in).nextInt();
		int y=new Scanner(System.in).nextInt();
				if(x<y) {
			
			return y;
		}
		else if(x>y) return x;

		return 0;
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(max());
		
		int m=max();
		System.out.println("max="+m);
		
	}
}
