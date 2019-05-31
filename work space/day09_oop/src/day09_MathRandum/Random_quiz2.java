package day09_MathRandum;
import java.util.Random;
import java.util.Scanner;		
public class Random_quiz2 {

public static void main(String[] args) {
	
	int[]rotto=new int[6];
	Random random=new Random();
	int i=0,i2=0;
	for(int i1=0;i1<rotto.length;i1++) 
	{
		rotto[i1]=random.nextInt(6)+1;
		
		for( i2=0;i2<i1;i2++) {
			if(rotto[i2]==rotto[i1]) {
				i1--;
			}			
		}      
	}//for end
	
	for(i=0;i<rotto.length;i++) {
		System.out.println(rotto[i]);
	}
	
	
	
}
}
	
	

