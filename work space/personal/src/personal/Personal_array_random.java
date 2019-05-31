
package personal;
//반 배정 랜덤 프로그램. 어딘지 몰라도 꼬여있음.
import java.util.Random;

public class  Personal_array_random{
	
	public static void main(String[] args) {
		
	String[] name= {"ㄱ","ㄴ","ㄷ","ㄹ","ㅂ","ㅅ","ㅇ","ㅁ","바","가","나","다","라","마"};
	String[] name3=new String[name.length];
	int[] name2= new int[name.length];
		Random random=new Random();
		int i=0,i2=0;
		i=random.nextInt(name.length);
		for(int i1=0;i1<name.length;i1++) //중복없이 배열name2에 랜덤숫자 넣는 프로그램
		{
			name2[i1]=random.nextInt(name.length);
			
			for( i2=0;i2<i1;i2++) {
				
				
				
				if(name2[i2]==name2[i1]) {
					i1=i1-1;
				}			
			}      // 중복없이 배열 name2에 랜덤 숫자 넣기.
		}int k=0;
		
				for(int i1=0;i1<name.length;i1++) {
									name3[i1]=name[(name2[i1])];
//					                 name[i1]=name[(name2[i1])];   //기존 name[0]부터 name2에 입력된 숫자의 대입
//									
//					                 name[(name2[i1])]=name3[i1];
					                 
				}
				
				for(int i1=1;i1<=name.length;i1++) {
				System.out.print(name3[i1-1]+"\t");			//
				if((i1%5)==0) System.out.println("");
				}
	
		}
		
	}
//
//
	
