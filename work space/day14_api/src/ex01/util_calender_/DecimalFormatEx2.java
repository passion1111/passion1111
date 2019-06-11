package ex01.util_calender_;
import java.text.*;

class DecimalFormatEx2 
{
	public static void main(String[] args) 
	{
		DecimalFormat df = new DecimalFormat("#,###.##");//스트링타입을 미리만들지않고 미리 지정.
		DecimalFormat df2 = new DecimalFormat("#.###E0");

		try {
			Number num = df.parse("1,234,567.89");
			System.out.print("1,234,567.89" + " -> "); //숫자를 문자타입으로 변환하는 예제.

			double d = num.doubleValue(); 
			System.out.print(d + " -> ");

			System.out.println(df2.format(num));
		} catch(Exception e) {}
	} // main
}