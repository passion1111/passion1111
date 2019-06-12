package ex04_file;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
public class FileInputex {
	public static void main(String[] args) {
		//throws FileNotFoundException 예외 발생

Scanner sc = new Scanner(System.in);

try {
//	OutputStream os = new FileOutputStream("memo.txt"); //상대경로 현재 작업하는 폴더에 파일 생성
//	OutputStream os = new FileOutputStream("C:\\KSS\\work space\\day15_io\\memo.txt");//절대경로 역슬러쉬2번
	OutputStream os = new FileOutputStream("C:/KSS/work space/day15_io/memo.txt");//슬러쉬는 /이라면 한번
	while(true) {
		System.out.println("문자열 입력 요망 : ");
		String str = sc.nextLine() + "\r\n"; //\r는 맨 왼쪽으로 커서가 가게끔하는것.
		
//		if( str.toUpperCase().equals("EXIT\r\n")) break;
		if( str.equalsIgnoreCase("EXIT\r\n")) break;
		os.write(str.getBytes()); //읽어들인 문자 str의 길이(getBytes())만큼 써주세요.
	} //end while
	
} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}

}
}
