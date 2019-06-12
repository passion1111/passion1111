package ex06.homework;

import java.util.Scanner;


public class MainEntry {
	public static void main(String[] args){
		SungJuk dv=new SungJuk();  //
		dv.input();
	}

}

class SungJuk {
	public static void input() {
		int kor,com,eng;
		int[] a=new int[3]; //
		String[] subject = { "국어" , "영어", "전산" };
		Scanner sc=new Scanner(System.in);
	
		for (int i = 0; i < a.length; i++) {
			System.out.print(subject[i] + "성적을 입력하시오: ");
			a[i] = sc.nextInt();				
		}
		
		process(a[0], a[1], a[2]);
	}
	/*public static int[] su(){
		int kor,com,eng;
		int[] a=new int[3]; //
		String[] subject = { "국어" , "영어", "전산" };
		Scanner sc=new Scanner(System.in);
	
		for (int i = 0; i < a.length; i++) {
			System.out.print(subject[i] + "성적을 입력하시오: ");
			a[i] = sc.nextInt();				
		}
		//sc.skip("\\r\\n");
		return a;
		
	}*/
	
	public static void process(int x, int y, int z){
		int sum=x + y + z ;
		double div=sum/3.0 ;
		char grade;
		switch ((int)div/10)	{
		case 10:
		case 9: grade ='A';break;
		case 8: grade ='B';break;
		case 7: grade ='C';break;
		case 6: grade ='D';break;
		default : grade = 'F';
		
		}//end switch
		
		System.out.println("\nkor : " + x + "\teng : " + y + "\tcom : " + z);
		System.out.println("총점 : " + sum + "평균 : "+Math.round(div * 100)/100.00 +"점으로  "+grade+" 학점입니다.");
			
	}
}