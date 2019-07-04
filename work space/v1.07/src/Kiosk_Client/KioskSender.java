package Kiosk_Client;

import java.io.*;
import java.net.*;
import java.util.*;
public class KioskSender {


	public static void KioskSender() {
			
		try {
			String ip = "127.0.0.1"; // 전송보낼 서버입력
			Socket s = new Socket(ip, 7999);

			DataOutputStream dos;

			dos = new DataOutputStream(s.getOutputStream());
			String aa = "aa";
			if (dos != null) {dos.writeUTF(aa);	}
			s.close();
			
		} catch (Exception e) {e.printStackTrace();}
	}
}



