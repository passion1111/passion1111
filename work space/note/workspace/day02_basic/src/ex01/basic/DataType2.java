package ex01.basic;

public class DataType2 {

	public static void main(String[] args) {
		String str="A";  //문자열, " ", 2byte
		char ch = 'A'; 	 //문자, ' ', 1byte
		char ch2 = 67;   
		char ch3 = 'b';   // ASCII 98
		int su = 20; String aa = "happy";  double d = 12.34;
		
		System.out.println(ch);  // A
		System.out.println(str); // A
		System.out.println((int)ch );  // ASCII 65
		System.out.println(ch2 + ch3); // ?
		System.out.println("aa = " + aa);
		System.out.println("실수형 데이터 : " + d);
		System.out.println("-----------------");
		
		for(int i= 65; i <= 90; i++ ) {
			System.out.print( (char)i + " ");  // \t : tab key
		} // end for
		System.out.println("\n\n------------------------");
		
		for(int i= 'a'; i <= 'z'; i++ ) {
			System.out.print( (char)i + " ");  // \t : tab key
		} // end for
		
		System.out.println("\n\n\nboolean type");
		boolean flag = true;
		//int b = flag;
		System.out.println(flag);
	}
}








