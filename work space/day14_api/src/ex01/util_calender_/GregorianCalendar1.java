package ex01.util_calender_;
import java.util.Calendar;
import java.util.GregorianCalendar;
class  GregorianCalendar1{
	public static void main(String[] args) {
		GregorianCalendar gcal = new GregorianCalendar();//calender�� ��ӹ޾Ƽ� new�� ��Ӱ���.
		p("���� ��¥�� �ð� \n");
		p(gcal.get(Calendar.YEAR)+"��");
		p((gcal.get(Calendar.MONTH)+1)+"��");
		p(gcal.get(Calendar.DATE)+"��");
		if(gcal.isLeapYear(gcal.get(Calendar.YEAR)))//�������������� Ȯ��.
			p("\n�����Դϴ�.");//p�� ����� �޼ҵ� sysout
		else
			p("\n������ �ƴմϴ�.");
	}
	static void p(String str){
		System.out.print(str);
	}
}
