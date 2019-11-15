package check;

public class MyClass{
	 
	  private static String myName = null;
	  public String pubString = null;
	 
	  private void hiddenMethod()
	  {
	    System.out.print("hello private");
	  }
	 
	  public MyClass()
	  {
	  }
	 
	  public int mySum(int a,int b)
	  {
	    return a+b;
	  }
	 
	  public MyClass (String myname){
	    this.myName = myname;
	  }
	  public String getMyName()
	  {
	    return myName;
	  }
	 
	  public void setMyName(String myName)
	  {
	    this.myName = myName;
	  }
	} // javac MyClass.java


