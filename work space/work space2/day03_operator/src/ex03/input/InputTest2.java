package ex03.input;
import java.util.*; 

public class InputTest2 {
			public static void main(String[] args) {     
				Scanner scan= new Scanner(System.in); //java.util만드는방법은 ctr+shift +영문자o자동임포트
			    //next() vs nextLine()
			System.out.print("String input : ");	
			  String s1 = scan.next();
			  System.out.println(s1);  //공백인식못함
			  
			  /*
			  String s2= scan.nextLine();
			  System.out.println("String input2 : ");
			  System.out.println(s2);  //공백인식가능
			  		System.out.println("===============");
			  */
			  	int num=scan.nextInt();
			  	double num2=scan.nextDouble();
			  	
			  	System.out.println(num+", "+num2);
			  
			
			}
	                      

}
