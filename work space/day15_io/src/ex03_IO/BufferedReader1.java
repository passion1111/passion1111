package ex03_IO;
import java.io.*;
public class BufferedReader1 {
	public static void main(String[] args) throws Exception {//예외처리 위임.		
//		
//		InputStream is=System.in;		
//		Reader reader=new InputStreamReader(is);
//		BufferedReader br=new BufferedReader(reader);
		

		
//		객체생성을 따로 호출하지않으니 한번에 떄려넣기/
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("charactor input = ");
		String str=br.readLine();//예외발생 여러개의 데이터입력받
		System.out.println(str);
	}
}
