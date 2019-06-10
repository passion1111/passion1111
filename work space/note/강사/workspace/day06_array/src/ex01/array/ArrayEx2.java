package ex01.array;

public class ArrayEx2 {
	public static void main(String[] args) {
//		int[] a = new int[5];
//		a[0] = 1;
//		a[1] = 2;
//		a[2] = 3;
//		a[3] = 4;
//		a[4] = 5;
		int[] a = {1,2,3,4,5};
		
		System.out.println("a[0] = " + a[0]);
		System.out.println("a[1] = " + a[1]);
		System.out.println("a[2] = " + a[2]);
		System.out.println("a[3] = " + a[3]);
		System.out.println("a[4] = " + a[4]);
		
		System.out.println("\n-------------------------");
		for(int i=0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
		
	}
}













