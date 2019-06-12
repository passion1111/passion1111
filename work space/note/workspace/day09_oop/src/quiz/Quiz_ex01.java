package quiz;

import java.util.Random;

public class Quiz_ex01 {
	public static void init() {
		
		int[] arr = new int[6];
		Random rand = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(45) + 1;
			
			if (isCheck(arr, i)) {
				i--;
			}
		}

		// Ãâ·Â
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	private static boolean isCheck(int[] arr, int i) {
		
		boolean flag = false;
		
		for (int j = 0; j < i; j++) {
			if (arr[i] == arr[j])
				flag = true;
		}

		return flag;

	}

	public static void main(String[] args) {
		init();
	}
}
