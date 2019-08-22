package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Client2;

@Configuration
public class JavaConfig {

	
	//Client 빈객체로 등록 될때 
	//인터페이스를 구현하는 코드를  Client2가 가지고 있지 않아도
	//초기화 시점 호출될 수 있는 메서드
	//소멸   시점에 호출될 수 있는 메서들 지정해서 사용할 수 있다
	@Bean(initMethod = "connect", destroyMethod = "close")
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("서버2");
		return client2;
	}

}
