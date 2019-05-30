package array;


public class MainEntry7 {

		public static void main(String[] args) {
		int[] arr=new int[100];
		

		for(int i=0;i<arr.length;i++) {
				arr[i]=(i+1)*5;//5의 배수 저장 
//				arr[i]=i+1 //1부터 100까지 저장
		}
		for(int i=0;i<arr.length;i++) {
			 System.out.print(arr[i]+"\t");
			 if((i+1)%10==0)System.out.println("");
	}
		
		}
}




