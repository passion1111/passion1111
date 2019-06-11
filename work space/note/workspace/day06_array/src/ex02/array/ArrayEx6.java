/*
package ex02.array;

//문제4] int[][] arr = new int[2][3];
//임의의 데이터 입력 받아서 출력하는 프로그램 작성
import java.util.Scanner;

public class ArrayEx6 {
	public static void main(String[] args) {
		int[][] arr = new int[2][3];
		
		//2차원 배열 임의의 데이터 입력 받기
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
//				System.out.print("array data input : ");
//				System.out.print((i + 1) + " data input : ");
				System.out.print("a["+i+"]["+j+"]= ");
				arr[i][j] = new Scanner(System.in).nextInt();
			} // j end
		} // i end
		
		System.out.println("\n\n");
		//2차원 배열 출력하기 
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(arr[i][j] + " ");
			} // j end
			System.out.println();
		} // i end
		
	}
}
//*/



//*
package ex02.array;

import java.util.Scanner;

public class ArrayEx6 {
	public static void main(String[] args){
		
        Scanner scanner=new Scanner(System.in);//입력 객체 생성
        int arr[][]=new int[3][4]; //2차원 배열 선언 및 생성
        
        System.out.println("배열 요소 입력 (2행 3렬): ");
        
        // 계산
        for(int i=0; i < arr.length-1; i++){
            
        	for(int j=0; j <arr[i].length; j++){
                arr[i][j]=scanner.nextInt();
                
                if( i != 2 )
                    arr[2][j] += arr[i][j]; // 2행 각열에 더한 결과
            } // j end
        } // i end
        
        //출력 
        for(int i=0;i<arr.length;i++){
        	
            for(int j=0;j<arr[i].length;j++)
                System.out.print(arr[i][j]+"\t");
            
            System.out.println();
        } // i end
    }
}

//*/






