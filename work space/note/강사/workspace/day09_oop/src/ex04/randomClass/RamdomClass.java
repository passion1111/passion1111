package ex04.randomClass;

import java.util.Random;

public class RamdomClass {
	public static void main(String[] args) {
		Random rand = new Random(); //��ü����, �޸𸮿��Ҵ�, �������Լ� �ڵ�ȣ��
		
		System.out.println(rand.nextInt()); //nextInt() int�� ũ��ȿ� �ִ� �������� ���� ����
		System.out.println(rand.nextInt(5)); // 0 ~ 4
		System.out.println(rand.nextInt(10) + 1); // 1 ~ 10
		
		for (int i = 1; i < 7; i++) {
			System.out.print(rand.nextInt(10) + 1 + " ");
		}
		
		
	}
}
