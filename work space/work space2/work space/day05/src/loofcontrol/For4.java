package loofcontrol;
//1~100까지 중에서 3의 배수의 합과 개수는?
public class For4 {
				public static void main(String[] args) {
					int i;
					int sum=0;
					int j=0;
					for(i=1;i<=100;i++) {
						if(i%3==0) { 
							
							sum+=i;
							j++;//count+=1도 같고 count=count+1로도 같으니 알아두길.
						}					
					}
					System.out.println("3의 배수의 합은"+sum);
					System.out.println("3의 배수의 개수는"+j);
				
				}
	
	
}
