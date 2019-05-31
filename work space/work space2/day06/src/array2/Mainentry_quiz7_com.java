package array2;

import java.util.InputMismatchException;
// 이름, 과목x개입력받고 ,총점 평균 평점 구하기.
// 성적표 x개 뿌리기.
import java.util.Scanner;
//
public class Mainentry_quiz7_com {
	public static void main(String[] args) {
		int totalnumber=0;
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("입력해야하는 명수를 알려주세요");
		totalnumber=sc.nextInt();
		
		//이름과 과목 저장
	int[][] arr=new int[totalnumber][3];	//국영수 저장하는곳
    String[] name=new String[totalnumber];  //이름 저장하는곳
    int[][] rank=new int[totalnumber][1];       // 석차저장하는곳
    int[][] sum =new int[totalnumber][1];  //세 과목 총합
    int[][] sum_compare=new int[totalnumber][1];   //과목 비교하기위한 배열
    double[][] ave =new double[totalnumber][1];  //세과목 평균
   
    //학점과 전체평균저장
    String[] han=new String[totalnumber]; 
    String[] eng=new String[totalnumber]; 
    String[] com=new String[totalnumber]; 
    String[] total_ave=new String[totalnumber]; 
		
		
	try{   //실수 및 다른 형의 데이터가 들어오는것을 방지
      for(int k=0;k<arr.length;k++) {
    	  System.out.println("이름을 입력하세요: ");
    	  name[k] = sc.next();
    	  do {  //100~0사이의 정수를 위해
    	  System.out.println((k+1)+"번쨰 사람의 국어성적을 입력해주세요:");
    	  arr[k][0]=sc.nextInt();
    	  }while(arr[k][0]<0 ||arr[k][0]>100);
    	  
    	  do {
    	  System.out.println("영어 점수를 입력하세요: ");
    	  arr[k][1]=sc.nextInt();
    	  }while(arr[k][1]<0 ||arr[k][1]>100);
    	  
    	  do {
    	  System.out.println("전산 점수를 입력하세요: ");
    	  arr[k][2]=sc.nextInt();
    	  }while(arr[k][2]<0 ||arr[k][2]>100);
    	  rank[k][0]=1;
      }
	
	
    
     
      for(int k=0;k<arr.length;k++) {
    	  sum[k][0]=arr[k][0]+arr[k][1]+arr[k][2];
    	  ave[k][0]=sum[k][0]/3.;
    	  sum_compare[k][0]=arr[k][0]+arr[k][1]+arr[k][2];  
    	  //arraycopy를했을떄 하나의 값이 변경되면 나머지값도 변경됐기때문에 그냥 직접입력
    	 
      
      
      //한글

  		 if(arr[k][0]>=90) han[k]="A";
  		 else if((arr[k][0]>=80)&&(arr[k][0]<89)) han[k]="B";
  		 else if((arr[k][0]>=70)&&(arr[k][0]<79)) han[k]="C";
  		 else if((arr[k][0]>=60)&&(arr[k][0]<69)) han[k]="D";	
  		 else if(60>arr[k][1]) han[k]="F";		 	
  	
  		 //영어
		 if(arr[k][1]>=90) eng[k]="A";
		 else if((arr[k][1]>=80)&&(arr[k][1]<89)) eng[k]="B";
		 else if((arr[k][1]>=70)&&(arr[k][1]<79)) eng[k]="C";
		 else if((arr[k][1]>=60)&&(arr[k][1]<69)) eng[k]="D";		
		 else if(60>arr[k][1]) eng[k]="F";	 	
	
		 //전산
		 if(arr[k][2]>=90) com[k]="A";
		 else if((arr[k][2]>=80)&&(arr[k][2]<89)) com[k]="B";
		 else if((arr[k][2]>=70)&&(arr[k][2]<79)) com[k]="C";
		 else if((arr[k][2]>=60)&&(arr[k][2]<69)) com[k]="D";		
		 else if(60>arr[k][2]) com[k]="F";		 	
	//평균
			 if(ave[k][0]>=90) total_ave[k]="A";
			 else if((ave[k][0]>=80)&&(ave[k][0]<89)) total_ave[k]="B";
			 else if((ave[k][0]>=70)&&(ave[k][0]<79)) total_ave[k]="C";
			 else if((ave[k][0]>=60)&&(ave[k][0]<69)) total_ave[k]="D";
			 else if(60>ave[k][0]) total_ave[k]="F";		
      }
		
		
		int temp;
		  for(int i =0; i< sum.length; i++) {
				for(int j= i+1; j < sum.length; j++) {					
					if((sum[i][0]) < sum[j][0]) {  //교환
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
/*			    		기존 방식으로는 공동등수 다음을 표현하기 힘들어서 고침.	
						rank_name[j][0]=k+1; 기존방식.


*/
		   }    //rank end			  
	  }	    //k end
}//j end 
		
	  for(int k=0;k<arr.length;k++) {//다수의 입력떄문에 for
		
		  System.out.println("****"+name[k]+"님의 성적표입니다.****");
			System.out.println("이름:" + name[k]);
			System.out.println("국어 :" + arr[k][0] + "\t영어 : " + arr[k][1] + "\t전산 : " + arr[k][2]);
			System.out.println("*****"+name[k]+"님의 학점및 석차는***** ");
			System.out.println("국어 :" + han[k] + "\t영어 : " +eng[k] + "\t전산 : " + com[k]);
			System.out.printf("총점 :%d \t평균점수:%.2f \n평균학점 :%s ",  sum[k][0],ave[k][0],total_ave[k]);
			System.out.println(" 석차 :"+rank[k][0]+"등");	  
	  }
	}//for end
			catch(InputMismatchException e) {//데이터 입력이 int형이 아닐때 출력.
					System.out.println("정수를 입력해주세요.");	  
	}
	
	
	
}//
}//class end


