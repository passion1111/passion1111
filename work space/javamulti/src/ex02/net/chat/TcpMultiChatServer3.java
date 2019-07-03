package ex02.net.chat;
import java.io.*;
import java.net.*;
import java.util.*;

import ex02.net.chat.TcpMultiChatClient.ClientReciever;
import ex02.net.chat.TcpMultiChatClient.ClientSender;
import ex02.net.chat.TcpMultiChatServer2.ServerReceiver;

public class TcpMultiChatServer3 implements Runnable{
	ServerSocket ss = null;  //socket 1
	ServerSocket ss2 = null;
	Socket s = null; //socket 2
	Socket s2 = null; 
	
	
	
	public TcpMultiChatServer3() { //�������Լ�

	
	}
	
	public void start() {
		
		try {
			ss = new ServerSocket(7999);
			System.out.println("7999���� ���� �Ǿ����ϴ�.");
			
			while(true) {
				s = ss.accept();
//				s2=ss2.accept();
				
				if(s!=null) {ServerReceiver thread = new ServerReceiver(s); 
				thread.start();}//user class
				 //
				
			}
		} catch (Exception e) {	e.printStackTrace(); }
	} // start() end
	

	
//	try {
//		while(true) {
//		String ip = "127.0.0.1";  //127.0.0.1
//		Socket s = new Socket(ip, 7999);
//		System.out.println("������ ����Ǿ����ϴ�.");
//		Thread send = new Thread(new ClientSender(s)); // inner class
//		Thread reciever = new Thread(new ClientReciever(s));
//		send.start();			reciever.start();
//		int a=sc.nextInt();
		
	


static class ClientSender extends Thread { //inner class
	Socket s3;
	DataOutputStream dos;
	DataInputStream dis;
	
	
	public ClientSender(Socket s) { 
		this.s3 = s3;
		try {
			dos = new DataOutputStream(s3.getOutputStream());
			
		} catch (Exception e) {	e.printStackTrace(); }
	}

	@Override
	public void run() {
		try {
			String a="aa";
			while( dos != null ) {dos.writeUTF("d");
			
			}
			s3.close();
		} catch (Exception e) {	e.printStackTrace(); }
		
	}
}// ClientSender class end


	
	

	
	
	class ServerReceiver extends Thread { // inner class
		Socket s; //Ŭ���̾�Ʈ ����
		DataInputStream dis;
		DataOutputStream dos;
		String name = "";
		
		public ServerReceiver(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream()); //��Ʈ��ũ�� ���ؼ� �б�
				
				dos = new DataOutputStream(s.getOutputStream()); //��Ʈ��ũ�� ���ؼ� ����
//			} catch (Exception e) {	e.printStackTrace(); }
			} catch (Exception e) {	System.out.println("���� ���ú� ����!!"); }
		} //constructor end

		@Override
		public void run() { //������ ������(�����)
			
			try {
				
				//System.out.println(dos.toString().hashCode());
				String a=null;
				
				if( dis != null ) {
					do{
						
				System.out.println(dis.readUTF());
				System.out.println(s.getPort());
				
//				���� ������ ��Ʈ��ȣ�� Ȯ�� ss.getlocalport�� ���� ��ȣ�� �ƴϸ� �����ϰԲ��� ����.
//					System.out.println(ss.getLocalPort());
					
					//�ٸ� ������ ���� ������.
//					Socket Socket3=new Socket("127.0.0.1",8000);
//					
//					dos = new DataOutputStream(Socket3.getOutputStream());
//					dos.writeUTF("�������� 8000��Ʈ");
//					Socket3.close();
//					Thread send = new Thread(new ClientSender(Socket3));
//					send.start();
					
					}while(dis==null);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			} //try end
		} //run() end
		
	} //ServerReceiver class end
	
	
	public static void main(String[] args) {
		Thread a=new Thread(new TcpMultiChatServer3());
//		a.start();
		
		new TcpMultiChatServer3().start();
	}

	@Override
	public void run() { //���ʺ�
		
			
			try {
				ss2= new ServerSocket(8000);
				System.out.println("8000���� ���� �Ǿ����ϴ�.");
				
				while(true) {
					s2 = ss2.accept();
//					s2=ss2.accept();
					
					if(s2!=null) {ServerReceiver thread = new ServerReceiver(s2); 
					thread.start();}//user class
					 //
					
				}
			} catch (Exception e) {	e.printStackTrace(); }
		} // start() end
		
	}





