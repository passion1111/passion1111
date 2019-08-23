package ex05.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEntry {

	public static void main(String[] args){
		//스프링 컨테이너.
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(ConfigContext.class);
        User user = ac.getBean("user",User.class);
        user.test();
        
        User u2 = ac.getBean("user",User.class);
        u2.test();
            
        User2 user2 = ac.getBean("user2",User2.class);
        user2.user2test();
        
        System.out.println(user.hashCode());  
        System.out.println(u2.hashCode());   // singleton 
    }

}
