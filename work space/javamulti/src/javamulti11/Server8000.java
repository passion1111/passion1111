package javamulti11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server8000 implements Runnable {
	
		ServerSocket ss = null;  //socket 1
		ServerSocket ss2 = null;
		Socket s = null; //socket 2
		Socket s2 = null; 
		
		
		
		public Server8000() { //생성자함수

		
		}
		
		

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
//				} catch (Exception e) {	e.printStackTrace(); }
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

					
					Socket Socket8001=new Socket("127.0.0.1",8001);
					dos=new DataOutputStream(Socket8001.getOutputStream());
					dos.writeUTF("8000포트에서 8001포트로");
						}while(dis==null);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
				} //try end
			} //run() end
			
		} //ServerReceiver class end
		
		
		

		@Override
		public void run() { //러너블
			
				
				try {
					ss2= new ServerSocket(8000);
					System.out.println("8000서버 시작 되었습니다.");
					
					while(true) {
						s2 = ss2.accept();
//						s2=ss2.accept();
						
						if(s2!=null) {ServerReceiver thread = new ServerReceiver(s2); 
						thread.start();}//user class
						 //
						
					}
				} catch (Exception e) {	e.printStackTrace(); }
			} // start() end
			
		}



