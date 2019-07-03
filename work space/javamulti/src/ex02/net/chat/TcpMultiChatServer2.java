package ex02.net.chat;
import java.io.*;
import java.net.*;
import java.util.*;

public class TcpMultiChatServer2 {
	ServerSocket ss = null;  //socket 1
	Socket s = null; //socket 2
	
	public TcpMultiChatServer2() { //�������Լ�

	
	}
	
	public void start() {
		
		try {
			ss = new ServerSocket(7999);
			System.out.println("���� ���� �Ǿ����ϴ�.");
			
			while(true) {
				s = ss.accept();
				ServerReceiver thread = new ServerReceiver(s); //user class
				thread.start(); //
			}
//		} catch (Exception e) {	e.printStackTrace(); }
		} catch (Exception e) {	System.out.println("���� ���� ����!!"); } 
	} // start() end
	
	
	
	

	
	
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





