package personal;
import java.util.Scanner;

public class Personal_2_scanner {
	public static void main(String[] args) {
		
	  Scanner scan =new Scanner(System.in);
	  int input=scan.nextInt();
			  System.out.println(input);
			  
			  if((input%2)==1)
			  {
				  System.out.println("hi");
				  
				  for(int space=1; space<=(input/2+1);space++) {
					  
					   for(int i=space; i<(input/2+1); i++) {
						   System.out.print(" ");
					   }
					   
					   for(int i=0; i<2*space-1; i++) {
						   System.out.print("*");
					   }
					      
			              System.out.print("\n");
			              
	
	  							
			              
				  }
				  for(int space2=1; space2<=(input/2);space2++) {
				     	for(int j=0;j<space2;j++) {
				     		System.out.print(" ");
				     	}
				     	for(int j=0;j<(input-2*space2);j++) {
				     		System.out.print("*");
				     	
			  }
				     	System.out.print("\n");
						  }
			  }
			  else
				  {System.out.println("false");
					  
				  }
	}
}
