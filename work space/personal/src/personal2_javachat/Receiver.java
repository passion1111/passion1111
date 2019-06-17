package personal2_javachat;

import java.io.DataInputStream;
import java.net.Socket;

public class Receiver implements Runnable{

    Socket socket;
    DataInputStream in;
    String name;
    User user = new User();

    public Receiver(User user,Socket socket) throws Exception
    {
        this.user = user;
        this.socket = socket;
        //������ Client�κ��� �����͸� �о���̱� ���� DataInputStream ����
        in = new DataInputStream(socket.getInputStream());
        //���� ����ڷκ��� �г����� �о����
        this.name = in.readUTF();
        //����� �߰����ݴϴ�.
        user.AddClient(name, socket);
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