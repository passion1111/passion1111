package personal;

public class Personal_array_practice {
	public static void main(String[] args) {
		
		int[] score=new int[] {1,2,3,4,5};
		int[] newnumber=new int[10];
		
		for(int i=0;i<newnumber.length;i++) {
			newnumber[i]=score[i];
		}
		for(int i=0;i<newnumber.length;i++)
		{
			System.out.println(newnumber[i]);
		}
		
	}
}