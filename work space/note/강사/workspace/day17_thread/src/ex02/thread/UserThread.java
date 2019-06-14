package ex02.thread;

public class UserThread extends Thread {  //
	
	String name;
	
	public UserThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {  //������ �����(������)
		System.out.println(name);
//		System.out.println("start() �޼ҵ忡 ���� run()�� �����ȴ�(������)");
		
		for (int i = 1; i <= 10; i++) {
			
			if( i == 7 ) {
				try {
					sleep(500); // 0.5�� ����,  1/1000 <== 1��
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} //if end
			
			System.out.println(i);
		} //for end
	}

	
}







