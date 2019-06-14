package ex03.net;
import java.net.*;

public class MainEntry2 {
	public static void main(String[] args) 
						throws UnknownHostException { //����ó�� ����
		
		InetAddress address = InetAddress.getLocalHost(); //���ܹ߻�
		System.out.println("���� ȣ��Ʈ �̸� : " + address.getHostName());
		System.out.println("���� ȣ��Ʈ IP �ּ� : "+ address.getHostAddress());
		
		address = InetAddress.getByName("www.naver.com"); //���ܹ߻�
		System.out.println("���� ȣ��Ʈ �̸� : " + address.getHostName());
		System.out.println("���� ȣ��Ʈ IP �ּ� : "+ address.getHostAddress());
		
		byte[] addr = new byte[4]; //210.89.164.90
		addr[0] = (byte)210;
		addr[1] = (byte)89;
		addr[2] = (byte)164;
		addr[3] = (byte)90;
		
		address = InetAddress.getByAddress(addr);
		System.out.println("naver ȣ��Ʈ �̸� : "+ address.getCanonicalHostName());
		System.out.println("naver ȣ��Ʈ �̸� : " + address.getHostName());
		System.out.println("naver ȣ��Ʈ IP �ּ� : "+ address.getHostAddress());
		
		InetAddress[] arr;
		arr = InetAddress.getAllByName("www.google.com");
		for( InetAddress item : arr ) {
			System.out.println("google ȣ��Ʈ �̸� : " + item.getHostName());
			System.out.println("google ȣ��Ʈ IP �ּ� : "+ item.getHostAddress());
		}
	}
}















