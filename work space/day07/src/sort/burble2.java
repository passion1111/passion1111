package sort;
//���� ����
public class burble2 {
	public static void main(String[] args) {
		int[] a = { 7,3,5,2,8 };
		int temp ; 
		System.out.println("******* sort�� ��� : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		
		for(int i =0; i< a.length; i++) {
			for(int j= 0; j < a.length-i-1; j++) {
				
				if(a[j] > a[j+1]) {  //��ȯ  �ε�ȣ ���⿡���� > < ���Ҽ�����.
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				} // if end
				
			} // j end
		} // i end
		
		System.out.println("\n\n******* sort�� ��� : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}

		
		
		
		
		
		
		
		
		
		
	/*int[] arr= { 7 , 3 , 5 , 2 ,8 };
	int temp=0;
	for(int i=0;i<arr.length;i++)System.out.print(arr[i]+"\t"	+ "");
	for(int i=0;i<arr.length;i++) {
		for(int j=i+1;j<arr.length;j++)
			if(arr[i]>arr[j]) {
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				
				
			}
			
	}
	System.out.println("");
	for(int i=0;i<arr.length;i++)System.out.print(arr[i]+"\t");

}
}*/