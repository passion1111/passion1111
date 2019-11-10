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
	        test t = new test();     // 두 클래스를 인스턴스화 시킴
	        System.out.println(t.value.hashCode());
	        a.carTest(t); //<--- t 객체를 넘김
	 
	        System.out.println("mainTest의 t.value :"+t.value.hashCode());
	        Car b=new Car();
	        System.out.println(a.ho);
	        Car.ho=45;
	        System.out.println(a.ho);
	        System.out.println(b.ho);
	        System.out.println(Car.ho);
	        
	        
	        TestImple test=new TestImple2();
	        test.eat();
	        //Integer로 값을 넘기면 안바뀜
	        //근데 t.value형태로 넘기면 값이바뀜. 
	    }
	 


}

class Car{	
	static int ho=33;
    public void carTest(test t){
    	t.value = 10;        // t 클래스의 int 형 value 값을 10으로 변경
    	System.out.println(t.value.hashCode());
   //     System.out.println("car의 t.value :"+t.value);
 
    }
 
}
 
 
 
class test{
 
    public Integer value = 0;
    
 
}
 
