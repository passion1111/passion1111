package day03.operator;
/* pay=567890;         �� �߰��� �����ּ� ��Ʈ�� ������,�������� �����ٱܰ� ��Ʈ��+����Ʈ+������
   ����:5��                             ������ ��Ʈ�ѽ�����              ������ ��+��+��������
   õ��:6��
   ���:7��
   �ʿ�:8��         
 */

public class Ex01_operator_example {
			public static void main(String[] args) {
				//int pay=567890;
				//����:56��
				//õ��:7��
			    //���8��
				//�ʿ�9��
			int pay=567890;
			int Ma,Ch,Bac,Si;
			Ma=pay/10000;
			pay=pay%10000;
			Ch=pay/1000;
			pay=pay%1000;
			Bac=pay/100;
			pay=pay%100;
			Si=pay/10;
//�ڵ��� ���̱� Ma=pay/10000
			        //Ch=pay%10000/1000 ...�������� �̷����ϸ� pay�� �Ⱥ���. �ƴϸ� �����ϳ���.
			System.out.println("���� :"+Ma+"��");
			System.out.println("õ�� :"+Ch+"��");
			System.out.println("��� :"+Bac+"��");
			System.out.println("�ʿ� :"+Si+"��");
			
			
			}

}
