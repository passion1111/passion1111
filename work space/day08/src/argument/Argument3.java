package argument;
//�Է¹��� �׸��� scanner��������
//String[] args�� �Է¹��� �׸��̴�.
public class Argument3 {
	public static void main(String[] args) {//�Ű�����(�μ�)�� ���� ����
		if(args.length!=0) {
			
			
			double result=Double.parseDouble(args[0])+Double.parseDouble(args[1]);
			System.out.println(result);
			
		} else {
			System.out.println("main argument input error!");
			System.exit(0);
		}
		
	}//run as�� �����ϴ¹���� spacebar�� �����ϰų� ����Ű�� ����.
//	args�� ���ο� �迭�׸����� ����
//	�׸��� javac ���ϸ� ���� �����̽��� �Ѵ����� �迭�� ���־ �ؾ��ϴµ� ��Ŭ������ �����ϰ� �����ϴ���.
	

}
