package array2;

public class Mainentry {
	public static void main(String[] arugs) {
//		int[][] a=new int[2][3];//��ũ�� ,��ũ�� 2,3�̴ϱ� [0~1][0~2]
		
//	1.
//		a[0][0]=1;//�ʱ�ȭ
//		a[0][1]=2;
//		a[0][2]=3;
//		
//		a[1][0]=4;
//		a[1][1]=5;
//		a[1][2]=6;
//		2.
//		int[][] a2=new int[][] {{1,2,3},{4,5,6}};   //{       �� �� ���̿� , �׸��� �߰�ȣ         }
//		//3.
		int[][] a3={{1,2,3},{4,5,6}};//�ʱ�ȭ�Ǹ� [][]����ֵ���.
		
		//�迭 �� ��� ,2���迭�� ���� for������ �迭�Ұ���
//	System.out.println("a[0][1] ="+a2[0][1]);
//	
//	for(int i=0;i<2;i++) {//��
//		 for(int j=0;j<3;j++) {
//			 System.out.print(a3[i][j]+"\t");
//		 }// j end
//		 System.out.println("");
//	}//i end
	
	System.out.println("\n==============");
	
	System.out.println("�迭�� ��ũ��:"+a3.length);
	System.out.println("�迭�� ��ũ��"+a3[0].length);
//	System.out.println("�迭�� ��ü ����"+a.length);
	for(int i=0;i<a3.length;i++) {//��
		 for(int j=0;j<a3[i].length;j++) {
			 System.out.print(a3[i][j]+"\t");
		 }// j end
		 System.out.println("");
	}//i end
		
	}
}