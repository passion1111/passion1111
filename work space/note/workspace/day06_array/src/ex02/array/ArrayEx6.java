/*
package ex02.array;

//����4] int[][] arr = new int[2][3];
//������ ������ �Է� �޾Ƽ� ����ϴ� ���α׷� �ۼ�
import java.util.Scanner;

public class ArrayEx6 {
	public static void main(String[] args) {
		int[][] arr = new int[2][3];
		
		//2���� �迭 ������ ������ �Է� �ޱ�
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
//				System.out.print("array data input : ");
//				System.out.print((i + 1) + " data input : ");
				System.out.print("a["+i+"]["+j+"]= ");
				arr[i][j] = new Scanner(System.in).nextInt();
			} // j end
		} // i end
		
		System.out.println("\n\n");
		//2���� �迭 ����ϱ� 
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
		
        Scanner scanner=new Scanner(System.in);//�Է� ��ü ����
        int arr[][]=new int[3][4]; //2���� �迭 ���� �� ����
        
        System.out.println("�迭 ��� �Է� (2�� 3��): ");
        
        // ���
        for(int i=0; i < arr.length-1; i++){
            
        	for(int j=0; j <arr[i].length; j++){
                arr[i][j]=scanner.nextInt();
                
                if( i != 2 )
                    arr[2][j] += arr[i][j]; // 2�� ������ ���� ���
            } // j end
        } // i end
        
        //��� 
        for(int i=0;i<arr.length;i++){
        	
            for(int j=0;j<arr[i].length;j++)
                System.out.print(arr[i][j]+"\t");
            
            System.out.println();
        } // i end
    }
}

//*/





