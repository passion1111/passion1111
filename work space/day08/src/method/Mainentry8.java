package method;

public class Mainentry8 {
	
	public static void loopLine() {
		for(int i =1; i < 7 ; i++) {
			System.out.println("dddddddd");
		}
	}
	
	public static void loopLine(int n) {
		for(int i =1; i <= n ; i++) {
			System.out.println("bbbbbb");
		}
	}
	
	public static void loopLine(int n1,int n2) {
		
		if( n2<n1) {
		for(int i = n2; i < n1 ; i++) {
			System.out.println("wwwww");
		}
		}
		else if(n1<n2) {
			for(int i=n1;i<n2;i++) {
				System.out.println("wwwww");
			
		}
		}
		else System.out.println("wqfokwqfok");
	}
	
	public static void main(String[] args) {
		
		loopLine(5, 3);
		loopLine();
	}
}






