package ex03.net;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class URLEX2 {
	public static void main(String[] args) 
				throws MalformedURLException, IOException { //예외처리 위임
		
		URL url = new URL("https://www.google.com/search?ei=yVMDXZdKgpSYBZTvjFA&q=kim+yuna&oq=kim&gs_l=psy-ab.3.0.0i67j0l2j0i131j0l6.12395.13828..15013...0.0..0.96.363.4......0....1..gws-wiz.....0.zBvMD60eKyM"); //예외발생
		
		System.out.println("프로토콜 : +"+url.getProtocol());
		System.out.println("호스트와 포트 : +"+url.getAuthority());
		System.out.println("호스트 : +"+url.getHost());
		System.out.println("포트 : +"+url.getPort());
		System.out.println("경로 : +"+url.getPath());
		System.out.println("질의 : +"+url.getQuery());
		System.out.println("파일명 : +"+url.getFile());
		System.out.println("참조 : +"+url.getRef());
		
		
		
	}
}






