package ex03.input;
import java.util.*;  //java.util.*ó���ϸ� util���� Ư�� Ŭ���� util.Scanner�� ��ü������ �ޱ⵵ ����
                                      //�Է¹ޱ� class jdk5.0�̻���ͻ���
									//�������� java.io<---input/output���� �޾���.
                       //javalang,extends object<-��� Ŭ������ ������Ʈ ��ӹ���. ������Ʈ�� �⺻��������
					//javalang������ ��� ��Ű���� import������Ѵ�.
public class InputTest {
			public static void main(String[] args) {     //ǥ���Է� System.in ,ǥ�����:System.out
				Scanner scan= new Scanner(System.in);  //�Է±׸� ����
				System.out.print("���� ������ �Է��ϼ��� : "+ "");
				int su=scan.nextInt();
				
				System.out.println("\n\n �Է� ���� �� : " +su);
				
				
			}
	                      

}