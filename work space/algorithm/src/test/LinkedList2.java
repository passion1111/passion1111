package test;

import java.lang.annotation.Retention;

import org.junit.Test;

public class LinkedList2 {

//	static int a=1;
//		
//	public static void main(String[] args) {
//		int a=10;
//		LinkedList2 test=new LinkedList2();
//		test.Test33(a);
//		System.out.println(a);
//	}
//	
//	public void Test33(int a) {
//		a+=10;
//	}

	 
	 
	 
	 
	    public static void main(String[] args){
	 
//	        Car a = new Car();
	    	Car a=new Car();
	        test t = new test();     // �� Ŭ������ �ν��Ͻ�ȭ ��Ŵ
	        System.out.println(t.value.hashCode());
	        a.carTest(t); //<--- t ��ü�� �ѱ�
	 
	        System.out.println("mainTest�� t.value :"+t.value.hashCode());
	        Car b=new Car();
	        System.out.println(a.ho);
	        Car.ho=45;
	        System.out.println(a.ho);
	        System.out.println(b.ho);
	        System.out.println(Car.ho);
	        
	        
	        TestImple test=new TestImple2();
	        test.eat();
	        //Integer�� ���� �ѱ�� �ȹٲ�
	        //�ٵ� t.value���·� �ѱ�� ���̹ٲ�. 
	    }
	 


}

class Car{	
	static int ho=33;
    public void carTest(test t){
    	t.value = 10;        // t Ŭ������ int �� value ���� 10���� ����
    	System.out.println(t.value.hashCode());
   //     System.out.println("car�� t.value :"+t.value);
 
    }
 
}
 
 
 
class test{
 
    public Integer value = 0;
    
 
}
 
