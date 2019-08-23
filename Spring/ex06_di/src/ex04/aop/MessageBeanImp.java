package ex04.aop;

public class MessageBeanImp implements MessageBean {

	@Override
	public void sayHello() {

			System.out.println("여기는 세이 헬로");
			
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
	}

	@Override
	public void engHello() {

		System.out.println("여기는 엥 헬로");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
