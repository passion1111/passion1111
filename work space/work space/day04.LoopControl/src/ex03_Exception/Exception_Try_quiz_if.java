package ex03_Exception;
//��Ģ���� ���α׷� �ۼ�
//���� 2�� �Է¹ް� ,������(+,-,*,/)1�� �Է¹޾Ƽ� 
// result>
//   3
//   4
//   5
//   3 +  5 = 8 
// �ٵ� 0���� ������������ ����ó���ؾ��ϹǷ� try catch�� ����ó���ϱ�.
import java.util.Scanner;

public class Exception_Try_quiz_if {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("����2���� ������ ��Ģ������ �Է����ּ���");
		int su1= sc.nextInt();
		int su2= sc.nextInt();
		int sum= su1+su2;
		int cha= su1-su2;
		int gob=su1*su2;
		double na=(float)su1/(float)su2;
		String a=sc.next();
		String a1="+";
		String a2="-";
		String a3="*";
		String a4="/";
	
		if(a.equals("+"))  {  //char�̸� �񱳰��� �Է��� ����=��ĳ�ʺ�����.next().charAt(�迭����)���ι޾ƾ���.
//			                         ==�� ���� String ������ "A"�� ���A�ڿ�\0(null)���� �������Ƿΰ��̴ٸ���
//									%s�� null���ڸ����������� ��� StringŸ���� ��ü�̱⋚��. char�� ������ �񱳰���.
//			                       String�� ��ü�̹Ƿ�(Ŭ�����̹Ƿ�) new�� ��������������� print�ȿ� ���� ���ϴ°�(System.out.print<-������ ����Ʈ)
//                                 ���ҷ��� ����.equals("���ڿ�"); �����ڸ� �����ް��� �Ʒ����� next�� nextLIne���ι����� �������������.
			System.out.printf("%d + %d=%d",su1,su2,sum);
		}
		else if(a.equals(a2)) {
             System.out.printf("\n %d - %d=%d",su1,su2,cha);
		}
		else if(a.equals(a3))
		{
		 System.out.printf("\n %d*%d=%d",su1,su2,gob); 
		}
		else if(a.equals(a4))
						try {
					System.out.printf("\n %d/%d=%.2f",su1,su2,na); 
}
						catch(ArithmeticException e) {
					  System.out.print("0���� �����������ϴ�.");
		}
		
}
}

//�Ǽ���Ÿ���� ��� 0���� �޾������� formatmismatch�� ������Ÿ�Ժ�ȯ��������.
//�Ǵ� inputmismatchexception���� �Է°��� �߸��ƴٰ� ����ó���ϸ��.

