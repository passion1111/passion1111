package ex02.thread;

public class ThreadEx  extends Thread{
	
	String name;
	@Override
	public void run() {//스레드 실행부(구현부)
		System.out.println(name);
//		System.out.println("start() 메소드에 의해 run()이 유도된다(실현부)");
		for (int i = 0; i < 10; i++) {
			if(i==7) {
				try {
					sleep(500); //0.5초동안 1/1000이 1초다
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
						System.out.println(i);
		}
	}
	public ThreadEx(String name) {
		this.name=name;
	}
	
}
