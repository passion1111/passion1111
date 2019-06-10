package ex02_collection_set;

import java.util.HashSet;
import java.util.Set;

class Person{ // exnteds object가 숨겨져있음.  
	String name;
	int age;
	
	public Person(String name,int age){
		this.name=name;
		this.age=age;
		
		//equals쓸려면 overide implements를 확인하면 됨
	}

	@Override
	public boolean equals(Object obj) {//내용이 같은지 내부적으로 equlas hashcode를 같이 생성 클래스를만들면.
		if(obj instanceof Person) {//확인필요 근데 true임 이전의 오브젝트도 Person이기떄문에.
			Person temp=(Person)obj;//오브젝트니까 퍼슨으로 형변환
			return name.equals(temp.name)&age==temp.age;//이름과 나이가 같은지 비교
		}
		return false;
	}

	@Override
	public int hashCode() {//주소값도 같은지.
		return name.hashCode()+age; //위에 
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}//Person class end

public class HashsetEx2 {
	public static void main(String[] args) {
		Set set=new HashSet();
		
		
//		Person p1=new Person("hi", 33); 객체를 여러번 사용할일이 없고 add순간에만 필요하니까.
//		set.add(p1); //객체타입 넣을수 있음.
		set.add(new Person("hi", 32));  //add순간 생성
		set.add(new Person("hi", 32));  //10진수값에 나이까지 같으면 같은거니까 age를 더한것.
//										 스트링값을 다 더한후 아스키값으로 비교
								
		set.add(new Person("hi", 10));  
		set.add(new Person("david", 10)); 
		set.add(new String("happy")); //스트링은 문자값만 비교함.
		set.add(new String("happy"));
		System.out.println(set); //객체안에 여러개있으면 overide필요함.
		
		
//		  근데 overide한것들이 같아도 set은 그냥 출력해버림.
//		그것을 막을려면 equals메소드를 이용하여 객체가 같은지 비교해야함.
	}
}
