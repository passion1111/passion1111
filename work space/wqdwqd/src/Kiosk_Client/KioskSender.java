package Kiosk_Client;

import java.io.*;
import java.net.*;
import java.util.*;
public class KioskSender {

	

	
		

		public static void KioskSender() {//������ �ϰ��� ������ ���´�.
			
			try {
				String ip = "127.0.0.1";  
				Socket s = new Socket(ip, 7999);
				System.out.println("������ ����Ǿ����ϴ�.");
				
				
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








