package sort;
//선택 정렬
public class Selction {
	public static void main(String[] args) {
		int[] a = { 7,3,5,2,8 };
		int temp ; 
		System.out.println("******* sort전 출력 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		
		for(int i =0; i< a.length; i++) {
			for(int j= i+1; j < a.length; j++) {
				
				if(a[i] > a[j]) {  //교환
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				} // if end
				
			} // j end
		} // i end
		
		System.out.println("\n\n******* sort후 출력 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}

		
		
		
		
		
		
		
		
		
