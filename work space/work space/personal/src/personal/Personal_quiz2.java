package personal;
//����� ��  ���ϱ�
//a<b,a<c   <--�ΰ��� ��� �����ϸ� b�� c ũ����ϸ� �ٷ� ���Ҽ�����.
//a>b,a>c   <--  ���� ����. ���� ������� 4���� ����Ǽ��� ����.
//a=b cũ���۰�,a=c bũ���۰�,b=c aũ���۰�,a=b=c
//����:0!=a,b,c
//������츦 �����ϰ� ���ҋ��� 6���� ����� ���� ������ ��.
//a�� �߰�ũ���� ����� ���� ���ϸ� �Ǵ� x�� ������ �ϳ��� ���ϸ�
//6���� ����� �� ��� ���Ҽ�����.
import java.util.Scanner;

public class Personal_quiz2 {
   public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("x,y,z�� ���ʴ�� �Է����ּ���: ");
	   int x=sc.nextInt(),y=sc.nextInt(),z=sc.nextInt(),max=0;
	   
	 if(x!=0&&y!=0&&z!=0) {
	   max=((x<y)&&(x<z))?((y<z)?1:2):((x>y)&&(x>z))?((y<z)?3:4):(x<y)?5:6;                         
		   	switch(max) {
			   case 1: System.out.println("x<y<z");break; // //max�� 1,2,3,4���� 
			   case 2:System.out.println("x<z<y");break; //max1= x<y<z 
			   case 3:System.out.println("y<z<x");break; //max2=x<z<y
			   case 4:System.out.println("z<y<x");break;// max3,max4�� ���°Ͱ�����.
			   case 5:System.out.println("z<x<y");break;
			   case 6:System.out.println("y<x<y");break;
			   } //switch �����ºκ�.  
  }       else System.out.println("������ �Է����ּ���.");
}
}