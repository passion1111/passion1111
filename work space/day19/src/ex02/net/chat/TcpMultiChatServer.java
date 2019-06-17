package ex02.net.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class TcpMultiChatServer {
	HashMap clients;//key,value
	public TcpMultiChatServer() {//�������Լ�
		clients=new HashMap();//�ؽ��� ��ü����
		Collections.synchronizedMap(clients);//����ȭ
		
		
	}
	public void start() {
		ServerSocket ss=null;//socket1
		Socket s=null;//socket2
		
		try {
			ss=new ServerSocket(9999);
			System.out.println("���� ���� �ƽ��ϴ�");
			
			while(true) {
				s=ss.accept();
				System.out.println("["+s.getInetAddress()+":"+s.getPort()+"]���� �����ϼ̽��ϴ�"); //getInetAddress IP�ּ� port ��Ʈ��ȣ �˾ƿͼ� ��� �����ߴ��� Ȯ��
				ServerReceiver thread=new ServerReceiver(s);//�����Ŭ������
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//start end
	
	public void sendToAll(String msg) {//user method
		Iterator it=clients.keySet().iterator();//Ű �� ���
		
		while(it.hasNext()) {//��Ұ� �ִٸ�.
			try {
				DataOutputStream dos=(DataOutputStream)clients.get(it.next());//get�� ������ƮŸ���ε� �׳ɹ޾ƿͼ� ������ ����ȯ
				dos.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}//sendToAll()end
	
	
	class ServerReceiver extends Thread{//inner class
		Socket s;//Ŭ���̾�Ʈ����
		DataInputStream dis;
		DataOutputStream dos;//���� dos�� try�ȿ� �־ �浹�̾ȳ� �� try�� ����¼��� �������
		public ServerReceiver(Socket s) {
			this.s=s;
			try {
				dis=new DataInputStream(s.getInputStream());//��Ʈ��ũ ���ؼ� �б�
				dos=new DataOutputStream(s.getOutputStream());//��Ʈ��ũ ���ؼ�  ����
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}//������ end

		@Override
		public void run() {//������ Ŭ������ ��⋚����  run�ʿ�,������ �����
			String name="";
			try {
				name=dis.readUTF();
				sendToAll("#"+name+"���� �����ϼ̽��ϴ�");//������ �޼ҵ�
				
				System.out.println(dos.toString().hashCode());
				clients.put(name, dos);//hashmap�ֱ�
				System.out.println("���� ���� ������ ����:"+clients.size()+"�Դϴ�");//�����ڼ�Ȯ��
				
				while(dis!=null) {
					sendToAll(dis.readUTF());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
//				sendToAll("#"+name+"���� �����ϼ̽��ϴ�.");//������ �޼ҵ�
				clients.remove(name);//������ �� ����
				System.out.println("["+s.getInetAddress()+":"+s.getPort()+"]���� ���������ϼ̽��ϴ�"); //getInetAddress IP�ּ� port ��Ʈ��ȣ �˾ƿͼ� ��� �����ߴ��� Ȯ��
				System.out.println("���� ���� ������ ����:"+clients.size()+"�Դϴ�");//�����ڼ�Ȯ��
				
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new TcpMultiChatServer().start();
	}
}
