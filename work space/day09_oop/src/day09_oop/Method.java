package day09_oop;

public class Method {
	public static void main(String[] args) {
		int x=5,y=0;
		int i;
		
		for(i=1;i<6;i++) { //ctr+shif+b 중단점을 찍은것 
		  y+=x*i;	    //f5키를 누르면 다음으로 넘어가기 시작.
		}//for end
		for(i=1;i<100;i++) {
			if(i==30)break;
			System.out.println(i);
			}
	System.out.println(y);
	}
}
