package method;

import java.util.InputMismatchException;
import java.util.Scanner;



//성적처리 함수로 분할(분리)할것
//입력함수input()-이름,국어,영어,전산 점수
//총점 함수 total(~~~)-총점 구하는 함수
//평균 함수 average(~~~)-평균구하는 함수
//출력 함수 output 함수 - 결과 출력
//학점 구하는 함수 grade()

//알아둘것 하나의 메소드에서 리턴받는 값은 하나씩이다.
//그러므로 국영수는 한번에 저장 이름 따로 저장
//
public class Mainentry_quiz5 {
	

	public static  int[][] input(int totalnumber,String[] name) { //이름,국어,영어,전산점수
		Scanner sc=new Scanner(System.in);
		int[][] arr=new int[totalnumber][3];	//국영수 저장하는곳
	   
		
	    try{   //실수 및 다른 형의 데이터가 들어오는것을 방지
	        for(int k=0;k<totalnumber;k++) {
	      
	      	  do {  //100~0사이의 정수를 위해
	      	  System.out.println((name[k])+"님의 국어성적을 입력해주세요:");
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
	      	 
	        }//for end
	        }//try end
	        
	    	catch(InputMismatchException e) {//데이터 입력이 int형이 아닐때 출력.
				System.out.println("정수를 입력해주세요.");	  
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
	
	public static  String[] name(int totalnumber){ //이름저장
		String[] name=new String[totalnumber];
		Scanner sc=new Scanner(System.in);
		 for(int k=0;k<totalnumber;k++) {
	      	  System.out.println("이름을 입력하세요: ");
	      	  name[k] = sc.next();
		 }
		 
		return name;
		
	}

	
	
	public static    int[] total(int[][]arr,int totalnumber) { //총점 구하는 함수
		int[] sum=new int[totalnumber];  //과목저장

	
		 for(int k=0;k<sum.length;k++) {
	    	  
			 sum[k]=arr[k][0]+arr[k][1]+arr[k][2];
			 
	    	  
		 }
		 
		return sum;
}
	
	public static  double[] average(int totalnumber,int[] sum) {//평균 구하는 함수

		double[] ave=new double[totalnumber];

		for(int k=0;k<totalnumber;k++) {
		    	
	    	  ave[k]=sum[k]/3.;
		 }
		return ave;
	}

	public static  String[][] grade(double[]ave,int totalnumber,int[][]arr,int[] sum) { //학점 구하는 함수
		String[][]grade_ave=new String[totalnumber][4];
		for(int k=0;k<arr.length;k++) {
		
  	  ave[k]=sum[k]/3.;
  	  
  	  //arraycopy를했을떄 하나의 값이 변경되면 나머지값도 변경됐기때문에 그냥 직접입력
  	 
    //배열 한글 grade_ave[k][0] 영어 grade_ave[k][1],grade_ave[k][2]
    
    //한글

		 if(arr[k][0]>=90) grade_ave[k][0]="A";
		 else if((arr[k][0]>=80)&&(arr[k][0]<89)) grade_ave[k][0]="B";
		 else if((arr[k][0]>=70)&&(arr[k][0]<79)) grade_ave[k][0]="C";
		 else if((arr[k][0]>=60)&&(arr[k][0]<69)) grade_ave[k][0]="D";	
		 else if((60>arr[k][0])) grade_ave[k][0]="F";		 	
	
		 //영어
		 if(arr[k][1]>=90) grade_ave[k][1]="A";
		 else if((arr[k][1]>=80)&&(arr[k][1]<89)) grade_ave[k][1]="B";
		 else if((arr[k][1]>=70)&&(arr[k][1]<79)) grade_ave[k][1]="C";
		 else if((arr[k][1]>=60)&&(arr[k][1]<69)) grade_ave[k][1]="D";		
		 else if(60>arr[k][1]) grade_ave[k][1]="F";	 	
	
		 //전산
		 if(arr[k][2]>=90) grade_ave[k][2]="A";
		 else if((arr[k][2]>=80)&&(arr[k][2]<89)) grade_ave[k][2]="B";
		 else if((arr[k][2]>=70)&&(arr[k][2]<79)) grade_ave[k][2]="C";
		 else if((arr[k][2]>=60)&&(arr[k][2]<69)) grade_ave[k][2]="D";		
		 else if(60>arr[k][2]) grade_ave[k][2]="F";		 	
	//평균
			 if(ave[k]>=90) grade_ave[k][3]="A";
			 else if((ave[k]>=80)&&(ave[k]<89)) grade_ave[k][3]="B";
			 else if((ave[k]>=70)&&(ave[k]<79)) grade_ave[k][3]="C";
			 else if((ave[k]>=60)&&(ave[k]<69)) grade_ave[k][3]="D";
			 else if(60>ave[k]) grade_ave[k][3]="F";		
    }
	return grade_ave;
		
	}

	

	public static  int[] dd2(int[] sum,int[] sum_compare,String[]rank) {  //순서정하는 함수

		
		int temp;
		  for(int i =0; i< sum.length; i++) {
				for(int j= i+1; j < sum.length; j++) {					
					if((sum[i]) < sum[j]) {  //교환
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
		
		
		System.out.println("입력해야하는 명수를 알려주세요");
		totalnumber=sc.nextInt();
//		int[][] arr=new int[totalnumber][3];	//국영수 저장하는곳
   
	   
		
		//이름과 과목 저장
		//input(totalnumber);
		
		String[]name1=name(totalnumber);////각자 입력하게되면 문제 메소드를 이렇게 나누면한번에 이름,과목으로 저장하기가 힘들다.
																//배열 리턴을 생각하면 메소드사용하지 않는게 좋을것같다.
		int[][] arr=input(totalnumber,name1);//리턴값 deep array복사

		int[] sum=total(arr,totalnumber);//총점을 sum에 저장.
		int[]sum_compare=total(arr,totalnumber); //sum과 비교할 배열 저장
		double ave[]=average(totalnumber,sum);//평균값저장			
		String[][]grade_ave=grade(ave,totalnumber,arr,sum);//국영수 총점이 들어가있음	
		int[]sum_compare1=dd2(sum,sum_compare,name1);//석차대로 정렬	
	int[]	rank=rank(sum_compare1,sum,totalnumber);//int형 배열을 따로 만들어줌.
		output(totalnumber,name1,sum,arr,grade_ave,ave,rank); //아웃풋

}//



public static  void output(int totalnumber,String[] name1,int[] sum,int[][] arr,String[][] grade_ave,double[] ave,int[] rank) {//결과 출력하는 함수
	  
	
	for(int k=0;k<grade_ave.length;k++) {//다수의 입력떄문에 for
			
		 
			System.out.println("****"+name1[k]+"님의 성적표입니다.****");
			System.out.println("이름:" + name1[k]);
			System.out.println("국어 :" + arr[k][0] + "\t영어 : " + arr[k][1] + "\t전산 : " + arr[k][2]);
			
			System.out.println("*****"+name1[k]+"님의 학점및 석차는***** ");
			System.out.println("국어 :" + grade_ave[k][0] + "\t영어 : " +grade_ave[k][1] + "\t전산 : " + grade_ave[k][2]);
			System.out.printf("총점 :%d \t평균점수:%.2f \n평균학점 :%s ",  sum[k],ave[k],grade_ave[k][3]);
			System.out.println(" 석차 :"+rank[k]+"등");	  
	  }
	}//for end
	
	
}

	