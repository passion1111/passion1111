package ex05.io;
import java.io.*;
import java.net.*;

public class UriCopy {
	public static void main(String[] args) 
			throws MalformedURLException, IOException {  //예외처리우임
		
		URL url = new URL("https://www.google.com/logos/doodles/2019/2019-womens-world-cup-day-6-5696430367309824-s.png");
		
		//읽기객체
		InputStream is = url.openStream();
		//쓰기객체
		OutputStream os = new FileOutputStream("goole.jpg"); // 상대경로
		
		byte[] buffer = new byte[1024];
		
		while(true) {
			int inputData = is.read(buffer);
			
			if( inputData == -1 ) break;
			
			os.write(buffer, 0, inputData);
		}
		
		is.close();		os.close();
		System.out.println("웹에서 파일 복사 성공했습니다");
	}
}









