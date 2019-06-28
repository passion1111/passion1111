package ex01.net.tcp;

import java.net.*;
import java.io.*;

public class ServerEx {
	public static void main(String[] args) {
		BufferedReader br = null, stin = null;
		BufferedWriter bw = null;
		ServerSocket server = null;  // socket 1
		Socket client = null;  //socket 2
		
		System.out.println("�����......���� ������~~~");
		try {
			server = new ServerSocket(9999);
			client = server.accept();  //������, Ŭ���̾�Ʈ ����
			
			br = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			
			//Ű����κ��� �Է� ��Ʈ��
			stin = new BufferedReader(new InputStreamReader(System.in));
			//Ŭ���̾�Ʈ���� ��� ��Ʈ��
			bw = new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream()));
			
			String inputMessage;
			while(true) {
				inputMessage = br.readLine(); //Ŭ���̾�Ʈ���� ������ ���ڿ� ����
				//Ŭ���̾�Ʈ�� "EXIT"�� ������ ���� ����
				if( inputMessage.equalsIgnoreCase("exit")) break;
				//Ŭ���̾�Ʈ�� ���� �޼��� ȭ�� ���
				System.out.println(inputMessage); 
				//Ű���忡�� �� ���� ���ڿ� ����
				String outputMessage = stin.readLine();
				//Ű���忡�� ���� ���ڿ� ����
				bw.write("kingsmile���� > " + outputMessage + "\n");
				bw.flush();
			}//while end
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				client.close();			server.close();
			} catch (IOException e) {
				System.out.println("Ŭ���̾�Ʈ�� ä�� �� ���� �߻�....");
			}
			
		} //try end
	}
}












