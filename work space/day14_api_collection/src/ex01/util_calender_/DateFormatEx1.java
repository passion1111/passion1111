package ex01.util_calender_;
import java.util.Date;
import java.text.SimpleDateFormat;

class DateFormatEx1{
	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today);  //
		SimpleDateFormat sdf1, sdf4;//데이트포맷이라는 자바포맷인데 해당하는 객체를 사용자가 원하는 날짜로
//			바꾸기위한 객체
		sdf1 = new SimpleDateFormat("yy-MM-dd");//년-월-일 반드시 "" <--안에 적어줘야함.왜냐하면 -를 적으면
												//숫자로 나누거나 숫자를 뺸다는 의미로 인식.
//												년도를 2자리만.
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a E");//a는 am pm E는 요일 E를4개를 붙이니까 요일로나옴.
		System.out.println(sdf1.format(today));	// format(Date d)
		System.out.println(sdf4.format(today));
	}
}