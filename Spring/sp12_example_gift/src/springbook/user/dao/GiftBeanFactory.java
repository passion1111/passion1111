package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GiftBeanFactory {

	 public GiftBeanFactory() {
		 
	 }
	 @Bean
	 public GiftDAO giftdao() {
		 GiftDAO dao=new GiftDAO(connectionMaker());
		 return dao;
	 }
	 @Bean
	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker=new NConnectionMakerImpl();
		return connectionMaker;
	}
}
