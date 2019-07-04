package Kiosk_Client;

import java.io.*;
import java.net.*;
import java.util.*;
public class KioskSender {

	

	
		

		public static void KioskSender() {//연결을 하고나서 소켓을 끊는다.
			
			try {
				String ip = "127.0.0.1";  
				Socket s = new Socket(ip, 7999);
				System.out.println("서버에 연결되었습니다.");
				
				
				DataOutputStream dos;
				
					dos = new DataOutputStream(s.getOutputStream());
					String aa="aa";
					if( dos != null ) { 
						
						dos.writeUTF(aa);
					
					
					}
					s.close();
				
			
				
			} catch (Exception e) {e.printStackTrace();}
			
			
		}
	}








