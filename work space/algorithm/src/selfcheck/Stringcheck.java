package selfcheck;

import java.util.LinkedHashSet;
import java.util.Set;

public class Stringcheck {

	
	public static void main(String[] args) {
	    String s1 = new String("hello");

	    

	String s2 = new String("hello");

	String s3 = "hello";

	String s4 = "hello";

	String s5 = s1;
	String s6="loo";
	
	//상수 풀의 존재

	if(s1 == s2) System.out.println("s1과 s2 주소값이 같음");
	
	if(s2 == s3) System.out.println("s2과 s3 주소값이 같음");

	if(s3 == s4) System.out.println("s3과 s4 주소값이 같음");

	if(s3 == s4) System.out.println("s5과 s1 주소값이 같음");

	if(s1.equals(s2)) System.out.println("s1과 s2 객체 내용이 같음");

	if(s1.equals(s3)) System.out.println("s1과 s3 객체 내용이 같음");
	if(s1==s3)System.out.println("체크1");
	if(s1.equals(s6))System.out.println("체크2");
	if(s1==s6)System.out.println("체크3");
	System.out.println(s1.hashCode());
	System.out.println(s2.hashCode());
	System.out.println(s3.hashCode());
	//this == object 
	if(s1.equals("hello"))System.out.println("체크");
	
	member a=new member("1");
	member b=new member("1");
	System.out.println(a.hashCode());
	System.out.println(b.hashCode());
	System.out.println(a.equals(b));
	System.out.println(a==b);
	Set<?> set= new LinkedHashSet();
	
	}
	
	public void check(String check) {
		
	}
}
