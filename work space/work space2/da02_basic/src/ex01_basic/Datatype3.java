//*
package ex01_basic;

public class Datatype3 {
		//����ȯ ����->intŸ�� �Ұ� int ���ڷδ°��� 
		public static void main(String[] args) { //main<- ctr+spacebar
			short sh =32767; //-32768~32767 : 2byte
			int num=32769;  //-21��~21�� 4byte
			//���� �ڷ����� ū�ڷ����� ���� �ڵ�����ȯ�� ��.(������ ����ȯ)
			num = sh;  //int(4byte) = short (2byte)
			
			System.out.println("sh= " +sh);
			System.out.println("num= " +num);

		   num=32769; //ū �ڷ����� �����ڷ������� �������� ������ ����ȯ�� �ʿ���.
		   //�׸��� �����ͼս��� �߻���.
		   sh=(short)num; //short(2byte)=num(4byte) 
		   System.out.println("sh= "+sh);
		   System.out.println("num= "+num);
		
		}
}

//*/

/*  

public class Datatype3 {
	//��� �ڷ����� �ڽ��� ����(ũ��)�� �ȹ����.
	public static void main(String[] args) { //main<- ctr+spacebar
		short sh = 32767;   //-32,768~32,767
		int num=50000; //-21��~21��
		
		System.out.println(sh+ " : " + num);
		num= -32769;
		/*sh= num;  < �����ߴ������� sh�� 2����Ʈ�� �Ѿ�⋚��*/
/*
		sh=(short)num;
		System.out.println(sh+ " : " + num); //��������Ұ�.
		//-32769���� 1�� ����⋚���� �����ͳ����� ����Ȱ���ȣ��
	}
}
*/

/*  */ // ���ʿ� */ /*�� /�ϳ��� �� ������ �ּ������ ������.

/* // ���ʿ� */ /*�� /�ϳ��� �� ������ �ּ������ ������.*/