package loofcontrol;
//구구단 전체 출력
//2*1=2 3*1=3 4*1=4~~
//2*2=4 3*2=6 4*2=8
public class For6 {
			public static void main(String[] args) {
				int i,d,e;
				int j=1;
				 i=2;
				
				
				  for(d=1;d<=9;d++) {
				    	for(i=2;i<=9;i++) {
				    		e=i*j;
				    		System.out.print( i+"*"+ j+"="+  e+"\t");
				    	}
				    	System.out.println("");
					    j++;  
				  }
					  
				    	   
				
				
				
			}

}