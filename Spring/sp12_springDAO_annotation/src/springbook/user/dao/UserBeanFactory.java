package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanFactory {

	 public UserBeanFactory() {
		 
	 }
	 @Bean
	 public UserDAO userDao() {
		 UserDAO dao=new UserDAO(connectionMaker());
		 return dao;
	 }
	 @Bean
	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker=new NConnectionMakerImpl();
		return connectionMaker;
	}
}
