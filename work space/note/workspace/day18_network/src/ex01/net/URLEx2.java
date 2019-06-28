package ex01.net;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class URLEx2 {
	public static void main(String[] args) 
				throws MalformedURLException, IOException { //예외처리 위임
		
		URL url = new URL("https://www.google.com/search?source=hp&ei=8EkDXd_fIaGLr7wPwJCDkAo&q=%EB%B0%95%ED%83%9C%ED%99%98&oq=%EB%B0%95%ED%83%9C%ED%99%98&gs_l=psy-ab.3..0l10.2742746.2744238..2744742...3.0..1.150.1279.0j11......0....1..gws-wiz.....6..35i39j0i131.7qMi_T7O14Y"); //예외발생
		
		System.out.println("프로토콜 : " + url.getProtocol());
		System.out.println("호스트와 포트 : " + url.getAuthority());
		System.out.println("호스트 : " + url.getHost());
		System.out.println("포트 : " + url.getPort());
		System.out.println("경로 : " + url.getPath());
		System.out.println("질의 : " + url.getQuery());
		System.out.println("파일명 : " + url.getFile());
		System.out.println("참조 : " + url.getRef());
		
	}
}






