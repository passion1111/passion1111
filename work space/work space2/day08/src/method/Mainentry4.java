package method;
//매개변수 o 리턴타입 o
public class Mainentry4 {
	
	public static String name(int x,String irum) {
		System.out.println("x="+x);
		return irum;
	
		
	}
		
	
	public static void main(String[] args) {//진입점이라서 무조건 있어야 한다.
		System.out.println("main start~~");
		
		String str=name(10,"irurururum");
		System.out.println("name() call= "+name(9999,"girl girl"));
		
		System.out.println(str);
		
		
		System.out.println("main end");
	}

}
