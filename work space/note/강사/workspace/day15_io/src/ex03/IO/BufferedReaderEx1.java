package ex03.IO;
import java.io.*;

public class BufferedReaderEx1 {
	public static void main(String[] args) 
			throws IOException {  //예외처리 위임
		
//		InputStream is = System.in;
//		Reader reader = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(reader);
		
		 BufferedReader br = new BufferedReader(
				 		   new InputStreamReader(System.in));
		 
		
		
		System.out.println("charator input = ");
		String str = br.readLine(); //예외발생. 여러개의 데이터 입력 받기
		
		System.out.println(str);
	}
}
