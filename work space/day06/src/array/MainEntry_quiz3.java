package array;
//문제3
//   int[] a={7,5,7,8,2,7,3,7,7,90}
//   7의 개수를 구하는 프로그램을 구하시오.7의 값을 입력받는다.
import java.util.Scanner;

public class MainEntry_quiz3 {
	public static void main(String[] args) {
		int b=0,count=0;
		Scanner sc=new Scanner(System.in);
		int[] a={7,5,7,8,2,7,3,7,7,90};
		System.out.println("원하는 숫자를 입력하세요");
		b=sc.nextInt();
		
		for(int i=0;i<a.length;i++) {
			if(b==a[i]) count++;
		}
		System.out.println(b+"의 중복되는 개수는 : "+count);
		
		
		
		
	
	}
}
