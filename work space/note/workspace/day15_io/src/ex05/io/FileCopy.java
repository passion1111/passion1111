//*
package ex05.io;
import java.io.*;

public class FileCopy {
	public static void main(String[] args) throws Exception { //예외처리 위임
		//읽기객체 - FileInputStream
		InputStream is = new FileInputStream("Koala.jpg");
		//쓰기객체 - FileOutputStream
		OutputStream os = new FileOutputStream("copy.jpg");
		
		byte[] buffer = new byte[1024 * 8];  //
		
		long start = System.currentTimeMillis();  //시작 시간 저장
		
		while(true) {
			int inputData = is.read(buffer); // buffer 크기만큼 읽어들임
			if( inputData == -1 ) break;
			os.write(buffer, 0, inputData); //
		} //end while
		
		long end = System.currentTimeMillis(); // 끝난 시간 저장 
		
		System.out.println(end - start); //복사(작업)에 걸린 시간 나옴
		
		is.close();		os.close();
		System.out.println("copy success!!!");
		
	}
}
//*/



/*
package ex05.io;
import java.io.*;

public class FileCopy {
	public static void main(String[] args) throws Exception { //예외처리 위임
		//읽기객체 - FileInputStream
		InputStream is = new FileInputStream("Koala.jpg");
		//쓰기객체 - FileOutputStream
		OutputStream os = new FileOutputStream("copy.jpg");
		
		long start = System.currentTimeMillis();
		
		while(true) {
			int inputData = is.read();
			if( inputData == -1 ) break;
			os.write(inputData);
		} //end while
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start); //복사(작업)에 걸린 시간 나옴
		
		is.close();		os.close();
		System.out.println("copy success!!!");
		
	}
}
//*/




