package ex01.For;

import java.util.Scanner;

//����5] ���ϴ� ���� �Է� �޾Ƽ� ������ ����ϴ� ���α׷� �ۼ�
public class ForEx3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("dan = ");
		int dan = sc.nextInt();
		
		for(int i=1; i<= 9; i++) {
//			System.out.println(dan + " * " + i + " = " + (dan*i));
			System.out.printf("%d *%2d=%2d\n", dan, i, (dan*i));
		} // end for
	}
}





