package ex01.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.zip.InflaterInputStream;

public class MainEntry2 {
	public static void main(String[] args) {
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		
		String strUrl = null;
		InetAddress[] address;
		
		System.out.print("site address = ");
		
		
		try {
			strUrl = br.readLine(); //예외발생
			address =InetAddress.getAllByName(strUrl); //예외발생
			
			for (int i=0; i < address.length; i++ ) {
				System.out.println(address[i]);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
