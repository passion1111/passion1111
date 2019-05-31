
package personal;
//반 배정 랜덤 프로그램. 어딘지 몰라도 꼬여있음.
import java.util.Random;

public class  Personal_array_random{
	
	public static void main(String[] args) {
		String[] name= {"쉬","고","싶","다.","임","시","만","들","기","꽝","반","사","람","들","몇","명","인","지","몰","라","요"};
		int[] name2= new int[name.length];
		Random random=new Random();
		int i=0,i2=0;
		i=random.nextInt(name.length);
		for(int i1=0;i1<name.length;i1++)
		{
			name2[i1]=random.nextInt(name.length);
			
			for( i2=0;i2<i1;i2++) {
				
				
				
				if(name2[i2]==name2[i1]) {
					i1--;
				}			
			}
		}int k=0;
		System.out.println(name2[k]);
		System.out.println(name[k]=name[name2[k]]);
//				for(int i1=0;i1<name.length;i1++) {
//					                 name[i1]=name[(name2[i1])];
//					System.out.print(name2[i1]+"\t");
//					if((i1%5)==0) System.out.println("");
				}
}
	
//			}
//		
//	}
//
//
	
