package personal2_javachat;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class User {
    
    HashMap<String,DataOutputStream> clientmap 
                                             = new HashMap<String,DataOutputStream>(); 

    public synchronized void AddClient(String name,Socket socket) 
    {                                                                        
        try {
            sendMsg(name+" �����ϼ̽��ϴ�.","Server");
            clientmap.put(name, new DataOutputStream(socket.getOutputStream()));
            System.out.println("ä�� ���� �ο� : "+clientmap.size());
        }catch(Exception e){}

    }
    public synchronized void RemoveClient(String name)  
    {
        try {
            clientmap.remove(name);
            sendMsg(name + " �����ϼ̽��ϴ�.", "Server");
            System.out.println("ä�� ���� �ο� : "+clientmap.size());
        }catch(Exception e) {}
    }

    public synchronized void sendMsg(String msg, String name)throws Exception 
    {
        Iterator iterator = clientmap.keySet().iterator();
        while(iterator.hasNext())
        {
            String clientname =(String)iterator.next();
            clientmap.get(clientname).writeUTF(name + ":" + msg);
        }
    }
}