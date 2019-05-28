package ex01.operator;


public class Q1 {

public static void main (String[] args){
	
	int pay = 567890;
	
	System.out.println("전재산=567890원");
	System.out.println("만원:"+567890/10000+"장");
	
	System.out.println("천원:"+567890%10000/1000+"장");
	System.out.println("백원:"+567890%10000%1000/100+"개");
	System.out.println("십원:"+567890%10000%1000%100/10+"개");
	

} //main end
} //class end
 