package ex07_string;

public class StringMain {
	public static void main(String[] args) {
		int x=3,y=5;
		System.out.println("x="+x+", y= "+y);
		x=y;
		System.out.println("x="+x+", y= "+y);
		

		
		System.out.println("x = " + x + ", y = " + y);
		x = y;
		System.out.println("x = " + x + ", y = " + y);
		
		String str1 = "korea";
		String str2 = "happy";
		System.out.println("str1 = " + str1 + ", str2 = " + str2);
		System.out.println("hashcode : " + str1.hashCode() 
									+ "\t, " + str2.hashCode());
		
		str1 = str2;
		System.out.println("str1 = " + str1 + ", str2 = " + str2);
		System.out.println("hashcode : " + str1.hashCode() 
		+ "\t, " + str2.hashCode());
		
		str2 = "seoul";
		System.out.println("str1 = " + str1 + ", str2 = " + str2);
		System.out.println("hashcode : " + str1.hashCode() 
		+ "\t, " + str2.hashCode());
		
		str2 = "doyeon";
		System.out.println("str1 = " + str1 + ", str2 = " + str2);
		System.out.println("hashcode : " + str1.hashCode() 
		+ "\t, " + str2.hashCode());
		
		String str3 = "doyeon";
		System.out.println("str1 = " + str1 + ", str2 = " + str2 + ", str3 = "+str3);
		System.out.println("hashcode : " + str1.hashCode() 
		+ "\t, " + str2.hashCode()+ "\t, " + str3.hashCode());
		
		str3 = "kbs";
		System.out.println("hashcode : " + str1.hashCode() 
		+ "\t, " + str2.hashCode()+ "\t, " + str3.hashCode());
		
		str3 = "happy";
		System.out.println("hashcode : " + str1.hashCode() 
		+ "\t, " + str2.hashCode()+ "\t, " + str3.hashCode());
//		str1 = korea, str2 = happy
//		hashcode : 102236330, 99047136
//		str1 = happy, str2 = happy
//		hashcode : 99047136	, 99047136
		
		
	}
}
