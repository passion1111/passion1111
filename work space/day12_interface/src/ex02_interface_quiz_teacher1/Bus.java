package ex02_interface_quiz_teacher1;

public class Bus implements Trasport {
	
	private double speed = 0;

	@Override
	public void move() {
		while( speed < 5 ) {
			speed += (accelerater * 5);
			System.out.println("Accelerating...." + speed);
			
			try {
				Thread.sleep(500);//1/1000==>1�� ,500�� 0.5��
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // while end

	}

	@Override
	public void stop() {
		speed = 0;
		System.out.println("Emergency Stop......");
	}

}
