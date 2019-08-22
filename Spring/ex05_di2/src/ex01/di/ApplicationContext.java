package ex01.di;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration            //spring 설정에 사용되는 클래스임을 명시.
public class ApplicationContext {
	public Mycats cat1() {
		ArrayList<String> hobbys=new ArrayList<String>();
		hobbys.add("꾹꾹이");
		hobbys.add("꾹꾹이1");
		hobbys.add("꾹꾹이2");
		hobbys.add("꾹꾹이3");
		hobbys.add("꾹꾹이4");
		hobbys.add("꾹꾹이5");
		hobbys.add("꾹꾹이6");
		hobbys.add("꾹꾹이7");
		hobbys.add("꾹꾹이9");
		hobbys.add("꾹꾹이9");
		Mycats myCats=new Mycats("화", 2, 33, "그린", hobbys);   
		myCats.setColor("블랙");   //setter
		
		
		return myCats;
		
	}
	
	
	
	@Bean
	public Mycats cat2() {
		ArrayList<String> hobbys=new ArrayList<String>();
		hobbys.add("뒤집기");
		hobbys.add("뒤집기1");
		hobbys.add("뒤집기2");
		hobbys.add("뒤집기3");
		hobbys.add("뒤집기4");
		hobbys.add("뒤집기5");
		hobbys.add("뒤집기6");
		hobbys.add("뒤집기7");
		hobbys.add("뒤집기9");
		hobbys.add("뒤집기9");
		Mycats myCats=new Mycats("수", 3, 33, "그린", hobbys);   
		myCats.setColor("블랙");   //setter
		
		
		return myCats;
		
	}
	
	@Bean
	public Cats catsInfo() {
		Cats cats=new Cats(this.cat1());
		return cats; 
	}
	
	
	
	
	
	
	
	
}
