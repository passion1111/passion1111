package personal;

import java.util.Scanner;

public class Persnal_dowhile2 {
	public static void main(String[] args) {
		int i=2,j=1,result;
		int sc=new Scanner(System.in).nextInt();
		do {
			result=i * j;
			System.out.println(i+ " * " +j+" = "+result);
			
			if(j==9) {
				j=0;
				i++;
			} 
			j++;
		}while(i!=sc+1);
		
		
	}

}
