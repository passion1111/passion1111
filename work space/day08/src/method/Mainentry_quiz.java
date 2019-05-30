package method;
//quiz2 abs(int x) {절대값 출력} 함수
public class Mainentry_quiz{
	public static void abs(int a,int b) {
		int a1=a;
		int b1=b;
		if(a<0) a1=-a; 
		if(b<0)b1=-b;
		System.out.println("a="+a1);
		System.out.println("b="+b1);
		
	}
	
	
	
	public static void main(String[] args) {
		abs(3,-5);
		
	}
}
