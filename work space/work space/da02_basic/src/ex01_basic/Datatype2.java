package ex01_basic;

public class Datatype2 {
	
	public static void main(String[] args)  {
		      String str="A";  //문자열, " " ,2byte
		      char ch='A';    //문자, ' ' ,1byte
		      char ch2=67;    //ASCII C
		      char ch3='b';   //ASCII 98
		      int  su=20; String aa="happy"; double d=12.34;
		      	System.out.println(ch);  //A
		      	System.out.println(str); //sysout누르고 ctr+스페이스바누르면됨.
		      								  //A byte차이
		      	System.out.println(su);
		      	
		      	System.out.println((int)ch); //ASCII65
		      	System.out.println(ch2+ch3); //아스키숫자로변해서 더해짐
		      	System.out.println("aa=" +aa);//문자와 변수더해져서나옴
		      	System.out.println("실수형데이터:" +d); //12.34
		      	System.out.println("----------");
		      	for(int i=65; i<=90; i++) {
		      		System.out.println(i);
		      	}
	//end for  \t 탭키
 				for(int i=65; i<=90; i++) {
 						System.out.print((char)i+ "\t");
  	}  //아스키로 변해서 숫자출력
 				
 				for(int i=65; i<='z'; i++)  {
						System.out.print((char)i+ "\t");
}
 				System.out.println("\n");
 				System.out.println("\n\n\n boolean type");
 				boolean flag=true;
 				//int b=flag 그리고 boolean은 숫자로 형변환안됨;
 				System.out.println(flag);
}
}

