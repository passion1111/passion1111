package ex04.tcp;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

//Server-socket 1��
public class Client_time {
	public static void main(String[] args) {
	
			String serverIP="10.10.10.174";//127.0.0.1
			int port=7000;
			Date date=null;
			try {
				Socket client =new Socket(serverIP,port);
				InputStream is=client.getInputStream();
				ObjectInputStream ois=new ObjectInputStream(is);
				System.out.println("Server�� ��¥/�ð�Ȯ��..����� Ŭ���̾�Ʈ�Դϴ� \n\n");

				date=(Date)ois.readObject();
				System.out.println("����ð�:"+date+"�Դϴ�");
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	
}
