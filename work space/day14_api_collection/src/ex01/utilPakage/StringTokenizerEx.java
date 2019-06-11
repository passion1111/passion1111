
package ex01.utilPakage;

import java.util.StringTokenizer;

//사용자 
public class StringTokenizerEx {
		public static void main(String[] args) {
			StringTokenizer token=new StringTokenizer("사과=10|초코렛=3|샴페인=1","=|",true); // 
			
			while(token.hasMoreTokens()) {//hash방식으로 찍어내는동안 다음요소가 있느냐
//				System.out.println(token.nextToken());//다음토큰 찍어주는것.
				
				String str=token.nextToken();
				if(str.equals("="))System.out.println("\t");
				else if(str.equals("|"))System.out.println("\n");
				else System.out.println(str);
			}
		}
}









/*
package ex01.utilPakage;

import java.util.StringTokenizer;

//사용자 
public class StringTokenizerEx {
		public static void main(String[] args) {
			StringTokenizer token=new StringTokenizer("대통령1/대통령2/대통령3/대통령4","/"); // , " " 으로 구분자 지정해줘야함
//			StringTokenizer token=new StringTokenizer("대통령1 대통령2 대통령3 대통령4");
			
			while(token.hasMoreTokens()) {//hash방식으로 찍어내는동안
				System.out.println(token.nextToken());//다음토큰 찍어주는것.
			}
		}
}
*/