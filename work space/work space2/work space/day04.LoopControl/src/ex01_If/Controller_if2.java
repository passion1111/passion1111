package ex01_If;

import java.util.Scanner;

public class Controller_if2 {
	public static void main(String[] args) {

		System.out.print("integer data input : ");
		int su = new Scanner(System.in).nextInt();
		if (su % 2 == 0) {
			System.out.println("¦���Դϴ�");
		            if(su>0) 
			                  System.out.println("���");
		            else if(su<0)
			                     System.out.println("����");
		            else
		                    	 System.out.println("0�̱���");         //¦�� Ȧ���� ����̳� �����̳ķ� �ҷ��� if���ȿ� if�� �ߺ��ڵ�� �ֱ⋚����
		            															//�ߺ��ڵ带 ���̱����ؼ��� �޼ҵ带 �ϳ� ������� �ʿ䰡 �ִ�.
	}
		else {
			System.out.println("Ȧ���Դϴ�");
			        if(su>0) 
                 System.out.println("���");
			       	else if(su<0)
                    System.out.println("����");
			       	else
               	 System.out.println("0�̱���");  
							
						}
}
}