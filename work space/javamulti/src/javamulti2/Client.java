package javamulti2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] arg)
    {
        Socket socket = null;            //Server�� ����ϱ� ���� Socket
        DataInputStream in = null;        //Server�κ��� �����͸� �о���̱� ���� �Է½�Ʈ��
        BufferedReader in2 = null;        //Ű����κ��� �о���̱� ���� �Է½�Ʈ��

        DataOutputStream out = null;    
        
        try {

            socket = new Socket("127.0.0.1",7000);    //������ ����
            
            in = new DataInputStream(socket.getInputStream());            
            in2 = new BufferedReader(new InputStreamReader(System.in)); 
            out = new DataOutputStream(socket.getOutputStream());        

            //ä�ÿ� ��� �� �г����� �Է¹���
            System.out.print("�г����� �Է����ּ��� : ");
            String data = in2.readLine();            
            
            //������ �г����� ����
            out.writeUTF(data);               
            //����ڰ� ä�� ������ �Է� �� ������ �����ϱ� ���� ������ ���� �� ����
            Thread th = new Thread(new Send(out));
            th.start();
        }catch(IOException e) {}
        try {
            //Ŭ���̾�Ʈ�� ���� ������� �����κ��� ������ �о���̴� �͸� �ݺ�.
            while(true)
            {
            	if(socket.getPort()<7100) {
            		if(in.read()!=-1) {
            			Send 
            		}
            	}
                String str2 = in.readUTF();        
                System.out.println(str2);
            }
        }catch(IOException e) {}
    }
}