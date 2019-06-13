package ex02.thread;

public class MainEnry  {
	
	public static void main(String[] args) {
		new Thread(new ThreadEx("u1")).start(); //t1안만들고 바로도 가능함여
		
		Thread t1=new ThreadEx("t1");
		Thread t2=new ThreadEx("t2");
		Thread t3=new ThreadEx("t3");
		Thread t4=new ThreadEx("t4");
				
		t1.start();//run()유도한다.
		t2.start();
		t3.start();
		t4.start();//개판으로 나온다.
	}
	
}
