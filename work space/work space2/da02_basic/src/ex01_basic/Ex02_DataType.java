package ex01_basic;

public class Ex02_DataType {
		static int num;			//class�ȿ��� static ���������ϸ� �������.
		static String str;		//������:0 �Ǽ���:0.0 ���ڿ�:Null�� �ʱ�ȭ
									//�˾Ƽ���.
		
	public static void main(String[] args) {
		int su=29;   //���������� �ݵ�� �ʱ�ȭ�ϰ� ����Ѵ�.
						//ex)int su; <--�̷����ϸ� �ʱ�ȭ�ش޶���䱸��.
					    //�޼ҵ�ȿ������� ��� ��������
		System.out.println(su);
		su=300;
		System.out.println(su);
		System.out.println(num);
		System.out.println(str);
	}  //main end
	
}// class end