package ex02.Switch;

import java.util.Scanner;

public class Controller_Switch3 {
	public static void main(String[] args) {
		System.out.print("����� ����Ʈ = ");
		Scanner sc = new Scanner(System.in);
		int point = sc.nextInt();
		
		switch (point) { 
			case 1: System.out.print("�� "); //break;
			case 2: System.out.print("�ǾƳ� "); //break;
			case 3: System.out.print("��� "); //break;
		} //switch end
		
		System.out.println("��ǰ�� ��÷ �Ǽ̽��ϴ�. �����մϴ�.^^ ");
	}
}







