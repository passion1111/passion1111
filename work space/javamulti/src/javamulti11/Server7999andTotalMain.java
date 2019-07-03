package javamulti11;
import java.io.*;
import java.net.*;
import java.util.*;


public class Server7999andTotalMain implements Runnable {
	ServerSocket ss = null;  //socket 1
	ServerSocket ss2 = null;
	Socket s = null; //socket 2
	Socket s2 = null; 
	
	
	
	public Server7999andTotalMain() { //생성자함수

	
	}
	
	
	

	

		
	


static class ClientSender extends Thread { //inner class
	Socket s3;
	DataOutputStream dos;
	DataInputStream dis;
	
	DataOutputStream dos2;
	DataInputStream dis2;
	
	
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
		
		DataOutputStream dos2;
		DataInputStream dis2;
		
		
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
					Socket Socket3=new Socket("127.0.0.1",8000);
//					
					Socket Socket4=new Socket("127.0.0.1",8001);
					
					dos = new DataOutputStream(Socket3.getOutputStream());
					dos2= new DataOutputStream(Socket4.getOutputStream());
					dos.writeUTF("7999서버에서 8000포트");
					dos2.writeUTF("7999서버에서 8001포트");
					Socket3.close();
					Socket4.close();
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
		Thread Server7999=new Thread(new Server7999andTotalMain());
		Server7999.start();
		Thread Server8000=new Thread(new Server8000());
		
		Thread Server8001=new Thread(new Server8001());
//		new TcpMultiChatServer3().start();
		
		Server8000.start();
		Server8001.start();
	}

	@Override
	public void run() {
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
		
	}

}




