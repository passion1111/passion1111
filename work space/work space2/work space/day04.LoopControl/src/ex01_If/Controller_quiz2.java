package ex01_If;
//문제2
//중첩 if else문 사용하기. 2월29일이 있는달은 윤년 4년마다 돌아옴.
//올림픽기간 윤년 1988
//if(year%4==0)
//   if(year%100!=0) ||if(year%400==0)
// 위의 조건이면 윤년
import java.util.Scanner;

public class Controller_quiz2 {
	public static void main(String[] args) {
		int year;
		String str="";
		boolean flag=false;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("년도를 입력해주세요: ");
		 year = sc.nextInt();
				 
		
		if(year%4==0) {
			if((year%100!=0)|| (year%400==0))
				    flag= true;
			//한줄 해결법
			//if(year%4==0&&(year%100!=0)|| (year%400==0))
				System.out.println(str);
		}
		str=(flag==true)?"윤년":"평년";
		System.out.println(year+"년===>"+str);
		sc.close();
		  
		  
		
		  

		  
		

	}

}
