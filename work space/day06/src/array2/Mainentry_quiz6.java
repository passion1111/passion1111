package array2;

// �̸�, ����3���Է¹ް� ,���� ��� ���� ���ϱ�.
// ����ǥ 3�� �Ѹ���.
import java.util.Scanner;

public class Mainentry_quiz6 {
	public static void main(String[] args) {
		int a5=0;
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("�Է��ؾ��ϴ� ����� �˷��ּ���");
		a5=sc.nextInt();
		
		
		int[][] arr=new int[a5][3];

    String[] name=new String[a5];
    int[][] rank_name=new int[a5][1];
		
		
	
      for(int k=0;k<arr.length;k++) {
    	  System.out.println("�̸��� �Է��ϼ���: ");
    	  name[k] = sc.next();
    	  do {
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
      }

      int[][] sum =new int[a5][1];
      double[][] ave =new double[a5][1];
      int[][] sum_compare=new int[a5][1];
      for(int k=0;k<arr.length;k++) {
    	  sum[k][0]=arr[k][0]+arr[k][1]+arr[k][2];
    	  ave[k][0]=sum[k][0]/3.;
    	  sum_compare[k][0]=arr[k][0]+arr[k][1]+arr[k][2];
    	 
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
		 if(arr[k][0]>=90) grade3[k]="A";
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
		  
		  for(int j=0; j<a5 ; j++) {
		      for(int k=0;k<a5;k++) {	
		    		if( sum[j][0]== sum_compare[k][0]) {	    			
		    			rank_name[j][0]=k+1;	
		    		
		    		
		    		} 			  
		    	  }	    
	}
		
		
		int k=0;
	  for(;k<arr.length;k++) {
		
		  System.out.println("****"+name[k]+"���� ����ǥ�Դϴ�.****");
			System.out.println("�̸�:" + name[k]);
			System.out.println("���� :" + arr[k][0] + "\t���� : " + arr[k][1] + "\t���� : " + arr[k][2]);
			System.out.println(name[k]+"\n���� ������ ������ ");
			System.out.println("���� :" + grade3[k] + "\t���� : " +grade[k] + "\t���� : " + grade2[k]);
			System.out.printf("���� :%d \t�������:%.2f \n������� :%s ",  sum[k][0],ave[k][0],grade4[k]);
//			System.out.println("\n�������:"+grade4[k]);
			System.out.println(" ���� :"+rank_name[k][0]+"��");
		  
	  }
	  
//		

	}
}


