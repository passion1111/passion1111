package check;
import java.io.*;
import java.lang.reflect.*;
 
public class Reflection
{
  public static void main(String args[])
  {
    try{
      Class myClass = Class.forName("check.MyClass");
      Constructor myConstuctor = myClass.getConstructor( new Class[] {String.class });
      Object myObj = myConstuctor.newInstance("kaspyx");
      Method method = myClass.getMethod("getMyName");
      
      String myName = (String)method.invoke(myObj);
 
      System.out.println("Myname is "+ myName);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
} // javac MyReflector.java



