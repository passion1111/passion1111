package ex03.thread;

public class ThreadRunnable implements Runnable{
	String name;
	
	public ThreadRunnable(String name) {
		this.name=name;
	}
	
	
	

	@Override
	public void run() {
			
		for (int i = 0; i <=10; i--) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
			if(i==7) {
				
					//runnable�� �����޼ҵ带 �Ȱ��������� 
					
				
				//if end
				
			}//for end
		}
	}
public static void main(String[] args) {
		Runnable u1=new ThreadRunnable("u1");
		Thread t1=new Thread(u1);
		Thread t2=new Thread(new ThreadRunnable("u2"));
		Thread t4=new Thread(new ThreadRunnable("u3"));
		Thread t3=new Thread(new ThreadRunnable("u4"));
		
		//start������.
		t1.start();
		t2.start();
		t3.start();
}
}
