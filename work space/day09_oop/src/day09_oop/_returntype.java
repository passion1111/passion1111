package day09_oop;

public class _returntype {
	//�Լ������
	//	1.�Լ����ǹ� �����
	// 2.�����Լ����� ȣ���ؼ� �����.
	// �Ϲ������� ���� ������ �����µ�.
	// ���� �Լ��� ȣ���� ����� ���Ŀ�
	// ���߿� �Լ��� ����°͵� ���
		public static void main(String[] args) {
			int x=3,y=5;
		int result=	methodex(x,y);
		System.out.println(result);
		
		
		int[] arrResult=methodex();
		for(int i=0;i<arrResult.length;i++)System.out.println(arrResult[i]);
		
		
		}

	public static int[] methodex() {
		int[] arr= {1,2,3,4,5};
		
		return arr;//�������� ������ ������ �迭,��ü(object)�� ���ؼ� ������.
		
		
		
	}

	public static int methodex(int x, int y) {//������ ���� �����ָ� {
                 
		return x+y; //���ϰ��� ���� 1����,��,����,����
	}
}
