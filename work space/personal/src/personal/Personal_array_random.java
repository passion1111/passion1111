
package personal;
//�� ���� ���� ���α׷�. ����� ���� ��������.
import java.util.Random;

public class  Personal_array_random{
	
	public static void main(String[] args) {
		
	String[] name= {"��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
	String[] name3=new String[name.length];
	int[] name2= new int[name.length];
		Random random=new Random();
		int i=0,i2=0;
		i=random.nextInt(name.length);
		for(int i1=0;i1<name.length;i1++) //�ߺ����� �迭name2�� �������� �ִ� ���α׷�
		{
			name2[i1]=random.nextInt(name.length);
			
			for( i2=0;i2<i1;i2++) {
				
				
				
				if(name2[i2]==name2[i1]) {
					i1=i1-1;
				}			
			}      // �ߺ����� �迭 name2�� ���� ���� �ֱ�.
		}int k=0;
		
				for(int i1=0;i1<name.length;i1++) {
									name3[i1]=name[(name2[i1])];
//					                 name[i1]=name[(name2[i1])];   //���� name[0]���� name2�� �Էµ� ������ ����
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
	
