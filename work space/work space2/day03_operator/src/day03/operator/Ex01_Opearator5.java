
package day03.operator;
	
public class Ex01_Opearator5 {
	public static void main(String[] args) {
		   					//논리 연산자:&  &&(and), |  || (or) , ^(xor)
	
	      
		int x=10,y=20,z=30;  //&&,|| 연산은 아에것이 거짓이면 뒤에것은 실행안함.2개붙으면 10진
									//true,false  앞에것이 거짓이거나 참인것을 앞에쪽으로 뺴주면 성능향상가능.
		boolean flag;         //booealn은 계산결과가 true false로 나오게 할것.
		flag=(x<y)&&(y<z);
		System.out.println(flag);
		
		flag=(x<y)||(z<y);           //||는 앞에것이 참이면 뒤에것 실행안함 의미없으므로.
		System.out.println(flag);
				
		
	
	}//end main

}//end class




/*
int a=4;
int b=7;
int c=3;


  System.out.println(a&b);   //2진수비교
  System.out.println(a|b);
  System.out.println(b^a);
  */



/*  &&두개있으면 중간에 안맞으면 바로 빠져나감.  논리타입.
int x=10,y=20,z=30;
boolean flag;

flag=(x>y)&&(y>z);
System.out.println(flag);

*/
