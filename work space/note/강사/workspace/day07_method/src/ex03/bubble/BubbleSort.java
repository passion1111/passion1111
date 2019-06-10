package ex03.bubble;

public class BubbleSort {
	public static void main(String[] args) {
		int[] a = { 7, 1, 3, 5, 2 };
		int temp;

		System.out.println("sort 전 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		} // for end

		// sort
		for (int i = 0; i < a.length; i++) { // 4까지
			for (int j = 0; j < a.length - i - 1; j++) { // j를 4-i-1까지 // j는 증가

				if (a[j] < a[j + 1]) { // 내름차순 //if (a[j] > a[j + 1]) { // 오름차순
					temp = a[j]; // temp변수를 이용해 서로의 값change
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}

			} // j end
		} // i end
		System.out.println("\nsort 후 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		} // for end
	}
}
