package personal;
//for문을 이용한 별찍기 프로그래밍
public class Personal_Star {
	private static int space;
	private static int i;

	public static void main(String[] args) {
		
		for(space=1; space<5; space++)
		{
			for(i=0;i<4-space;i++) {
				System.out.print(" ");
			}
			for(i=0;i<2*space-1;i++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	
	
		for(int space2 = 1; space2<4; space2++) {
			
		    for(int i=0;i<space2; i++) {
		    	System.out.print(" ");
		    }
		    for(int j=0;j<7-2*space2;j++) {
		    	System.out.print("*");
		    	
		    }
		    System.out.print("\n");
		}
	}
}
