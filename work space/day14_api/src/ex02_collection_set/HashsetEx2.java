package ex02_collection_set;

import java.util.HashSet;
import java.util.Set;

class Person{ // exnteds object�� ����������.  
	String name;
	int age;
	
	public Person(String name,int age){
		this.name=name;
		this.age=age;
		
		//equals������ overide implements�� Ȯ���ϸ� ��
	}

	@Override
	public boolean equals(Object obj) {//������ ������ ���������� equlas hashcode�� ���� ���� Ŭ�����������.
		if(obj instanceof Person) {//Ȯ���ʿ� �ٵ� true�� ������ ������Ʈ�� Person�̱⋚����.
			Person temp=(Person)obj;//������Ʈ�ϱ� �۽����� ����ȯ
			return name.equals(temp.name)&age==temp.age;//�̸��� ���̰� ������ ��
		}
		return false;
	}

	@Override
	public int hashCode() {//�ּҰ��� ������.
		return name.hashCode()+age; //���� 
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}//Person class end

public class HashsetEx2 {
	public static void main(String[] args) {
		Set set=new HashSet();
		
		
//		Person p1=new Person("hi", 33); ��ü�� ������ ��������� ���� add�������� �ʿ��ϴϱ�.
//		set.add(p1); //��üŸ�� ������ ����.
		set.add(new Person("hi", 32));  //add���� ����
		set.add(new Person("hi", 32));  //10�������� ���̱��� ������ �����Ŵϱ� age�� ���Ѱ�.
//										 ��Ʈ������ �� ������ �ƽ�Ű������ ��
								
		set.add(new Person("hi", 10));  
		set.add(new Person("david", 10)); 
		set.add(new String("happy")); //��Ʈ���� ���ڰ��� ����.
		set.add(new String("happy"));
		System.out.println(set); //��ü�ȿ� ������������ overide�ʿ���.
		
		
//		  �ٵ� overide�Ѱ͵��� ���Ƶ� set�� �׳� ����ع���.
//		�װ��� �������� equals�޼ҵ带 �̿��Ͽ� ��ü�� ������ ���ؾ���.
	}
}
