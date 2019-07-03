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
	
	
	
	public TcpMultiChatServer3() { //생성자함수

	
	}
	
	public void start() {
		
		try {
			ss = new ServerSocket(7999);
			System.out.println("7999서버 시작 되었습니다.");
			
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
//		System.out.println("서버에 연결되었습니다.");
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
		Socket s; //클라이언트 소켓
		DataInputStream dis;
		DataOutputStream dos;
		String name = "";
		
		public ServerReceiver(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream()); //네트워크를 통해서 읽기
				
				dos = new DataOutputStream(s.getOutputStream()); //네트워크를 통해서 쓰기
//			} catch (Exception e) {	e.printStackTrace(); }
			} catch (Exception e) {	System.out.println("서버 리시브 실패!!"); }
		} //constructor end

		@Override
		public void run() { //스레드 구현부(실행부)
			
			try {
				
				//System.out.println(dos.toString().hashCode());
				String a=null;
				
				if( dis != null ) {
					do{
						
				System.out.println(dis.readUTF());
				System.out.println(s.getPort());
				
//				현재 서버의 포트번호를 확인 ss.getlocalport가 일정 번호가 아니면 생성하게끔도 가능.
//					System.out.println(ss.getLocalPort());
					
					//다른 서버로 정보 보내기.
//					Socket Socket3=new Socket("127.0.0.1",8000);
//					
//					dos = new DataOutputStream(Socket3.getOutputStream());
//					dos.writeUTF("서버에서 8000포트");
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
	public void run() { //러너블
		
			
			try {
				ss2= new ServerSocket(8000);
				System.out.println("8000서버 시작 되었습니다.");
				
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





