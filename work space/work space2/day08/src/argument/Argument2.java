package argument;
//�Է¹��� �׸��� scanner��������
//String[] args�� �Է¹��� �׸��̴�.
public class Argument2 {
	public static void main(String[] args) {//�Ű�����(�μ�)�� ���� ����
		if(args.length!=0) {
			System.out.println(args[0]);
			String str=args[1];
			System.out.println(str);
		} else {
			System.out.println("main argument input error!");
			System.exit(0);
		}
		
	}//run as�� �����ϴ¹���� spacebar�� �����ϰų� ����Ű�� ����.
//	args�� ���ο� �迭�׸����� ����
//	�׸��� javac ���ϸ� ���� �����̽��� �Ѵ����� �迭�� ���־ �ؾ��ϴµ� ��Ŭ������ �����ϰ� �����ϴ���.
	

}
