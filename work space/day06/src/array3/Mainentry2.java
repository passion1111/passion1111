package array3;

import java.util.Random;

public class Mainentry2 {
	public static void main(String[] args) {
	  int[][][] arr=new int[2][2][3];
	  int x=0;
	  
	  System.out.println("면 = "+arr.length);  //가장 큰 나눔 면
	  System.out.println("행 = "+arr[0].length);//두번쨰 공통사항 행
	  System.out.println("열 = "+arr[0][0].length);//세번쨰 공통사항 열
	  //input
	  for(int i=0;i<arr.length;i++) {//면	  
		  	for(int j=0;j<arr[i].length;j++) {//행
		  			for(int k=0;k<arr[i][j].length;k++) {//열
//		  				arr[i][j][k]=++x;
//		  				arr[i][j][k]=x +=10;
//		  				arr[i][j][k]=(int)(Math.random()*100);  //0부터 n-1값까지 랜덤으로 입력됨 난수입력
		  				arr[i][j][k]=new Random().nextInt(45)+1; //1부터45까지 숫자중에서 추출
		  			}//열
		  	}//행
	  }//면
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
	