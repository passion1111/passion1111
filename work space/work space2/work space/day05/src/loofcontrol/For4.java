package loofcontrol;
//1~100���� �߿��� 3�� ����� �հ� ������?
public class For4 {
				public static void main(String[] args) {
					int i;
					int sum=0;
					int j=0;
					for(i=1;i<=100;i++) {
						if(i%3==0) { 
							
							sum+=i;
							j++;//count+=1�� ���� count=count+1�ε� ������ �˾Ƶα�.
						}					
					}
					System.out.println("3�� ����� ����"+sum);
					System.out.println("3�� ����� ������"+j);
				
				}
	
	
}