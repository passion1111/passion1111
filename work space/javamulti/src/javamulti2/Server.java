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
	        //������ Client�� ����ϱ� ���� Socket
	        Socket socket = null;    
	        //ä�ù濡 ������ �ִ� Client ���� ��ü                
//	        User user = new User();        
	        //Client ������ �ޱ� ���� ServerSocket            
	        ServerSocket server_socket=null;              
	        
	        int count = 0;                            
//	        Thread thread[]= new Thread[10];   //������Ǯ          
	        
	        try {
	        	for (int i = 7000; i < 7010; i++) { //Ű����ũ ���� ����
					server_socket=new ServerSocket(i);
				}
	        	
//	        	
//	            server_socket = new ServerSocket(7000);
//	            server_socket= new ServerSocket(7001);
	            //Server�� ���ξ������ �Լ��ؼ� ������� ������ ����
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
	        //������ Client�κ��� �����͸� �о���̱� ���� DataInputStream ����
	        in = new DataInputStream(socket.getInputStream());
	        //���� ����ڷκ��� �г����� �о����
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
//		public TcpMultiChatServer() { //�������Լ�
//			clients = new HashMap();  //HashMap ��ü ����
//			Collections.synchronizedMap(clients); //����ȭ
//		}
//		
//		public void start() {
//			
//			try {
//				ss = new ServerSocket(8000);
//				System.out.println("���� ���� �Ǿ����ϴ�.");
//				
//				while(true) {
//					s = ss.accept();
//					System.out.println("[" + s.getInetAddress() + ":" + s.getPort() + "] ���� �����Ͽ����ϴ�.");
//					ServerReceiver thread = new ServerReceiver(s); //user class
//					thread.start(); //
//				}
////			} catch (Exception e) {	e.printStackTrace(); }
//			} catch (Exception e) {	System.out.println("���� ���� ����!!"); } 
//		} // start() end
//		
////		public void close() {
////			name = name;
////			try {
////				sendToAll("#" + name + " ���� �����̽��ϴ�."); //user method
////				s.close();
////			} catch (IOException e) {
////				e.printStackTrace();
////			}
////		}
//		
//		public void sendToAll(String msg) { //user method
//			Iterator it = clients.keySet().iterator(); // key�� ���
//			
//			while( it.hasNext() ) { // ��Ұ� �ִٸ�...
//				
//				try {
//					DataOutputStream dos = (DataOutputStream)clients.get(it.next());
//					dos.writeUTF(msg);
//				} catch (IOException e) {e.printStackTrace();}
//			}// end while	
//		} //sendToAll() end	
//		
//		class ServerReceiver extends Thread { // inner class
//			Socket s; //Ŭ���̾�Ʈ ����
//			DataInputStream dis;
//			DataOutputStream dos;
//			String name = "";
//			
//			public ServerReceiver(Socket s) {
//				this.s = s;
//				try {
//					dis = new DataInputStream(s.getInputStream()); //��Ʈ��ũ�� ���ؼ� �б�
//					dos = new DataOutputStream(s.getOutputStream()); //��Ʈ��ũ�� ���ؼ� ����
////				} catch (Exception e) {	e.printStackTrace(); }
//				} catch (Exception e) {	System.out.println("���� ���ú� ����!!"); }
//			} //constructor end
//
//			@Override
//			public void run() { //������ ������(�����)
//				
//				try {
//					name = dis.readUTF();
//					sendToAll("#" + name + " ���� �����ϼ̽��ϴ�."); //user method
//					
//					//System.out.println(dos.toString().hashCode());
//					clients.put(name, dos); // HashMap �ֱ�
//					System.out.println("���� ���� ������ ���� : " + clients.size() + " �Դϴ�."); //������ �� Ȯ��
//					
//					while( dis != null ) {
//						sendToAll(dis.readUTF());
//					}
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					sendToAll("#" + name + " ���� �����̽��ϴ�."); //user method
//					clients.remove(name); //������ �� ����
//					System.out.println("[" + s.getInetAddress() + ":" + s.getPort() + "] ���� ���� �����ϼ̽��ϴ�.");
//					System.out.println("���� ���� ������ ���� : " + clients.size() + " �Դϴ�."); //������ �� Ȯ��
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






	