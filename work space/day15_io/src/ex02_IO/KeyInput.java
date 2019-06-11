package ex02_IO;

import java.io.InputStream;

public class KeyInput {
	public static void main(String[] args) {
		InputStream is=System.in; //표준 입력
		try { //read()는 더이상 입력받을게 없으면 -1이 리턴된다.
			System.out.println("단일 문자 입력 요망:");
			int num=is.read()-48; //예외발생함 '0'~'9' : 48~57(ASCII code)
//		입력대기상태에서 값을넣으면 메모리상에는 임시버퍼가존재하는데 임시버퍼에서 3이들어가고 엔터도 같이들어감.
			is.read();//문제발생처리 - 자바는 '문자'2바이트 처리됨.
			is.read();//그래서 2번 써줌.
			int num2=is.read()-48;
			
			System.out.println(num+num2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
