package ex01.returnType;

public class MethodTest {
	
	public static int methodEx(double d1, double d2) {
		double hap = d1 + d2;
		
		//�����ϴ� �Լ��� �ڷ����� �켱 ���� ����
		return (int)hap; //����Ÿ�԰� �Լ�Ÿ��(�ڷ���)�� �ٸ��� ������. 
	}
	
	public static void main(String[] args) {
		
		int result = methodEx(1.2, 5.7);
	}
}
