package ex03.input;
import java.util.*; 

public class InputTest2 {
			public static void main(String[] args) {     
				Scanner scan= new Scanner(System.in); //java.util����¹���� ctr+shift +������o�ڵ�����Ʈ
			    //next() vs nextLine()
			System.out.print("String input : ");	
			  String s1 = scan.next();
			  System.out.println(s1);  //�����νĸ���
			  
			  /*
			  String s2= scan.nextLine();
			  System.out.println("String input2 : ");
			  System.out.println(s2);  //�����νİ���
			  		System.out.println("===============");
			  */
			  	int num=scan.nextInt();
			  	double num2=scan.nextDouble();
			  	
			  	System.out.println(num+", "+num2);
			  
			
			}
	                      

}