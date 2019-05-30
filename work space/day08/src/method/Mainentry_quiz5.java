package method;

import java.util.InputMismatchException;
import java.util.Scanner;



//����ó�� �Լ��� ����(�и�)�Ұ�
//�Է��Լ�input()-�̸�,����,����,���� ����
//���� �Լ� total(~~~)-���� ���ϴ� �Լ�
//��� �Լ� average(~~~)-��ձ��ϴ� �Լ�
//��� �Լ� output �Լ� - ��� ���
//���� ���ϴ� �Լ� grade()

//�˾ƵѰ� �ϳ��� �޼ҵ忡�� ���Ϲ޴� ���� �ϳ����̴�.
//�׷��Ƿ� �������� �ѹ��� ���� �̸� ���� ����
//
public class Mainentry_quiz5 {
	

	public static  int[][] input(int totalnumber,String[] name) { //�̸�,����,����,��������
		Scanner sc=new Scanner(System.in);
		int[][] arr=new int[totalnumber][3];	//������ �����ϴ°�
	   
		
	    try{   //�Ǽ� �� �ٸ� ���� �����Ͱ� �����°��� ����
	        for(int k=0;k<totalnumber;k++) {
	      
	      	  do {  //100~0������ ������ ����
	      	  System.out.println((name[k])+"���� ������� �Է����ּ���:");
	      	  arr[k][0]=sc.nextInt();
	      	  }while(arr[k][0]<0 ||arr[k][0]>100);
	      	  
	      	  do {
	      	  System.out.println("���� ������ �Է��ϼ���: ");
	      	  arr[k][1]=sc.nextInt();
	      	  }while(arr[k][1]<0 ||arr[k][1]>100);
	      	  
	      	  do {
	      	  System.out.println("���� ������ �Է��ϼ���: ");
	      	  arr[k][2]=sc.nextInt();
	      	  }while(arr[k][2]<0 ||arr[k][2]>100);
	      	 
	        }//for end
	        }//try end
	        
	    	catch(InputMismatchException e) {//������ �Է��� int���� �ƴҶ� ���.
				System.out.println("������ �Է����ּ���.");	  
}
	return arr;
	}

public static int[] rank(int[]sum,int[]sum_compare,int totalnumber) {
	int[]rank=new int[totalnumber];
	for(int i=0;i<totalnumber;i++) {rank[i]=1;}
	
  for(int i=0;i<totalnumber;i++) {
	  System.out.println(rank[i]);
	  for(int j=0;j<totalnumber;j++) {
		  
		  if((sum[i])<(sum_compare[j])) {
			 rank[i]=rank[i]+1;
		
		  }
			  
	  }
  }
	
	return rank;
	
}
	
	public static  String[] name(int totalnumber){ //�̸�����
		String[] name=new String[totalnumber];
		Scanner sc=new Scanner(System.in);
		 for(int k=0;k<totalnumber;k++) {
	      	  System.out.println("�̸��� �Է��ϼ���: ");
	      	  name[k] = sc.next();
		 }
		 
		return name;
		
	}

	
	
	public static    int[] total(int[][]arr,int totalnumber) { //���� ���ϴ� �Լ�
		int[] sum=new int[totalnumber];  //��������

	
		 for(int k=0;k<sum.length;k++) {
	    	  
			 sum[k]=arr[k][0]+arr[k][1]+arr[k][2];
			 
	    	  
		 }
		 
		return sum;
}
	
	public static  double[] average(int totalnumber,int[] sum) {//��� ���ϴ� �Լ�

		double[] ave=new double[totalnumber];

		for(int k=0;k<totalnumber;k++) {
		    	
	    	  ave[k]=sum[k]/3.;
		 }
		return ave;
	}

