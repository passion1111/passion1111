package ex03.IO;
import java.io.*;

public class BufferedReaderEx1 {
	public static void main(String[] args) 
			throws IOException {  //����ó�� ����
		
//		InputStream is = System.in;
//		Reader reader = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(reader);
		
		 BufferedReader br = new BufferedReader(
				 		   new InputStreamReader(System.in));
		 
		
		
		System.out.println("charator input = ");
		String str = br.readLine(); //���ܹ߻�. �������� ������ �Է� �ޱ�
		
		System.out.println(str);
	}
}
