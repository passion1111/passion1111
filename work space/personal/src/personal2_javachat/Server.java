package personal2_javachat;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String arg[])
    {
        //������ Client�� ����ϱ� ���� Socket
        Socket socket = null;    
        //ä�ù濡 ������ �ִ� Client ���� ��ü                
        User user = new User();        
        //Client ������ �ޱ� ���� ServerSocket            
        ServerSocket server_socket=null;              
        
        int count = 0;                            
        Thread thread[]= new Thread[10];             
        
        try {
            server_socket = new ServerSocket(7000);
            //Server�� ���ξ������ �Լ��ؼ� ������� ������ ����
            while(true)
            {
                socket = server_socket.accept();

                thread[count] = new Thread(new Receiver(user,socket));
                thread[count].start();
                count++;
            }
        }catch(Exception e) {};
    }
}