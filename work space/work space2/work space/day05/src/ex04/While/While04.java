package ex04.While;
//이름 입력받고 점수 3개(0~100만 입력 k e c 총점 평균 구하는 프로그램 작성
//
//
//
import java.util.Scanner;

public class While04 {
	public static void main(String[] args) {
		String name=null;
		
		int k,e,c,sum;
		double avg=0;
		char op=' ';
		System.out.println("name");
		Scanner sc=new Scanner(System.in);
		name=sc.nextLine();
		do {
		System.out.println("K=");
		k=sc.nextInt();
		}while(k<0||k>101);
		do {
		System.out.println("e=");
		e=sc.nextInt();
		}while(e<0||e>101);
		do {
		System.out.println("c=");
		c=sc.nextInt();
	}while(c<0||c>101);
		sum=k+e+c;
		avg=sum/3.;
		System.out.println("당신의 총점은: "+sum+"\n당신의 평균은:"+avg);
		
		//만약 더하기,나누기,곱셈등의 문제가있다면.
		do {System.out.println("op(+,-,*,/)=");
			op=sc.next().charAt(0);
	
		
		}while((op!='+')&&(op!='-')&&(op!='*')&&(op!='/'));// +,-,*,/만 받음.
		
	}
	
	}

	
	
	





/*Scanner sc=new Scanner(System.in);
int sum=0,avg,x,y,z;
int k=0,e=0,c=0;



double avg1=0;
System.out.println("당신의 이름 입력 요망 : ");
String name=sc.nextLine();

System.out.println("성적 3개를 입력하세요");
 k=sc.nextInt();
 e=sc.nextInt();	
 c=sc.nextInt();	
do {
	 k=sc.nextInt();		
	System.out.println("국어를 입력해주세요");		
}while(k<0||k>101);   

do {
	 e=sc.nextInt();		
	System.out.println("영어를 입력해주세요");		
}while(e<0||e>101);
do {
	 c=sc.nextInt();		
	System.out.println("전산을 입력해주세요");		
}while(c<0||c>101);    
   sum=k+e+c;
avg1=sum/3.0;

System.out.println(name+"씨 ");
System.out.println("당신의 총점은:"+sum+"\n당신의 평균은:"+avg1);
*/