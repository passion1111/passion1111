package array;
//����3
//   int[] a={7,5,7,8,2,7,3,7,7,90}
//   7�� ������ ���ϴ� ���α׷��� ���Ͻÿ�.7�� ���� �Է¹޴´�.
import java.util.Scanner;

public class MainEntry_quiz3 {
	public static void main(String[] args) {
		int b=0,count=0;
		Scanner sc=new Scanner(System.in);
		int[] a={7,5,7,8,2,7,3,7,7,90};
		System.out.println("���ϴ� ���ڸ� �Է��ϼ���");
		b=sc.nextInt();
		
		for(int i=0;i<a.length;i++) {
			if(b==a[i]) count++;
		}
		System.out.println(b+"�� �ߺ��Ǵ� ������ : "+count);
		
		
		
		
	
	}
}