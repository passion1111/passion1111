package ex01.operator;

public class 조규민 {

	public static void main(String[] args) {
		int pay = 567890;
		
		int man = pay / 10000;
		int mna = pay % 10000;
		int cheon = mna / 1000;
		int cna = mna % 1000;
		int baek = cna / 100;
		int bna = cna % 100;
		int sip = bna / 10;
				
		System.out.println("만원: " + man + "장");
		System.out.println("천원: " + cheon + "장");
		System.out.println("백원: " + baek + "개");
		System.out.println("십원: " + sip + "개");
		
	} // main end 
} // class end
