package ex04.While;
//while���� �̿��Ͽ� ������ �����
import java.util.Scanner;

public class While_gugu {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("���ϴ� ���� �Է����ּ���");
		int i=sc.nextInt();
		int j=1;
			while(j<=9) {
				System.out.println(i+"*"+j+"= "+(i*j));
					j++;	
	}
}
}