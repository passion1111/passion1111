package day09_argument;

public class Argumentvariable3 {
	public static String plus(String...x) {///가변길이 배열
		String aa=" ";
		for(int i=0; i<x.length;i++) {
			aa+=x[i];
			System.out.println(aa);
		}
		
		return aa;
	}
		
		
	
	  public static void main(String[] args) {
		
		plus("1","3","4");
		
		}
//		plus(1,2,3,4,5,6,7,8,9,10);// 메소드로 만들면 아래를보면 변수가 너무~~길음
//		plus("a","b","c"); //아래 메소드보면 고통스럽
		
	}


//package ex06.argumentVariable;
//
//public class MainEntry {
//	
//	public static void plus(int...x) { // 가변길이 배열
//		int sum = 0;
//		for(int i = 0; i < x.length; i++) {
//			sum += x[i];
////			System.out.print(x[i] + " ");
//		}
//		System.out.println("sum = " + sum);
//	}
//	
//	
//	public static void plus(String...x) { // 가변길이 배열
//		
//		String sum = "";
//		for(int i = 0; i < x.length; i++) {
//			sum += x[i] + " ";
//		}
//		System.out.println("sum = " + sum);
//	}
//	public static void main(String[] args) {
//		plus(1,2,3,4,5,6,7,8,9,10);
//		plus(1);
//		plus(1,2,3);
//		
//		plus("a", "b", "c");
//		plus("one", "two", "thrid", "korea", "love");
//		
//	}
//
//	
//}

