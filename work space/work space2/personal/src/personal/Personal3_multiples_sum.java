package personal;
import java.util.Arrays;

public class Personal3_multiples_sum {
	
	public static void main(String[] args) {
		
		  
			     
			  
		
			   int arr[] = new int [22];
			 
			     int j=0;   //�迭����
			     int temp=0; //3�ǹ�� ���庯��
			     int sum=0;
			     
			    
			     for(int i = 1; i < 50; i++)  //�ڿ��� 1���� 50�̸�����
			    {
			        if(i%3==0 || i%5==0) {   //3�Ǵ� 5�� ������ 
			        	temp=i;
						arr[j]=temp;     //0���� 3,5�� ��� ����
					       j++;       	 
 }//���� if�� ����.		       
			        System.out.println(Arrays.toString(arr));////�迭����Ȯ��.
 
			    } //for�� ����.
			     
	for (int k = 0; k < arr.length; k++) {
			    	 sum += arr[k] ;     //50�̸��� 3,5�� ��� ���ϱ�.
			    	 System.out.println(sum);
			            
			        }		   
			        }	
			    }
			    
				
			    
			    




//������� �ٽ� �迭�� �����ҷ��� ����ؾ��ϴ��� ã�ƺ��� 
//ã�ƺ� ��� ���ڿ�ó�� ǥ���ҷ��� api�� �ʿ��߾���.

 

