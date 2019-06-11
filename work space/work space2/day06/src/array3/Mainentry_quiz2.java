package array3;
//int[][][]arr=new int[2][2][3];
//임의의 데이터 입력받아서 출력하기.
import java.util.Random;
import java.util.Scanner;

public class Mainentry_quiz2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
	  int[][][] arr=new int[2][2][3];
	  int x=0;
	  
	
	  //input
	 for(int i=0;i<arr.length;i++) {//면
		 for(int j=0;j<arr[i].length;j++) {//행
			 for(int k=0;k<arr[i][j].length;k++) {//면
				 arr[i][j][k]=sc.nextInt();
				 
			 }
		 }
	 }
	  
	  
	  
	  //output
	  for(int i=0;i<arr.length;i++) {//면	  
		  	for(int j=0;j<arr[i].length;j++) {//행
		  			for(int k=0;k<arr[i][j].length;k++) {//열
		  					System.out.print(arr[i][j][k]+"\t");
		  				
		  			}//열
		  			System.out.println("");
		  	}//행
		  	System.out.println("");
	  }//면
	
		
		}
	}
	