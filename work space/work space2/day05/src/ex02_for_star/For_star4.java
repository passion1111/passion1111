package ex02_for_star;
//�� ���̾����
public class For_star4 {
		public static void main(String[] args) {
			int j,d,a,b = 0;
			int i=0;
			d=0;
			i=d=a=b;
		
			
	for(d=1;d<=5;d++) {
			     for(;i<=4;i++) {
			    	 System.out.print("*");
			
			     }
			     for(a=0;a<(2*(d-1)-1);a++) {
			    	 
			    	 System.out.print(" ");
			     }
			     for(;b<4;b++) {
			    	 System.out.print("*");
			     }
			     System.out.println("");
			     i=a=d;
			     b=d-1;
	}
	i=d=a=b=0;

	
	for(d=1;d<5;d++) {
		for(i=0;i<=d;i++) {
			if(i==4)continue;
	    	 System.out.print("*");
	    	 
	}
		for(a=1;a<=7-(2*d);a++) {
	    	 
	    	 System.out.print(" ");
	     }
		for(i=0;i<=d;i++) {
			
	    	 System.out.print("*");
	    	 if(i==4)continue;
		}
		System.out.println("");
		
			     
		
			
			
		
	
}
}
}