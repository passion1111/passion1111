package quiz.lotto;

//import java.util.Arrays;
//import java.util.Random;

import java.util.*;

public class Homework2 {
	
	public static void main(String[] args) {
	        Random rand = new Random();
	
	        int[] num = new int[6];
	 
	        for (int i = 0; i < num.length; i++) {
	        	
	        	num[i] = rand.nextInt(45) + 1;  // 1 ~ 45 
	        	
	            for (int j = 0; j < i; j++) {
	            	
	                if ( num[i] == num[j]) {
	                    	i--;
	                } // if end
	            } // i end
	        } // j end
	        
	        Arrays.sort(num);  //
	        for (int j = 0; j < num.length; j++)
	            System.out.print(num[j] + 1 + "\t");
	}// main
}
//*/




