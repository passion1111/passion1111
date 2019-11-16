package check;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class SuperTyp {
	
	  public static void main(String[] args) {
	        for (AnnotatedType annotatedType : MysubClass.class.getAnnotatedInterfaces()) {
	            Type tp = annotatedType.getType();  //get annotated type
	            System.out.println(" Anotated Type :" + tp);

	            Annotation[] antn = annotatedType.getAnnotations(); //get annotations
	            System.out.println("Annotations     :"  +Arrays.toString(antn));

	            Annotation[] decAntn = annotatedType.getDeclaredAnnotations(); //getdeclared annotations
	            System.out.println("Declared Annotations     :" +Arrays.toString(decAntn));
	        }
	    }
	  private static class MysubClass implements Serializable {   //mysubclass implements serializable interface  
	    }  
}
