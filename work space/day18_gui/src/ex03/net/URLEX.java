package ex03.net;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class URLEX {
	public static void main(String[] args) 
				throws MalformedURLException, IOException { //����ó�� ����
		
		URL google = new URL("http://www.google.com"); //���ܹ߻�
		
		//System.in : ǥ���Է�
		BufferedReader br = new BufferedReader(
					new InputStreamReader(google.openStream())); //web 
		
		String inputLine;
		
		while((inputLine = br.readLine()) != null ) { //���ܹ߻�
			System.out.println(inputLine);
		}
		
		br.close();
	}
}
