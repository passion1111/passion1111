package ex02.net.chat1;
import java.io.*;
import java.net.*;
import java.util.*;

public class TcpMultiChatClient {
	public static void main(String[] args) {
		
		
		try {
			String ip = "127.0.0.1";  //127.0.0.1
			Socket s = new Socket(ip, 7999);
			System.out.println("������ ����Ǿ����ϴ�.");
			Thread send = new Thread(new ClientSender(s)); // inner class
			
			send.start();			
		} catch (Exception e) {e.printStackTrace();}
	}//end main
	
	static class ClientSender extends Thread { //inner class
		Socket s;
		DataOutputStream dos;
		
		
		public ClientSender(Socket s) { 
			this.s = s;
			try {
				
				
			} catch (Exception e) {	e.printStackTrace(); }
		}

		@Override
		public void run() {
			Scanner sc = new Scanner(System.in); //Ű����κ��� �Է� �ޱ�
			try {
				while(true) {
				dos = new DataOutputStream(s.getOutputStream());
				String a="aa";
				
				}
			} catch (Exception e) {	e.printStackTrace(); }
		}
	}// ClientSender class end
	
	
	} // ClientReciever class end






