package array3;
//int[][][]arr=new int[2][2][3];
//������ ������ �Է¹޾Ƽ� ����ϱ�.
import java.util.Random;
import java.util.Scanner;

public class Mainentry_quiz2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
	  int[][][] arr=new int[2][2][3];
	  int x=0;
	  
	
	  //input
	 for(int i=0;i<arr.length;i++) {//��
		 for(int j=0;j<arr[i].length;j++) {//��
			 for(int k=0;k<arr[i][j].length;k++) {//��
				 arr[i][j][k]=sc.nextInt();
				 
			 }
		 }
	 }
	  
	  
	  
	  //output
	  for(int i=0;i<arr.length;i++) {//��	  
		  	for(int j=0;j<arr[i].length;j++) {//��
		  			for(int k=0;k<arr[i][j].length;k++) {//��
		  					System.out.print(arr[i][j][k]+"\t");
		  				
		  			}//��
		  			System.out.println("");
		  	}//��
		  	System.out.println("");
	  }//��
	
		
		}
	}
	