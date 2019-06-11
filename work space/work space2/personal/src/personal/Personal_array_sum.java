package personal;

public class Personal_array_sum {
	public static void main(String[] args) {
		int arr[]=new int[100];
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			arr[i]+=i+1;
			sum+=arr[i];
			System.out.println(sum);
		}
		
		
	}

}
