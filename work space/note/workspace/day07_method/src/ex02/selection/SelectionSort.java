package ex02.selection;

public class SelectionSort {
	public static void main(String[] args) {
		int[] a = { 7,3,5,2,8 };
		int temp ; 
		System.out.println("******* sort�� ��� : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		
		for(int i =0; i< a.length; i++) {  // sort 
			for(int j= i+1; j < a.length; j++) {
				
				if(a[i] > a[j]) {  //��ȯ
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				} // if end
				
			} // j end
		} // i end
		
		System.out.println("\n\n******* sort�� ��� : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}





