package ex03_Exception;
//��Ģ���� ���α׷� �ۼ�
//���� 2�� �Է¹ް� ,������(+,-,*,/)1�� �Է¹޾Ƽ� 
// result>
//   3
//   4
//   5
//   3 +  5 = 8 
// �ٵ� 0���� ������������ ����ó���ؾ��ϹǷ� try catch�� ����ó���ϱ�. if
import java.util.Scanner;

public class Exception_Try_quiz_teacher {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("����2���� ������ ��Ģ������ �Է����ּ���");
		int su1,su2,result=0;
		char op;
		System.out.println("## ������(+,-,*,/)�� �ϳ��� �Է��ϼ���. ");
		op=sc.next().charAt(0);//���ڿ� 7.0�������� ���޾ұ⋚���� char�� ó���ϱ����� ���
		System.out.println("##su1="); su1=sc.nextInt();
		System.out.println("##su2="); su2=sc.nextInt();
		
		
		switch(op) {
		case '+' :result=su1+su2;break;
		case '-' :result=su1-su2;break;
		case '*' :result=su1*su2;break;
		case '/' :result=su1/su2;break;
		default:System.out.println("�ٽ��Է����ּ���");
		break;
		}
		System.out.println("����� su1"+op+"su2="+result);
	}
}
		//if((op!='+'))&&(op!='-')&&(op!='*')&&(op!='/')
//		��Ģ�����̿ܰ� �Էµ����������� ��

