package array;

import java.util.Scanner;

public class MainEntry6 {

		public static void main(String[] args) {
		int[][] arr=new int[6][];
		arr[0]=new int[1];
		arr[1]=new int[2];
		arr[2]=new int[3];
		arr[3]=new int[4];
		arr[4]=new int[1];
		arr[5]=new int[1];
		int value=0;
		System.out.println(arr.length);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=value;
				value++;
			}
			
			}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
		System.out.println(arr[i][j]);
		
			}
		}
	}
}
	





