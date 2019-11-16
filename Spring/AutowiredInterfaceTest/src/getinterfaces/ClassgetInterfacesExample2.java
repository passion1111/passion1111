package getinterfaces;

//import statements  

import java.io.Serializable;  

public class ClassgetInterfacesExample2 {  

  public static void main(String... args) {  
      Class<SampleClass> cls1 = SampleClass.class;
      Class<?>[] interfaces = cls1.getInterfaces();  
      for (Class<?> intrfc : interfaces) {  
          System.out.println(intrfc);  
      }  
  }  
  private static class SampleClass implements Serializable, Runnable{  
      @Override  
      public void run() {  

      }  
  }  

}  