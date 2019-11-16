package check;

	import java.io.Serializable;  
	import java.lang.annotation.*;  
	import java.lang.reflect.AnnotatedType;  
	import java.lang.reflect.Type;  
	import java.util.Arrays;  
	  
	public class ClassgetAnnotatedInterfaceExample2  {  
	  
	    public static void main(String[] args) {  
	        AnnotatedType[] antype = MyClass.class.getAnnotatedInterfaces();  
	        for (AnnotatedType annotatedType : antype) {   
	            Type tp = annotatedType.getType();  //get annotated type  
	            System.out.println("Annotated Type :" + tp);  
	            
	            System.out.println("---------------------------------------------------------------------");  
	            Annotation[] ann = annotatedType.getAnnotations();  //get annotations  
	            System.out.println("Annotations :"  + Arrays.toString(ann));  
	            Annotation[] declared = annotatedType.getDeclaredAnnotations();   //getdeclaredannotations  
	            System.out.println("Declared Annotation :"   +Arrays.toString(declared));  
	        }  
	    }  
	  
	    @Retention(RetentionPolicy.RUNTIME)  
	    @Target({ElementType.TYPE_USE})  
	    private @interface FileSystem {  
	    }  
	  
	    private static class MyClass implements @FileSystem Serializable  {   
	//mysubclass implements serializable interface  
	  
	    }  
	}  
