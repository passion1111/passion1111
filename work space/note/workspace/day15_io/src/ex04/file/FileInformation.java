package ex04.file;
import java.io.*;
import java.util.Date;

public class FileInformation {
	public static void main(String[] args) 
			throws IOException {  // 예외처리 위임
		
		File file = null;
		byte[] fileName = new byte[100];
		String strName;
		System.out.print("file name = "); // 상대경로 - momo.txt
				//절대경로 - C:\th129_java_web_app_developer\1_Java\th129_class_java 일자별 정리.txt
		System.in.read(fileName); // 예외발생
		strName = new String(fileName).trim(); //위에서 읽어낸 파일 이름 받아옴
		
		file = new File(strName);
		
		System.out.println("절대경로 : " + file.getAbsolutePath());
		System.out.println("표준경로 : " + file.getCanonicalPath());
		System.out.println("최종 수정일 : " + new Date(file.lastModified())); //
		System.out.println("파일크기 : " + file.length());
		System.out.println("읽기속성 : " + file.canRead());
		System.out.println("쓰기속성 : " + file.canWrite());
		System.out.println("파일경로 : " + file.getPath());
		System.out.println("숨김속성 : " + file.isHidden());
		
		
		
	}
}






