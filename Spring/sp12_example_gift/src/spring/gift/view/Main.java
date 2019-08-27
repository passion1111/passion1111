package spring.gift.view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.dao.GiftBeanFactory;
import springbook.user.dao.GiftDAO;

public class Main {
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(GiftBeanFactory.class);
		
		
		GiftDAO dao=ctx.getBean("giftdao",GiftDAO.class);
		dao.selectAll();
		
	}
}
