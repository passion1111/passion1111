package array;
//����2 ���û
//   Ư������ ������ ����� ���ϴ� ���α׷� �ۼ�(��,30�� ����)
//�Է°��� ���߿�
import java.util.Scanner;

public class MainEntry_quiz2 {
	public static void main(String[] args) {
		int month,raindate=0,sum=0;
		double avg=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("���� �Է��ϼ���");
		month=sc.nextInt();
	
		
		System.out.println("�Ѵ޵��� �� �� ����");
		raindate=sc.nextInt();
		int[] a=new int[raindate];
		
		for(int i=0;i<a.length;i++) {
			System.out.println((i+1)+"���� ��³��� �������� �����ּ���");
			a[i]=sc.nextInt();
			sum+=a[i];		
			
		}
		
		avg=sum/30.;
		System.out.println(month+"���� ������ ����Դϴ�.");
		System.out.println("������ �����="+avg);
		 
		
	sc.close();
	
	}
}
