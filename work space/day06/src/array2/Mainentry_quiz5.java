package array2;

// �̸�, ����3���Է¹ް� ,���� ��� ���� ���ϱ�.
// ����ǥ 3�� �Ѹ���.   �̿ϼ� quiz7_com������ ����.
import java.util.Scanner;

public class Mainentry_quiz5 {
	public static void main(String[] args) {
		int a5=0;
		int a6=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�Է��ؾ��ϴ� ������ �˷��ּ���");
		a5=sc.nextInt();
		
		
		int[][] arr=new int[a5][3];
	String[] arr2=new String[a5]; 
    String[] name=new String[a5];
		
		
		// System.out.println(name);
      for(int k=0;k<arr.length;k++) {
    	  System.out.println("�̸��� �Է��ϼ���: ");
    	  name[k] = sc.next();
    	  System.out.println((k+1)+"���� ����� ������� �Է����ּ���:");
    	  arr[k][0]=sc.nextInt();
    	  
    	  System.out.println("���� ������ �Է��ϼ���: ");
    	  arr[k][1]=sc.nextInt();
    	  System.out.println("���� ������ �Է��ϼ���: ");
    	  arr[k][2]=sc.nextInt();
    	 
      }
      
      int[][] sum =new int[a5][1];
      double[][] ave =new double[a5][1];
      for(int k=0;k<arr.length;k++) {
    	  sum[k][0]=arr[k][0]+arr[k][1]+arr[k][2];
    	  ave[k][0]=sum[k][0]/3.;
      }

	String[] grade=new String[a5];  
	for(int k=0;k<arr.length;k++) {
		 if(arr[k][1]>=90) grade[k]="A";
		 else if((arr[k][1]>=80)&&(arr[k][1]<89)) grade[k]="B";
		 else if((arr[k][1]>=70)&&(arr[k][1]<79)) grade[k]="C";
		 else if((arr[k][1]>=60)&&(arr[k][1]<69)) grade[k]="D";
		
		 else if(60>arr[k][1]) grade[k]="F";
		 
		
	}
	String[] grade2=new String[a5]; 
	for(int k=0;k<arr.length;k++) {
		 if(arr[k][2]>=90) grade2[k]="A";
		 else if((arr[k][2]>=80)&&(arr[k][2]<89)) grade2[k]="B";
		 else if((arr[k][2]>=70)&&(arr[k][2]<79)) grade2[k]="C";
		 else if((arr[k][2]>=60)&&(arr[k][2]<69)) grade2[k]="D";
		
		 else if(60>arr[k][2]) grade2[k]="F";
		 
		
	}
	String[] grade3=new String[a5]; 
	for(int k=0;k<arr.length;k++) {
		 if(arr[k][0]>=90) grade[k]="A";
		 else if((arr[k][0]>=80)&&(arr[k][0]<89)) grade3[k]="B";
		 else if((arr[k][0]>=70)&&(arr[k][0]<79)) grade3[k]="C";
		 else if((arr[k][0]>=60)&&(arr[k][0]<69)) grade3[k]="D";	
		 else if(60>arr[k][1]) grade3[k]="F";
		 	
	}
		String[] grade4=new String[a5]; 
		for(int k=0;k<arr.length;k++) {
			 if(ave[k][0]>=90) grade4[k]="A";
			 else if((ave[k][0]>=80)&&(ave[k][0]<89)) grade4[k]="B";
			 else if((ave[k][0]>=70)&&(ave[k][0]<79)) grade4[k]="C";
			 else if((ave[k][0]>=60)&&(ave[k][0]<69)) grade4[k]="D";
			 else if(60>ave[k][0]) grade4[k]="F";
			
			
		}
		System.out.println(ave[0][0]);
		System.out.println(grade4[0]);
	  for(int k=0;k<arr.length;k++) {
		
		  System.out.println("****"+name[k]+"���� ����ǥ�Դϴ�.****");
			System.out.println("�̸�:" + name[k]);
			System.out.println("���� :" + arr[k][0] + "\t����: " + arr[k][1] + "\t����: " + arr[k][2]);
			System.out.println(name[k]+"���� ������ ");
			System.out.println("���� :" + grade3[k] + "\t����: " +grade[k] + "\t����: " + grade2[k]);
			System.out.printf("����: " +sum[k][0] + "\t���: %.2f ", ave[k][0] ,"\t ������� : %s",grade4[k] );
			System.out.println("�������:"+ave[k][0]);
		  
	  }
	  
//		

	}
}