package array3;

import java.util.Random;

public class Mainentry2 {
	public static void main(String[] args) {
	  int[][][] arr=new int[2][2][3];
	  int x=0;
	  
	  System.out.println("�� = "+arr.length);  //���� ū ���� ��
	  System.out.println("�� = "+arr[0].length);//�ι��� ������� ��
	  System.out.println("�� = "+arr[0][0].length);//������ ������� ��
	  //input
	  for(int i=0;i<arr.length;i++) {//��	  
		  	for(int j=0;j<arr[i].length;j++) {//��
		  			for(int k=0;k<arr[i][j].length;k++) {//��
//		  				arr[i][j][k]=++x;
//		  				arr[i][j][k]=x +=10;
//		  				arr[i][j][k]=(int)(Math.random()*100);  //0���� n-1������ �������� �Էµ� �����Է�
		  				arr[i][j][k]=new Random().nextInt(45)+1; //1����45���� �����߿��� ����
		  			}//��
		  	}//��
	  }//��
	  //output
	  for(int i=0;i<arr.length;i++) {//��	  
		  	for(int j=0;j<arr[i].length;j++) {//��
		  			for(int k=0;k<arr[i][j].length;k++) {//��
		  					System.out.print(arr[i][j][k]+"\t");
		  				
		  			}//��
		  			System.out.println("");
		  	}//��
		  	System.out.println("");
	  }//��
	
		
		}
	}
	