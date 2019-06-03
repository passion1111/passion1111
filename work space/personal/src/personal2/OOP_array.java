package personal2;

import java.lang.reflect.Array;
import java.util.Scanner;

class Se{
	int[] arr;
	
	public void arrSetter(int totalnumber) {
		Scanner sc=new Scanner(System.in);
		arr=new int[totalnumber];
		for(int i=0;i<totalnumber;i++) {
			arr[i]=sc.nextInt();
			System.out.println(arr[i]);
		}
		this.arr=arr;
		
		
	}
	public int[] arrGetter() {
		
		return arr;
	}
	public void arrOutput(int totalnumber) {
		for(int i=0;i<totalnumber;i++) {
			
			System.out.println(arr[i]);
		}
	}
	
	
}



public class OOP_array {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int totalnumber=sc.nextInt();
		Se s=new Se();
		s.arrSetter(totalnumber);
		s.arrOutput(totalnumber);
		
	}

}
