package ex02.thread;

public class ThreadEx  extends Thread{
	
	String name;
	@Override
	public void run() {//������ �����(������)
		System.out.println(name);
//		System.out.println("start() �޼ҵ忡 ���� run()�� �����ȴ�(������)");
		for (int i = 0; i < 10; i++) {
			if(i==7) {
				try {
					sleep(500); //0.5�ʵ��� 1/1000�� 1�ʴ�
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
