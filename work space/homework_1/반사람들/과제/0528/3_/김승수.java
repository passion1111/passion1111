package personal;

public class Personal_homework3 {
	public static void main(String[] args) {
		int i;
		double  j,sum;
		sum=0;
		
			for(i=1;i<=9;i++) {
				j=(i/(i+1));
				sum+=j;
			}
			System.out.printf("%.2f",sum);
		
	}

}
