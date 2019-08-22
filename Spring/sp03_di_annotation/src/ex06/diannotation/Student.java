package ex06.diannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student implements Person {
Person person;

	@Override
	public void info() {
		System.out.println("여기는 학생 20살  이름은 뭐뭐 ");
	}
	
	@Autowired
	@Qualifier("student")
	public void setStudent(Person person) {
		this.person = person;
	}
	

}
