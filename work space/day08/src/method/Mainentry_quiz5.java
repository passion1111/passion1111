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
	

	public static  int[][] input(int totalnumber) { //�̸�,����,����,��������
		Scanner sc=new Scanner(System.in);
		int[][] arr=new int[totalnumber][3];	//������ �����ϴ°�
	   
		
	    try{   //�Ǽ� �� �ٸ� ���� �����Ͱ� �����°��� ����
	        for(int k=0;k<totalnumber;k++) {
	      
	      	  do {  //100~0������ ������ ����
	      	  System.out.println((k+1)+"���� ����� ������� �Է����ּ���:");
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

	public static int[]rank(int totalnumber, int[] ranktotalnumber,int[]rank){
		 for(int k=0;k<totalnumber;k++) {
		rank[k]=1;
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

	
	
	public static    int[] total(int[]sum,int[][]arr,int totalnumber) { //���� ���ϴ� �Լ�

	
		 for(int k=0;k<totalnumber;k++) {
//	    	  sum[k][0]=arr[k][0]+arr[k][1]+arr[k][2];
			 sum[k]=arr[k][0]+arr[k][1]+arr[k][2];
//	    	  sum_compare[k][0]=arr[k][0]+arr[k][1]+arr[k][2];  	    	  
		 }
		 
		return sum;
}
	
	public static  double[] average(int totalnumber,int[] sum1) {//��� ���ϴ� �Լ�

		double[] ave=new double[totalnumber];

		for(int k=0;k<totalnumber;k++) {
		    	
	    	  ave[k]=sum1[k]/3.;
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

	

	public static  int[] dd2(int[] sum1,int[] sum_compare) {  //�������ϴ� �Լ�

		
		int temp;
		  for(int i =0; i< sum1.length; i++) {
				for(int j= i+1; j < sum1.length; j++) {					
					if((sum1[i]) < sum1[j]) {  //��ȯ
						temp = sum_compare[i];
						sum_compare[i] = sum_compare[j];
						sum_compare[j] = temp;												
					} // if end
					
				} // j end
			} // i end
		  
		  for(int j=0; j<sum1.length ; j++) {
		       for(int k=0;k<sum1.length;k++){	
		    		if( sum1[j]<sum_compare[k]) {	    			
		    			
/*			    		���� ������δ� ������� ������ ǥ���ϱ� ���� ��ħ.	
						rank_name[j][0]=k+1; �������.


*/
		   }    //rank end			  
	  }	    //k end
}//j end 
		return sum_compare;
		
	
	}

	public static  void output(int totalnumber,String[] name,int[] sum1,int[] rank,int[][]arr,String[][]grade_ave,double[] ave) {//��� ����ϴ� �Լ�
		  
		
		for(int k=0;k<arr.length;k++) {//�ټ��� �Է����� for
				
			 
			System.out.println("****"+name[k]+"���� ����ǥ�Դϴ�.****");
				System.out.println("�̸�:" + name[k]);
				System.out.println("���� :" + arr[k][0] + "\t���� : " + arr[k][1] + "\t���� : " + arr[k][2]);
				System.out.println("*****"+name[k]+"���� ������ ������***** ");
				System.out.println("���� :" + grade_ave[k][0] + "\t���� : " +grade_ave[k][1] + "\t���� : " + grade_ave[k][2]);
				System.out.printf("���� :%d \t�������:%.2f \n������� :%s ",  sum1[k],ave[k],grade_ave[k][3]);
				System.out.println(" ���� :"+rank[k]+"��");	  
		  }
		}//for end
		
	
	
public static void main(String[] args) {
		int totalnumber=0;
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("�Է��ؾ��ϴ� ����� �˷��ּ���");
		totalnumber=sc.nextInt();
//		int[][] arr=new int[totalnumber][3];	//������ �����ϴ°�
   
	   
		
		//�̸��� ���� ����
		//input(totalnumber);
		
		
		int[][] arr=input(totalnumber);//���ϰ� deep array����
	
		int[] rank=new int[totalnumber];       // ���������ϴ°�
		
		System.out.println(arr[0][0]);
		
		//name(totalnumber);
		
		String[]name=name(totalnumber);////���� �Է��ϰԵǸ� ���� �޼ҵ带 �̷��� �������ѹ��� �̸�,�������� �����ϱⰡ �����.
		
		//total(arr,totalnumber);  //����
		int[] sum=new int[totalnumber];
		
		int[] sum1=total(sum,arr,totalnumber);//������ sum�� ����.
		int[]sum_compare=sum1.clone();
		average(totalnumber,sum1);
		double ave[]=average(totalnumber,sum1);
		
		
		
		grade(ave,totalnumber,arr,sum);
		String[][]grade_ave=grade(ave,totalnumber,arr,sum).clone();
		
		dd2(sum1,sum_compare);
		int[]sum_compare1=dd2(sum1,sum_compare).clone();
		
		System.out.println(sum_compare1[0]);
		
		 rank=rank(totalnumber,rank, sum_compare1);
		
		output(totalnumber,name,sum1,rank,arr,grade_ave,ave); //������ġ���.

//int totalnumber,String[] name,int[][] sum,int[][] rank,int[][]arr,String[][]grade_ave
	
}//


	
}

	