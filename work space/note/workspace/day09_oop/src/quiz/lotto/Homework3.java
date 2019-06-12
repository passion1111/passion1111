package quiz.lotto;

import java.util.Random;

public class Homework3 {
	
	static int[] array = new int[6];

	public static void checkNum(int i) {
		Random ran = new Random();
		for (int j = 0; j < i; j++) {
			while (array[j] == array[i]) {
				array[i] = (ran.nextInt(45) + 1);
				j = 0;
			}
		}
	}

	public static void genNum() {
		Random ran = new Random();
		for (int i = 0; i < array.length; i++) {
			// 값 입력
			array[i] = (ran.nextInt(45) + 1);

			// 값 체크
			checkNum(i);
		}
	}

	public static void printArray() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "   ");
		}
	}

	public static void main(String[] args) {
		genNum();
		printArray();
	}
}
