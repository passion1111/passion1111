package ex01_If;
//����2
//��ø if else�� ����ϱ�. 2��29���� �ִ´��� ���� 4�⸶�� ���ƿ�.
//�ø��ȱⰣ ���� 1988
//if(year%4==0)
//   if(year%100!=0) ||if(year%400==0)
// ���� �����̸� ����
import java.util.Scanner;

public class Controller_quiz2 {
	public static void main(String[] args) {
		int year;
		String str="";
		boolean flag=false;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("�⵵�� �Է����ּ���: ");
		 year = sc.nextInt();
				 
		
		if(year%4==0) {
			if((year%100!=0)|| (year%400==0))
				    flag= true;
			//���� �ذ��
			//if(year%4==0&&(year%100!=0)|| (year%400==0))
				System.out.println(str);
		}
		str=(flag==true)?"����":"���";
		System.out.println(year+"��===>"+str);
		sc.close();
		  
		  
		
		  

		  
		

	}

}