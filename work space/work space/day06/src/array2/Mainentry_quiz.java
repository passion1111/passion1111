package array2;

import java.util.Scanner;

//int[][] arr=new int[2][3];
//������ �Է� �޾Ƽ� ����ϴ� ���α׷� �ۼ�
public class Mainentry_quiz {
	public static void main(String[] arugs) {
		Scanner sc=new Scanner(System.in);
		int[][] arr=new int[2][3];
		
		System.out.println("6���� ������ �Է��ϼ���");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=sc.nextInt();	
			}
		}//i�����°�
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print("arr["+i+"]["+j+"]="+arr[i][j]+"\t");
				
			}
			System.out.println("");
		}
		
		
		
		
	}
}