package ex02.thread;

public class MainEnry  {
	
	public static void main(String[] args) {
		new Thread(new ThreadEx("u1")).start(); //t1�ȸ���� �ٷε� �����Կ�
		
		Thread t1=new ThreadEx("t1");
		Thread t2=new ThreadEx("t2");
		Thread t3=new ThreadEx("t3");
		Thread t4=new ThreadEx("t4");
				
		t1.start();//run()�����Ѵ�.
		t2.start();
		t3.start();
		t4.start();//�������� ���´�.
	}
	
}
