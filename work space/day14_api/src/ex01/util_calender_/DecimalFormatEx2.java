package ex01.util_calender_;
import java.text.*;

class DecimalFormatEx2 
{
	public static void main(String[] args) 
	{
		DecimalFormat df = new DecimalFormat("#,###.##");//��Ʈ��Ÿ���� �̸��������ʰ� �̸� ����.
		DecimalFormat df2 = new DecimalFormat("#.###E0");

		try {
			Number num = df.parse("1,234,567.89");
			System.out.print("1,234,567.89" + " -> "); //���ڸ� ����Ÿ������ ��ȯ�ϴ� ����.

			double d = num.doubleValue(); 
			System.out.print(d + " -> ");

			System.out.println(df2.format(num));
		} catch(Exception e) {}
	} // main
}