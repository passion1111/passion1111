package array2;

public class Mainentry {
	public static void main(String[] arugs) {
//		int[][] a=new int[2][3];//행크기 ,열크기 2,3이니까 [0~1][0~2]
		
//	1.
//		a[0][0]=1;//초기화
//		a[0][1]=2;
//		a[0][2]=3;
//		
//		a[1][0]=4;
//		a[1][1]=5;
//		a[1][2]=6;
//		2.
//		int[][] a2=new int[][] {{1,2,3},{4,5,6}};   //{       행 열 사이에 , 그리고 중괄호         }
//		//3.
		int[][] a3={{1,2,3},{4,5,6}};//초기화되면 [][]비워둬도됨.
		
		//배열 값 출력 ,2차배열은 단일 for문으로 배열불가능
//	System.out.println("a[0][1] ="+a2[0][1]);
//	
//	for(int i=0;i<2;i++) {//행
//		 for(int j=0;j<3;j++) {
//			 System.out.print(a3[i][j]+"\t");
//		 }// j end
//		 System.out.println("");
//	}//i end
	
	System.out.println("\n==============");
	
	System.out.println("배열의 행크기:"+a3.length);
	System.out.println("배열의 열크기"+a3[0].length);
//	System.out.println("배열의 전체 길이"+a.length);
	for(int i=0;i<a3.length;i++) {//행
		 for(int j=0;j<a3[i].length;j++) {
			 System.out.print(a3[i][j]+"\t");
		 }// j end
		 System.out.println("");
	}//i end
		
	}
}
