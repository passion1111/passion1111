package array2;

import java.util.Scanner;

//int[][] arr=new int[2][3];
//데이터 입력 받아서 출력하는 프로그램 작성
public class Mainentry_quiz {
	public static void main(String[] arugs) {
		Scanner sc=new Scanner(System.in);
		int[][] arr=new int[2][3];
		
		System.out.println("6개의 정수를 입력하세요");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=sc.nextInt();	
			}
		}//i끝나는곳
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print("arr["+i+"]["+j+"]="+arr[i][j]+"\t");
				
			}
			System.out.println("");
		}
		
		
		
		
	}
}
