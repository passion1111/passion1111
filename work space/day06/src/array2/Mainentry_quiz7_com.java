package array2;

import java.util.InputMismatchException;
// �̸�, ����x���Է¹ް� ,���� ��� ���� ���ϱ�.
// ����ǥ x�� �Ѹ���.
import java.util.Scanner;
//
public class Mainentry_quiz7_com {
	public static void main(String[] args) {
		int totalnumber=0;
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("�Է��ؾ��ϴ� ����� �˷��ּ���");
		totalnumber=sc.nextInt();
		
		//�̸��� ���� ����
	int[][] arr=new int[totalnumber][3];	//������ �����ϴ°�
    String[] name=new String[totalnumber];  //�̸� �����ϴ°�
    int[][] rank=new int[totalnumber][1];       // ���������ϴ°�
    int[][] sum =new int[totalnumber][1];  //�� ���� ����
    int[][] sum_compare=new int[totalnumber][1];   //���� ���ϱ����� �迭
    double[][] ave =new double[totalnumber][1];  //������ ���
   
    //������ ��ü�������
    String[] han=new String[totalnumber]; 
    String[] eng=new String[totalnumber]; 
    String[] com=new String[totalnumber]; 
    String[] total_ave=new String[totalnumber]; 
		
		
	try{   //�Ǽ� �� �ٸ� ���� �����Ͱ� �����°��� ����
      for(int k=0;k<arr.length;k++) {
    	  System.out.println("�̸��� �Է��ϼ���: ");
    	  name[k] = sc.next();
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
    	  rank[k][0]=1;
      }
	
	
    
     
      for(int k=0;k<arr.length;k++) {
    	  sum[k][0]=arr[k][0]+arr[k][1]+arr[k][2];
    	  ave[k][0]=sum[k][0]/3.;
    	  sum_compare[k][0]=arr[k][0]+arr[k][1]+arr[k][2];  
    	  //arraycopy�������� �ϳ��� ���� ����Ǹ� ���������� ����Ʊ⶧���� �׳� �����Է�
    	 
      
      
      //�ѱ�

  		 if(arr[k][0]>=90) han[k]="A";
  		 else if((arr[k][0]>=80)&&(arr[k][0]<89)) han[k]="B";
  		 else if((arr[k][0]>=70)&&(arr[k][0]<79)) han[k]="C";
  		 else if((arr[k][0]>=60)&&(arr[k][0]<69)) han[k]="D";	
  		 else if(60>arr[k][1]) han[k]="F";		 	
  	
  		 //����
		 if(arr[k][1]>=90) eng[k]="A";
		 else if((arr[k][1]>=80)&&(arr[k][1]<89)) eng[k]="B";
		 else if((arr[k][1]>=70)&&(arr[k][1]<79)) eng[k]="C";
		 else if((arr[k][1]>=60)&&(arr[k][1]<69)) eng[k]="D";		
		 else if(60>arr[k][1]) eng[k]="F";	 	
	
		 //����
		 if(arr[k][2]>=90) com[k]="A";
		 else if((arr[k][2]>=80)&&(arr[k][2]<89)) com[k]="B";
		 else if((arr[k][2]>=70)&&(arr[k][2]<79)) com[k]="C";
		 else if((arr[k][2]>=60)&&(arr[k][2]<69)) com[k]="D";		
		 else if(60>arr[k][2]) com[k]="F";		 	
	//���
			 if(ave[k][0]>=90) total_ave[k]="A";
			 else if((ave[k][0]>=80)&&(ave[k][0]<89)) total_ave[k]="B";
			 else if((ave[k][0]>=70)&&(ave[k][0]<79)) total_ave[k]="C";
			 else if((ave[k][0]>=60)&&(ave[k][0]<69)) total_ave[k]="D";
			 else if(60>ave[k][0]) total_ave[k]="F";		
      }
		
		
		int temp;
		  for(int i =0; i< sum.length; i++) {
				for(int j= i+1; j < sum.length; j++) {					
					if((sum[i][0]) < sum[j][0]) {  //��ȯ
						temp = sum_compare[i][0];
						sum_compare[i][0] = sum_compare[j][0];
						sum_compare[j][0] = temp;												
					} // if end
					
				} // j end
			} // i end
		  
		  for(int j=0; j<totalnumber ; j++) {
		       for(int k=0;k<totalnumber;k++){	
		    		if( sum[j][0]<sum_compare[k][0]) {	    			
		    			rank[j][0]+=1;		
/*			    		���� ������δ� ������� ������ ǥ���ϱ� ���� ��ħ.	
						rank_name[j][0]=k+1; �������.


*/
		   }    //rank end			  
	  }	    //k end
}//j end 
		
	  for(int k=0;k<arr.length;k++) {//�ټ��� �Է����� for
		
		  System.out.println("****"+name[k]+"���� ����ǥ�Դϴ�.****");
			System.out.println("�̸�:" + name[k]);
			System.out.println("���� :" + arr[k][0] + "\t���� : " + arr[k][1] + "\t���� : " + arr[k][2]);
			System.out.println("*****"+name[k]+"���� ������ ������***** ");
			System.out.println("���� :" + han[k] + "\t���� : " +eng[k] + "\t���� : " + com[k]);
			System.out.printf("���� :%d \t�������:%.2f \n������� :%s ",  sum[k][0],ave[k][0],total_ave[k]);
			System.out.println(" ���� :"+rank[k][0]+"��");	  
	  }
	}//for end
			catch(InputMismatchException e) {//������ �Է��� int���� �ƴҶ� ���.
					System.out.println("������ �Է����ּ���.");	  
	}
	
	
	
}//
}//class end


