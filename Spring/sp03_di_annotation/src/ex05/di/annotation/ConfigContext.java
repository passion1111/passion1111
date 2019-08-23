package ex05.di.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //스프링에서 사용되는 클래스임을 알려주는  어노테이션임으로  명시.
public class ConfigContext {
	
    @Bean //객체생성 어노테이션.
    public User user(){ // 메서드 이름이 빈의 이름이 된다.
        return new User();
    }
    //<bean id="user" class="ex05.di.annotation.User" />
       
    @Bean
    public User2 user2(){ // 메서드 이름이 빈의 이름이 된다.
        return new User2();
    }
    //<bean id="user2" class="ex05.di.annotation.User2" />
   
}
/*
   <bean id="user" class="ex05.di.annotation.User" />
   id의 user는 메소드의 이름이고
   class의 User는 ex05.di.annotation안에 있는 User.class를 의미한다
    만약 bean id를 user 가 아닌 다른 것으로 변경하고 싶다면 @Bean(name="hello") 와 같이 설정하면 된다.
   이러한 방식으로 생성된 각 빈간의 의존 관계는 메서드를 호출 함으로써 의존 관계를 설정 할 수 있다.
   또한 @Bean 어노테이션의 autowire 속성을 이용하여 연관 자동 설정을 할수 있다.
  <bean name="user"  class=""   autowire="byName" />
 */

