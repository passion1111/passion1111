package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean {
    /////////////////////////////////////////////////
	public Client(){
		System.out.println("Default");
	}
	
	private String defaulthost;
	public Client(String defaulthost){
		this.defaulthost =defaulthost;
		System.out.println("생성자 : " + this.defaulthost);
	}
	////////////////////////////////////////////////////
	
	
	private String host; //setter 구현

	public void setHost(String host) {
		this.host = host;
		System.out.println("Client.setHost() 실행");
	}

	//초기화 메서드  (이벤트를 내부적으로 가지고 자동 호출 : 호출시점)
	//InitializingBean 대한 구현부
	//afterPropertiesSet : property injection 후에
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.afterPropertiesSet() 실행");
	}

	public void send() {           /* <property name="host" value="서버" /> */
		System.out.println("Client.send() to " + host);    
	}

	//소멸 메서드 (이벤트를 내부적으로 가지고 자동 호출 : 호출시점)
	//DisposableBean 대한 구현부 
	@Override
	public void destroy() throws Exception {         /* ctx.close(); */
		System.out.println("Client.destroy() 실행");
	}
	
}
