package ex04.aop;

public class MessageBeanImpl implements MessageBean {

	@Override
	public void sayHello() {
		System.out.println("public void sayHello() »£√‚µ ");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void engHello() {
		System.out.println("public void engHello() »£√‚µ ");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}