	public static  String[][] grade(double[]ave,int totalnumber,int[][]arr,int[] sum) { //���� ���ϴ� �Լ�
		String[][]grade_ave=new String[totalnumber][4];
		for(int k=0;k<arr.length;k++) {
		
  	  ave[k]=sum[k]/3.;
  	  
  	  //arraycopy�������� �ϳ��� ���� ����Ǹ� ���������� ����Ʊ⶧���� �׳� �����Է�
  	 
    //�迭 �ѱ� grade_ave[k][0] ���� grade_ave[k][1],grade_ave[k][2]
    
    //�ѱ�

		 if(arr[k][0]>=90) grade_ave[k][0]="A";
		 else if((arr[k][0]>=80)&&(arr[k][0]<89)) grade_ave[k][0]="B";
		 else if((arr[k][0]>=70)&&(arr[k][0]<79)) grade_ave[k][0]="C";
		 else if((arr[k][0]>=60)&&(arr[k][0]<69)) grade_ave[k][0]="D";	
		 else if((60>arr[k][0])) grade_ave[k][0]="F";		 	
	
		 //����
		 if(arr[k][1]>=90) grade_ave[k][1]="A";
		 else if((arr[k][1]>=80)&&(arr[k][1]<89)) grade_ave[k][1]="B";
		 else if((arr[k][1]>=70)&&(arr[k][1]<79)) grade_ave[k][1]="C";
		 else if((arr[k][1]>=60)&&(arr[k][1]<69)) grade_ave[k][1]="D";		
		 else if(60>arr[k][1]) grade_ave[k][1]="F";	 	
	
		 //����
		 if(arr[k][2]>=90) grade_ave[k][2]="A";
		 else if((arr[k][2]>=80)&&(arr[k][2]<89)) grade_ave[k][2]="B";
		 else if((arr[k][2]>=70)&&(arr[k][2]<79)) grade_ave[k][2]="C";
		 else if((arr[k][2]>=60)&&(arr[k][2]<69)) grade_ave[k][2]="D";		
		 else if(60>arr[k][2]) grade_ave[k][2]="F";		 	
	//���
			 if(ave[k]>=90) grade_ave[k][3]="A";
			 else if((ave[k]>=80)&&(ave[k]<89)) grade_ave[k][3]="B";
			 else if((ave[k]>=70)&&(ave[k]<79)) grade_ave[k][3]="C";
			 else if((ave[k]>=60)&&(ave[k]<69)) grade_ave[k][3]="D";
			 else if(60>ave[k]) grade_ave[k][3]="F";		
    }
	return grade_ave;
		
	}

	

	public static  int[] dd2(int[] sum,int[] sum_compare,String[]rank) {  //�������ϴ� �Լ�

		
		int temp;
		  for(int i =0; i< sum.length; i++) {
				for(int j= i+1; j < sum.length; j++) {					
					if((sum[i]) < sum[j]) {  //��ȯ
						temp = sum_compare[i];
						sum_compare[i] = sum_compare[j];
						sum_compare[j] = temp;												
					} // if end
					
				} // j end
			} // i end
		 
		return sum_compare;
		
	
	}

	
	
	
public static void main(String[] args) {
		int totalnumber=0;
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("�Է��ؾ��ϴ� ����� �˷��ּ���");
		totalnumber=sc.nextInt();
//		int[][] arr=new int[totalnumber][3];	//������ �����ϴ°�
   
	   
		
		//�̸��� ���� ����
		//input(totalnumber);
		
		String[]name1=name(totalnumber);////���� �Է��ϰԵǸ� ���� �޼ҵ带 �̷��� �������ѹ��� �̸�,�������� �����ϱⰡ �����.
																//�迭 ������ �����ϸ� �޼ҵ������� �ʴ°� �����Ͱ���.
		int[][] arr=input(totalnumber,name1);//���ϰ� deep array����

		int[] sum=total(arr,totalnumber);//������ sum�� ����.
		int[]sum_compare=total(arr,totalnumber); //sum�� ���� �迭 ����
		double ave[]=average(totalnumber,sum);//��հ�����			
		String[][]grade_ave=grade(ave,totalnumber,arr,sum);//������ ������ ������	
		int[]sum_compare1=dd2(sum,sum_compare,name1);//������� ����	
	int[]	rank=rank(sum_compare1,sum,totalnumber);//int�� �迭�� ���� �������.
		output(totalnumber,name1,sum,arr,grade_ave,ave,rank); //�ƿ�ǲ

}//



public static  void output(int totalnumber,String[] name1,int[] sum,int[][] arr,String[][] grade_ave,double[] ave,int[] rank) {//��� ����ϴ� �Լ�
	  
	
	for(int k=0;k<grade_ave.length;k++) {//�ټ��� �Է����� for
			
		 
			System.out.println("****"+name1[k]+"���� ����ǥ�Դϴ�.****");
			System.out.println("�̸�:" + name1[k]);
			System.out.println("���� :" + arr[k][0] + "\t���� : " + arr[k][1] + "\t���� : " + arr[k][2]);
			
			System.out.println("*****"+name1[k]+"���� ������ ������***** ");
			System.out.println("���� :" + grade_ave[k][0] + "\t���� : " +grade_ave[k][1] + "\t���� : " + grade_ave[k][2]);
			System.out.printf("���� :%d \t�������:%.2f \n������� :%s ",  sum[k],ave[k],grade_ave[k][3]);
			System.out.println(" ���� :"+rank[k]+"��");	  
	  }
	}//for end
	
	
}

	