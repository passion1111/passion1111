package ex02_for_star;

public class For_star5 {
	public static void main(String[] args) {
		int i=0,d=1;
		for(d=1;d<=5;d++) {
		for(i=0;i<5-d;i++) {
			 System.out.print(" ");
		}
			   for(int j=1;j<=d;j++) {
				   System.out.print("*");
		
			  }
			  System.out.println("");
		 
	
		}
	}
}
