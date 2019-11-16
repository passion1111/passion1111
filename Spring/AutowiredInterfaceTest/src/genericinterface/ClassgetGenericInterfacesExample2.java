package genericinterface;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.math.BigInteger;

public class ClassgetGenericInterfacesExample2 {  
	  String a="aa";

    public static void main(String... args) {  
         
    	Class<?> cls = SampleClass.class; 
        System.out.println(cls.getName());
        Type[] gentp = cls.getGenericInterfaces();  
        for (Type gen : gentp) {  
            System.out.println(gentp);  
            Type(gen);  
        }  
    }  
  
      private static void Type(Type tpp) {  
        if (tpp instanceof Class) {  
            System.out.println("type is Class");  
            System.out.println("class name: " + ((Class) tpp).getSimpleName());
            System.out.println("class name: " + ((Class) tpp).getClass());
        } else if (tpp instanceof ParameterizedType) {  
            System.out.println("type is ParameterizedType");  
            Type[] a = ((ParameterizedType) tpp).getActualTypeArguments();  
            System.out.println("printing each one of ActualTypeArguments:");  
            System.out.println("----");  
            for (Type type1 : a) {  
                Type(type1);  
            }  
            System.out.println("----");  
        } else if (tpp instanceof TypeVariable) {  
            System.out.println("type is TypeVariable");  
            String typeVariableName = ((TypeVariable) tpp).getName();  
            System.out.println("typeVariableName: " + typeVariableName);  
  
        } else if (tpp instanceof GenericArrayType) {  
            System.out.println("type is GenericArrayType");  
            Type genericComponentType =  
                    ((GenericArrayType) tpp).getGenericComponentType();  
            Type(genericComponentType);  
        }  
    }  
  
    private static class SampleClass implements Interface1<String, BigInteger> {

		@Override
		public void testA() {
			System.out.println("맞아 테스트A다");
		}
    	
    }  
  
    private static interface Interface1<T, R> {
    	public void testA();
    }  
}  