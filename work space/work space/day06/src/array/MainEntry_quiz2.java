package array;
//문제2 기상청
//   특정달의 강수량 평균을 구하는 프로그램 작성(단,30일 기준)
//입력결정 나중에
import java.util.Scanner;

public class MainEntry_quiz2 {
	public static void main(String[] args) {
		int month,raindate=0,sum=0;
		double avg=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("달을 입력하세요");
		month=sc.nextInt();
	
		
		System.out.println("한달동안 비가 온 날은");
		raindate=sc.nextInt();
		int[] a=new int[raindate];
		
		for(int i=0;i<a.length;i++) {
			System.out.println((i+1)+"번쨰 비온날의 강수량을 적어주세요");
			a[i]=sc.nextInt();
			sum+=a[i];		
			
		}
		
		avg=sum/30.;
		System.out.println(month+"달의 강수량 평균입니다.");
		System.out.println("강수량 평균은="+avg);
		 
		
	
	
	}
}
