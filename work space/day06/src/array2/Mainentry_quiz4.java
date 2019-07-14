package array2;

import java.util.Random;

// ����4 
//      
//      1 *  2  2
//      5 *  7  35

//    10  9  13 25
public class Mainentry_quiz4 {

	public static void main(String[] args) {
		
		int[][] arr={{10,20,0},{1,2,0},{5,7,0}};
		
		for(int i=0;i<arr.length;i++) {
			arr[i][arr.length-1]=arr[i][arr.length-2]*arr[i][arr.length-3];
			
			
		}
		for(int i=0;i<arr.length;i++) {//i=0;i<2;i++
			for(int  j=0;j<arr[0].length;j++) {
				System.out.print("arr["+i+"]["+j+"]= "+arr[i][j]+" \t");
				
				
			}
			System.out.println("");
		}
		Random a=new Random();
	int b=a.nextInt(55);
	System.out.println(b);
		
		
		
		
		
	}
}

