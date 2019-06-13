package quiz;
//구구단 출력하기 thread 이용할것
public class quiz2 extends Thread{
	 
	 
	public void run() {
		
		try {
			for (int i = 2; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					System.out.println(i*j);
					sleep(3000);
				}
				
				}
					
				}
			 catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
}