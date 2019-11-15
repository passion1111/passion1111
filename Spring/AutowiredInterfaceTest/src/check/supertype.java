package check;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;

public class supertype<T> {
	 Class<T> type;
	
	public void inject(Class<?> test) {
		this.type= (Class<T>) test.getClass().getClass();
	}
	

	
}
