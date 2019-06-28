package ex03.thread;

public class UserRunnable implements Runnable {
	
	String name;
	
	public UserRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			
			if( i == 7 ) {
				try {
					Thread.sleep(500);  //예외 발생
					System.out.println(name);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			} // if end
			System.out.println(i);
		} // for end

	}

	public static void main(String[] args) {
		
		new Thread(new UserRunnable("u1")).start();
		new Thread(new UserRunnable("u2")).start();
		new Thread(new UserRunnable("u3")).start();
		
		/*
		Runnable u1 = new UserRunnable("u1");
		Thread t1 = new Thread(u1);
		
		Thread t2 = new Thread(new UserRunnable("u2"));
		Thread t3 = new Thread(new UserRunnable("u3"));
		
		t1.start();
		t2.start();
		t3.start();
		*/
		
	}
}







