package ex03.net;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class URLEX2 {
	public static void main(String[] args) 
				throws MalformedURLException, IOException { //����ó�� ����
		
		URL url = new URL("https://www.google.com/search?ei=yVMDXZdKgpSYBZTvjFA&q=kim+yuna&oq=kim&gs_l=psy-ab.3.0.0i67j0l2j0i131j0l6.12395.13828..15013...0.0..0.96.363.4......0....1..gws-wiz.....0.zBvMD60eKyM"); //���ܹ߻�
		
		System.out.println("�������� : +"+url.getProtocol());
		System.out.println("ȣ��Ʈ�� ��Ʈ : +"+url.getAuthority());
		System.out.println("ȣ��Ʈ : +"+url.getHost());
		System.out.println("��Ʈ : +"+url.getPort());
		System.out.println("��� : +"+url.getPath());
		System.out.println("���� : +"+url.getQuery());
		System.out.println("���ϸ� : +"+url.getFile());
		System.out.println("���� : +"+url.getRef());
		
		
		
	}
}






