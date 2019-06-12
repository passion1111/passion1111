package ex04.file;
import java.io.*;
import java.util.Scanner;

public class FileInputEx {
	public static void main(String[] args) {
				//throws FileNotFoundException 예외 발생
		
		Scanner sc = new Scanner(System.in);
		
		try {
			//OutputStream os = new FileOutputStream("memo.txt"); //상대경로
			//OutputStream os = new FileOutputStream("C:\\th129_java_web_app_developer\\1_Java\\test.dat"); //절대경로
			OutputStream os = new FileOutputStream("C:/IDE/sample.txt"); //절대경로
			
			while(true) {
				System.out.println("문자열 입력 요망 : ");
				String str = sc.nextLine() + "\r\n";
				
				if( str.toUpperCase().equals("EXIT\r\n")) break;
				
				os.write(str.getBytes()); //읽어들인 문자 str의 길이(getBytes())만큼 써주세요.
				//System.out.println(str); //화면출력
			} //end while
			
			System.out.println("memo.txt save success!!!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}






