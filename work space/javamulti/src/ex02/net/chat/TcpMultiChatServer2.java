package ex02.net.chat;
import java.io.*;
import java.net.*;
import java.util.*;

public class TcpMultiChatServer2 {
	ServerSocket ss = null;  //socket 1
	ServerSocket ss2 = null;
	Socket s = null; //socket 2
	Socket s2 = null; 
	
	
	
	public TcpMultiChatServer2() { //생성자함수

	
	}
	
	public void start() {
		
		try {
			ss = new ServerSocket(7999);
			ss2= new ServerSocket(8000);
			System.out.println("서버 시작 되었습니다.");
			
			while(true) {
				s = ss.accept();
//				s2=ss2.accept();
				
				if(s!=null) {ServerReceiver thread = new ServerReceiver(s); 
				thread.start();}//user class
				 //
				
			}
		} catch (Exception e) {	e.printStackTrace(); }
	} // start() end
	

	
	
	
	
	

	
	
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
					}while(dis==null);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			} //try end
		} //run() end
		
	} //ServerReceiver class end
	
	
	public static void main(String[] args) {
		
		new TcpMultiChatServer2().start();
	}

}





