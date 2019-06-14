package ex03.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainEntry {
	public static void main(String[] args) {
		
		String host ="10.10.10.174";
		
		try {
			InetAddress[] address =InetAddress.getAllByName(host);
			
			for (InetAddress item : address ) {
				System.out.println(item.getCanonicalHostName());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
