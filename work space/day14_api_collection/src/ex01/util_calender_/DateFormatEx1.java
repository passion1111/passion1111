package ex01.util_calender_;
import java.util.Date;
import java.text.SimpleDateFormat;

class DateFormatEx1{
	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today);  //
		SimpleDateFormat sdf1, sdf4;//����Ʈ�����̶�� �ڹ������ε� �ش��ϴ� ��ü�� ����ڰ� ���ϴ� ��¥��
//			�ٲٱ����� ��ü
		sdf1 = new SimpleDateFormat("yy-MM-dd");//��-��-�� �ݵ�� "" <--�ȿ� ���������.�ֳ��ϸ� -�� ������
												//���ڷ� �����ų� ���ڸ� �A�ٴ� �ǹ̷� �ν�.
//												�⵵�� 2�ڸ���.
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a E");//a�� am pm E�� ���� E��4���� ���̴ϱ� ���Ϸγ���.
		System.out.println(sdf1.format(today));	// format(Date d)
		System.out.println(sdf4.format(today));
	}
}