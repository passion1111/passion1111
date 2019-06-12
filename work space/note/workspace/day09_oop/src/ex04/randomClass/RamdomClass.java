package ex04.randomClass;

import java.util.Random;

public class RamdomClass {
	public static void main(String[] args) {
		Random rand = new Random(); //객체생성, 메모리에할당, 생성자함수 자동호출
		
		System.out.println(rand.nextInt()); //nextInt() int형 크기안에 있는 임의적인 숫자 추출
		System.out.println(rand.nextInt(5)); // 0 ~ 4
		System.out.println(rand.nextInt(10) + 1); // 1 ~ 10
		
		for (int i = 1; i < 7; i++) {
			System.out.print(rand.nextInt(10) + 1 + " ");
		}
		
		
	}
}
