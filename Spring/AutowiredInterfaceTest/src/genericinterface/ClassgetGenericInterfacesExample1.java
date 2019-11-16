package genericinterface;

import java.lang.reflect.Type;

public class ClassgetGenericInterfacesExample1 {
	 public static void main(String []args) {           
		  
	      ClassgetGenericInterfacesExample1 obj = new ClassgetGenericInterfacesExample1();  
	      Class cls = obj.getClass();  
	  
	      Type[] tp = cls.getGenericInterfaces();  
	      if(tp.length != 0) {  
	         for(Type i : tp) {  
	            System.out.println(i.toString());  //converting I to string  
	         }  
	      } else {  
	         System.out.println("No interfaces impleamented...");  //print statement  
	      }  
	   }  
}
