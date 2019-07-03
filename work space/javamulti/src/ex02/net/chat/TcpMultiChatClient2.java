package ex02.net.chat;
import java.io.*;
import java.net.*;
import java.util.*;

public class TcpMultiChatClient2 {
	public static void main(String[] args) {
		
		
		try {
			String ip = "127.0.0.1";  //127.0.0.1
			Socket s = new Socket(ip, 8000);
			System.out.println("������ ����Ǿ����ϴ�.");
			Thread send = new Thread(new ClientSender(s)); // inner class
			Thread reciever = new Thread(new ClientReciever(s));
			send.start();			reciever.start();
		} catch (Exception e) {e.printStackTrace();}
	}//end main
	
	static class ClientSender extends Thread { //inner class
		Socket s;
		DataOutputStream dos;
		
		
		public ClientSender(Socket s) { 
			this.s = s;
			try {
				dos = new DataOutputStream(s.getOutputStream());
				
			} catch (Exception e) {	e.printStackTrace(); }
		}

		@Override
		public void run() {
			try {
				String a="aa";
				while( dos != null ) dos.writeUTF("d");
			} catch (Exception e) {	e.printStackTrace(); }
		}
	}// ClientSender class end
	
	static class ClientReciever extends Thread { //inner class
		Socket s;
		DataInputStream dis;
		
		public ClientReciever(Socket s) { //�Ű����� 2�� �������Լ�
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
			} catch (Exception e) {	e.printStackTrace(); }
		}

		@Override
		public void run() {
			while( dis != null ) {
				try {
//					System.out.println(dis.readUTF());
				} catch (Exception e) {	e.printStackTrace(); }
			}//end while
		} // run() end		
	} // ClientReciever class end
}







