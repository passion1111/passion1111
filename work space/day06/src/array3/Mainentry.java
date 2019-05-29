package array3;

public class Mainentry {
	public static void main(String[] args) {
		 int[] a=new int[30];
		 int[][] a2=new int[2][3];   	//초기화 돼있지않은것은 행과 열의 크기 생략불가
		 int[][] a3=new int [][]  {{1,2,3},{3,2,1}}; //초기화 방법1
		 int[][] a4= {{1,2,3},{4,5,6}};//초기화방법2
//		 int[][] a5= {1,2,3,4,5,6}//에러 발생
//		 int[][] a6= new int[2][]{{1,2,3},{4,5,6}}//에러 발생
		 int[][] a7= {{0},{0}}; //초기화
		 
		 int[][][] a8= new int[2][3][2];//면 행 열 크기 for문 3개 필요
		 
//		 int[][] a9=new int[2][3]; //행 열 for2개필요
		 int[][]a9= {{100,200,300},{400,500,600}};
		 
		 System.out.println("a9[0][1] = " + a9[0][1]);
			System.out.println("1차원의 배열 전체 길이 : " + a.length);
			System.out.println("2차원배열의 a9[0] 요소 길이 : " + a9[0]);
			System.out.println("2차원배열의 a9[1] 요소 길이 : " + a9[1]);
			
			System.out.println("-------------------");
			for (int i = 0; i < a9.length; i++) {  // rows
				
				for (int j = 0; j < a9[i].length; j++) { // cols
					//System.out.println(a9[i][j]);
					System.out.println("a9["+i+"]["+j+"]= "+ a9[i][j]);
				} // j end
				
			} // i end
			System.out.println("=========================");
			for (int i = 0; i < 2; i++) {  // rows
				
				for (int j = 0; j < 3; j++) { // cols
					//System.out.println(a9[i][j]);
					System.out.println("a9["+i+"]["+j+"]= "+ a9[i][j]);
				} // j end
				
			} // i end
			
		
		}
	}
	