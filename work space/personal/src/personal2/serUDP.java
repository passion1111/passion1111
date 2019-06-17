package personal2;
import java.net.*;

public class serUDP {
 
  public static void main(String[] args) {
     
    try{
      DatagramSocket dsoc = new DatagramSocket(7779);
       
      byte tex [] = new byte [512];
       
      DatagramPacket dp = new DatagramPacket(tex, tex.length);
       
      while(true){
      dsoc.receive(dp);
       
      System.out.println("송신 IP " +  dsoc.getInetAddress());
       
      String msg = new String(dp.getData(),"UTF-8");
      System.out.println("내용" + msg);
       
      }
    }catch(Exception e){System.out.println(e.getMessage());}
             
  }
 
}


