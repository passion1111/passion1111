package ex03.net;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class URLEX {
	public static void main(String[] args) 
				throws MalformedURLException, IOException { //예외처리 위임
		
		URL google = new URL("http://www.google.com"); //예외발생
		
		//System.in : 표준입력
		BufferedReader br = new BufferedReader(
					new InputStreamReader(google.openStream())); //web 
		
		String inputLine;
		
		while((inputLine = br.readLine()) != null ) { //예외발생
			System.out.println(inputLine);
		}
		
		br.close();
	}
}
