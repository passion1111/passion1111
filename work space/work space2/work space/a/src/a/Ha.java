package a;

public class Ha {
	
	
		public static void main(String args[])
		{
			
			
			for(int space = 0;space<5; space++) {
				for(int aa = 0; aa<5-space; aa++) 
				{
					System.out.print(" ");
				}
				for (int aa = 0; aa<2*space-1; aa++)
				{
					System.out.print("*");
				}
				System.out.println("\n");
			}
			
			for(int space = 0;space<5; space++) {
				for(int bb = 0; bb<space+1;bb++) 
				{
					System.out.print(" ");
				}
				for (int aa = 5-space; 0<aa; aa--)
				{
					System.out.print("*");
				}
				System.out.println("\n");
			}
		
		     
		    	 
		     
		     
		
		
		
	}
}

		
	


