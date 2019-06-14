package ex03.net;
import java.net.*;

public class MainEntry2 {
	public static void main(String[] args) 
						throws UnknownHostException { //예외처리 위임
		
		InetAddress address = InetAddress.getLocalHost(); //예외발생
		System.out.println("로컬 호스트 이름 : " + address.getHostName());
		System.out.println("로컬 호스트 IP 주소 : "+ address.getHostAddress());
		
		address = InetAddress.getByName("www.naver.com"); //예외발생
		System.out.println("로컬 호스트 이름 : " + address.getHostName());
		System.out.println("로컬 호스트 IP 주소 : "+ address.getHostAddress());
		
		byte[] addr = new byte[4]; //210.89.164.90
		addr[0] = (byte)210;
		addr[1] = (byte)89;
		addr[2] = (byte)164;
		addr[3] = (byte)90;
		
		address = InetAddress.getByAddress(addr);
		System.out.println("naver 호스트 이름 : "+ address.getCanonicalHostName());
		System.out.println("naver 호스트 이름 : " + address.getHostName());
		System.out.println("naver 호스트 IP 주소 : "+ address.getHostAddress());
		
		InetAddress[] arr;
		arr = InetAddress.getAllByName("www.google.com");
		for( InetAddress item : arr ) {
			System.out.println("google 호스트 이름 : " + item.getHostName());
			System.out.println("google 호스트 IP 주소 : "+ item.getHostAddress());
		}
	}
}















