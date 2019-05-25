package personal;
//경우의 수  구하기
//a<b,a<c   <--두가지 모두 충족하면 b와 c 크기비교하면 바로 구할수있음.
//a>b,a>c   <--  위와 같음. 위의 방법으로 4가지 경우의수를 줄임.
//a=b c크고작고,a=c b크고작고,b=c a크고작고,a=b=c
//조건:0!=a,b,c
//같은경우를 제외하고 구할떄는 6가지 경우의 수만 따지면 됨.
//a가 중간크기의 경우의 수를 구하면 되니 x와 나머지 하나만 비교하면
//6가지 경우의 수 모두 구할수있음.
import java.util.Scanner;

public class Personal_quiz2 {
   public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("x,y,z를 차례대로 입력해주세요: ");
	   int x=sc.nextInt(),y=sc.nextInt(),z=sc.nextInt(),max=0;
	   
	 if(x!=0&&y!=0&&z!=0) {
	   max=((x<y)&&(x<z))?((y<z)?1:2):((x>y)&&(x>z))?((y<z)?3:4):(x<y)?5:6;                         
		   	switch(max) {
			   case 1: System.out.println("x<y<z");break; // //max값 1,2,3,4으로 
			   case 2:System.out.println("x<z<y");break; //max1= x<y<z 
			   case 3:System.out.println("y<z<x");break; //max2=x<z<y
			   case 4:System.out.println("z<y<x");break;// max3,max4는 보는것과같음.
			   case 5:System.out.println("z<x<y");break;
			   case 6:System.out.println("y<x<y");break;
			   } //switch 끝나는부분.  
  }       else System.out.println("정수를 입력해주세요.");
}
}