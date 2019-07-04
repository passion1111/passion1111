package javamulti2;




import java.io.DataInputStream;
import java.net.Socket;
	import java.io.DataOutputStream;
import java.net.ServerSocket;
	import java.net.Socket;

	public class Server {
		Socket s;
		ServerSocket ss;
		DataOutputStream dos;
		
		
		public void ServerSender(Socket s) { 
			this.s = s;
			try {
				dos = new DataOutputStream(s.getOutputStream());
				
				
				
			} catch (Exception e) {	e.printStackTrace(); }
		}
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
	    public static void main(String arg[])
	    {
	        //접속한 Client와 통신하기 위한 Socket
	        Socket socket = null;    
	        //채팅방에 접속해 있는 Client 관리 객체                
//	        User user = new User();        
	        //Client 접속을 받기 위한 ServerSocket            
	        ServerSocket server_socket=null;              
	        
	        int count = 0;                            
//	        Thread thread[]= new Thread[10];   //쓰레드풀          
	        
	        try {
	        	for (int i = 7000; i < 7010; i++) { //키오스크 전용 소켓
					server_socket=new ServerSocket(i);
				}
	        	
//	        	
//	            server_socket = new ServerSocket(7000);
//	            server_socket= new ServerSocket(7001);
	            //Server의 메인쓰레드는 게속해서 사용자의 접속을 받음
	            while(true)
	            {
	                socket = server_socket.accept();
	                if(socket.getPort()<7100&&socket.getPort()>=7000) {

	                	
	                	Thread a=new Thread();
		                	a.start();
	                	
	                }
	               

	            }
	        }catch(Exception e) {};
	    }
	}


	

	public class Receiver implements Runnable{

	    Socket socket;
	    DataInputStream in;
	    String name;
	    User user = new User();

	    public Receiver(Socket socket) throws Exception
	    {
	        this.socket = socket;
	        //접속한 Client로부터 데이터를 읽어들이기 위한 DataInputStream 생성
	        in = new DataInputStream(socket.getInputStream());
	        //최초 사용자로부터 닉네임을 읽어들임
	    }

	    public void run()
	    {
	        try
	        {
	            
	            while(true)
	            {
	                String msg = in.readUTF();
	                user.sendMsg(msg , name);
	            }
	        }catch(Exception e) {
	            
	            user.RemoveClient(this.name);
	        }        
	    }
	}
	
	
//	package ex02.net.chat;
//	import java.io.*;
//	import java.net.*;
//	import java.util.*;
//
//	public class TcpMultiChatServer {
//		HashMap clients;  // key, value
//		ServerSocket ss = null;  //socket 1
//		Socket s = null; //socket 2
//		
//		public TcpMultiChatServer() { //생성자함수
//			clients = new HashMap();  //HashMap 객체 생성
//			Collections.synchronizedMap(clients); //동기화
//		}
//		
//		public void start() {
//			
//			try {
//				ss = new ServerSocket(8000);
//				System.out.println("서버 시작 되었습니다.");
//				
//				while(true) {
//					s = ss.accept();
//					System.out.println("[" + s.getInetAddress() + ":" + s.getPort() + "] 에서 접속하였습니다.");
//					ServerReceiver thread = new ServerReceiver(s); //user class
//					thread.start(); //
//				}
////			} catch (Exception e) {	e.printStackTrace(); }
//			} catch (Exception e) {	System.out.println("서버 접속 실패!!"); } 
//		} // start() end
//		
////		public void close() {
////			name = name;
////			try {
////				sendToAll("#" + name + " 님이 나가셨습니다."); //user method
////				s.close();
////			} catch (IOException e) {
////				e.printStackTrace();
////			}
////		}
//		
//		public void sendToAll(String msg) { //user method
//			Iterator it = clients.keySet().iterator(); // key값 출력
//			
//			while( it.hasNext() ) { // 요소가 있다면...
//				
//				try {
//					DataOutputStream dos = (DataOutputStream)clients.get(it.next());
//					dos.writeUTF(msg);
//				} catch (IOException e) {e.printStackTrace();}
//			}// end while	
//		} //sendToAll() end	
//		
//		class ServerReceiver extends Thread { // inner class
//			Socket s; //클라이언트 소켓
//			DataInputStream dis;
//			DataOutputStream dos;
//			String name = "";
//			
//			public ServerReceiver(Socket s) {
//				this.s = s;
//				try {
//					dis = new DataInputStream(s.getInputStream()); //네트워크를 통해서 읽기
//					dos = new DataOutputStream(s.getOutputStream()); //네트워크를 통해서 쓰기
////				} catch (Exception e) {	e.printStackTrace(); }
//				} catch (Exception e) {	System.out.println("서버 리시브 실패!!"); }
//			} //constructor end
//
//			@Override
//			public void run() { //스레드 구현부(실행부)
//				
//				try {
//					name = dis.readUTF();
//					sendToAll("#" + name + " 님이 입장하셨습니다."); //user method
//					
//					//System.out.println(dos.toString().hashCode());
//					clients.put(name, dos); // HashMap 넣기
//					System.out.println("현재 서버 접속자 수는 : " + clients.size() + " 입니다."); //접속자 수 확인
//					
//					while( dis != null ) {
//						sendToAll(dis.readUTF());
//					}
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					sendToAll("#" + name + " 님이 나가셨습니다."); //user method
//					clients.remove(name); //접속자 수 제거
//					System.out.println("[" + s.getInetAddress() + ":" + s.getPort() + "] 에서 접속 종료하셨습니다.");
//					System.out.println("현재 서버 접속자 수는 : " + clients.size() + " 입니다."); //접속자 수 확인
//				} //try end
//			} //run() end
//			
//		} //ServerReceiver class end
//		
//		
//		public static void main(String[] args) {
//			
//			new TcpMultiChatServer().start();
//		}
//
//	}






	