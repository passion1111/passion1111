package array3;

public class Mainentry {
	public static void main(String[] args) {
		 int[] a=new int[30];
		 int[][] a2=new int[2][3];   	//�ʱ�ȭ �������������� ��� ���� ũ�� �����Ұ�
		 int[][] a3=new int [][]  {{1,2,3},{3,2,1}}; //�ʱ�ȭ ���1
		 int[][] a4= {{1,2,3},{4,5,6}};//�ʱ�ȭ���2
//		 int[][] a5= {1,2,3,4,5,6}//���� �߻�
//		 int[][] a6= new int[2][]{{1,2,3},{4,5,6}}//���� �߻�
		 int[][] a7= {{0},{0}}; //�ʱ�ȭ
		 
		 int[][][] a8= new int[2][3][2];//�� �� �� ũ�� for�� 3�� �ʿ�
		 
//		 int[][] a9=new int[2][3]; //�� �� for2���ʿ�
		 int[][]a9= {{100,200,300},{400,500,600}};
		 
		 System.out.println("a9[0][1] = " + a9[0][1]);
			System.out.println("1������ �迭 ��ü ���� : " + a.length);
			System.out.println("2�����迭�� a9[0] ��� ���� : " + a9[0]);
			System.out.println("2�����迭�� a9[1] ��� ���� : " + a9[1]);
			
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
	