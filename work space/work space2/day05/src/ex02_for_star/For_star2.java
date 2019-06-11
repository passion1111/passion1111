package ex02_for_star;
//별 줄넘어갈떄마다 하나씩 증가 시키기.
public class For_star2 {
	public static void main(String[] args) {
		int i,j;
		
		
		for(i=1;i<=5;i++) {
			for(j=0;j<i;j++) {
				System.out.print("*");
			}System.out.println("");
		
		}
		
	}

}

