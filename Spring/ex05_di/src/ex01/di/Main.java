package ex01.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		//bean을 설정한 xml파일이 있는 위치 저장.
		String configContext="classpath:appcontext.xml";
		AbstractApplicationContext context=new GenericXmlApplicationContext(configContext);
		
		MYcats myCats=(MYcats) context.getBean("mycat");
		myCats.catAgeInfo();
		myCats.catsNameInfo();
	}
}
