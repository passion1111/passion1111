package ex01_If;
//����2
//��ø if else�� ����ϱ�. 2��29���� �ִ´��� ���� 4�⸶�� ���ƿ�.
//�ø��ȱⰣ ���� 1988
//if(year%4==0)
//   if(year%100!=0) ||if(year%400==0)
// ���� �����̸� ����
import java.util.Scanner;

public class Controller_quiz2_teacher {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("����� �¾ �⵵�� �Է����ּ���: ");
		int year = sc.nextInt();
				 
		
		if(year%4==0) {
			if((year%100!=0)|| year%400==0)
				System.out.println("����� �¾ �⵵�� �����Դϴ�");
			else
				System.out.println("����� �¾ �⵵�� ������ �ƴմϴ�.");
		}
		else 
			System.out.println("����� �¾ �⵵�� ������ �ƴմϴ�.");
		sc.close();
		  
		  
		
		  

		  
		

	}

}