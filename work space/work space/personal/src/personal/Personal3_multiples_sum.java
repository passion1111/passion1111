package personal;
import java.util.Arrays;

public class Personal3_multiples_sum {
	
	public static void main(String[] args) {
		
		  
			     
			  
		
			   int arr[] = new int [22];
			 
			     int j=0;   //배열순서
			     int temp=0; //3의배수 저장변수
			     int sum=0;
			     
			    
			     for(int i = 1; i < 50; i++)  //자연수 1부터 50미만까지
			    {
			        if(i%3==0 || i%5==0) {   //3또는 5의 배수라면 
			        	temp=i;
						arr[j]=temp;     //0부터 3,5의 배수 저장
					       j++;       	 
 }//작은 if문 끝남.		       
			        System.out.println(Arrays.toString(arr));////배열저장확인.
 
			    } //for문 끝남.
			     
	for (int k = 0; k < arr.length; k++) {
			    	 sum += arr[k] ;     //50미만의 3,5의 배수 더하기.
			    	 System.out.println(sum);
			            
			        }		   
			        }	
			    }
			    
				
			    
			    




//결과값을 다시 배열에 저장할려면 어떻게해야하는지 찾아보기 
//찾아본 결과 문자열처럼 표현할려면 api가 필요했었음.

 

