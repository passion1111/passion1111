package ex05.syncronized;

import java.util.PrimitiveIterator;

public class SimpleThread {  // outer class
	
	static void threadMessage(String message) {
		
		String threadName = Thread.currentThread().getName();
		System.out.printf("%s : %s\n\n", threadName, message);
	}
	
	static class MessageLoop implements Runnable {  // inner class

		@Override
		public void run() {  //스레드 실행부(구현부)
			String[] importantInfo = {"aa aa", "bb b", "cc c", "dd d"};
			
			try {
				for(int i=0; i < importantInfo.length; i++) {
					Thread.sleep(4000); // 4초
					threadMessage("I wasn't done!!!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}// MessageLoop class end
	
	public static void main(String[] args) throws InterruptedException {
		long parience = 100000 * 60 * 60;
		
		if( args.length > 0 ) {
			try {
				parience = Long.parseLong(args[0]) * 1000;
				
			} catch (Exception e) {
				System.out.println("argument integer input ");
				System.exit(0); //강제 종료
			}
			
		} //end if
		
		threadMessage("Start MessageLoop thread test");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		
		System.out.println(System.currentTimeMillis() - startTime);
		
		while( t.isAlive() ) {
			threadMessage("still waitting..................");
			t.join(1000); //예외발생
			
			if(((System.currentTimeMillis() - startTime) > parience) && t.isAlive() ) {
				threadMessage("Tired of watting............");
				
				t.interrupt();
				t.join(); //예외발생
			}//if end
		}//while end
		
		threadMessage("Finally.............");
	}
}














