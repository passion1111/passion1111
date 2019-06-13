package ex05.thread;

public class SimpleThread { //outer class

	
	
	static void  threadMessage(String message) {
		String threadName=Thread.currentThread().getName(); //스레디이름없으면 0 1 2 3 4로 호출
		System.out.printf("%s:%s\n\n",threadName,message);
		
	}
	
	static class MessageLoop implements Runnable{// inner class

		@Override
		public void run() {  //스레드 실행부(구현부)
				String[] importantInfo= {"aa aa", "bb b","cc c","dd d"};
				try {
					for (int i = 0; i < importantInfo.length; i++) {
						Thread.sleep(4000);//4초
						threadMessage("I wasn't done");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}//MessageLoop class end
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		long parience=10000000*60*60;
		
		if(args.length>0) {
			try {
				parience =Long.parseLong(args[0])*1000;
			} catch (Exception e) {
				System.out.println("argument integer input");
				System.exit(0);
			}
		}// end if
		
		threadMessage("Start MessageLoop thread test");
		long startTime=System.currentTimeMillis();
		Thread t=new Thread(new MessageLoop());
		t.start();
		
		while(t.isAlive()) {//쓰레드가 살아있으면
			threadMessage("still waitting");
			t.join(1000);//1초단위로 뜸
			
			if(((System.currentTimeMillis()-startTime)>parience)&&(t.isAlive())) {
				threadMessage("tired of waitting");
				t.interrupt();
				t.join();//예외발생
			}//if end
		}//while end
		threadMessage("Finally....");
		
	}
}
