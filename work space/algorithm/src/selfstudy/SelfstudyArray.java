package selfstudy;

public class SelfstudyArray {

	
	public static void  ArraySwap(int[] arr) {
		arr[0]=1;
		
		
	}
	public static void ArraySwap(String[] arr,String aaa) {
		arr[0]="bye";
		aaa="hihi";
	}
	
	public static void main(String[] args) {
		int[] testarray= {2,3,4};
		ArraySwap(testarray);
		System.out.println(testarray[0]);
		String[] testStringArray= {"hi","bye"};
		String test22="hihihihi";
		ArraySwap(testStringArray,test22);
		System.out.println(testStringArray[0]);
		System.out.println(test22);
	}
}
