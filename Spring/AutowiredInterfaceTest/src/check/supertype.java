package check;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;

public class supertype<T> {
	 AnnotatedType[] type;
	
	 @Target(ElementType.ANNOTATION_TYPE)
	 @Retention(RetentionPolicy.RUNTIME)
	 public @interface Test{
		 boolean required() default true;
	 };
	public void inject(Class<?> test) {
	
	}
	

	
}
