package javamulti1;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server8001 implements Runnable {
	
		ServerSocket ss = null;  //socket 1
		ServerSocket ss2 = null;
		Socket s = null; //socket 2
		Socket s2 = null; 
		
		
		
		public Server8001() { //�������Լ�

		
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
			Socket s; //Ŭ���̾�Ʈ ����
			DataInputStream dis;
			DataOutputStream dos;
			String name = "";
			
			public ServerReceiver(Socket s) {
				this.s = s;
				try {
					dis = new DataInputStream(s.getInputStream()); //��Ʈ��ũ�� ���ؼ� �б�
					
					dos = new DataOutputStream(s.getOutputStream()); //��Ʈ��ũ�� ���ؼ� ����
//				} catch (Exception e) {	e.printStackTrace(); }
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
					
//					���� ������ ��Ʈ��ȣ�� Ȯ�� ss.getlocalport�� ���� ��ȣ�� �ƴϸ� �����ϰԲ��� ����.
//						System.out.println(ss.getLocalPort());
						
						//�ٸ� ������ ���� ������.
//						Socket Socket3=new Socket("127.0.0.1",8000);
//						
//						dos = new DataOutputStream(Socket3.getOutputStream());
//						dos.writeUTF("�������� 8000��Ʈ");
//						Socket3.close();
//						Thread send = new Thread(new ClientSender(Socket3));
//						send.start();
						
						}while(dis==null);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
				} //try end
			} //run() end
			
		} //ServerReceiver class end
		
		
		

		@Override
		public void run() { //���ʺ�
			
				
				try {
					ss2= new ServerSocket(8001);
					System.out.println("8001���� ���� �Ǿ����ϴ�.");
					
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



