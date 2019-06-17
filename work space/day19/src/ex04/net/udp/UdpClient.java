package ex04.net.udp;
import java.io.*;
import java.net.*;

public class UdpClient {
	private final static int PACKTSIZE=100;
	
		public static void main(String[] args) {
			if(args.length!=2) {
				System.out.println("using:DAtagramServer host, port number:");//host ipaddress
				return; //Á¦¾î±Ç ³Ñ±è 
			}
			DatagramSocket ds=null;
			try {
				InetAddress host=InetAddress.getByName(args[0]);
				int port= Integer.parseInt(args[1]);
				
				ds=new DatagramSocket();
				byte[] data="Hello Server bitcamp129 udp test".getBytes();
				DatagramPacket dp=new DatagramPacket(data, data.length,host,port);
				
				ds.send(dp);
				
				ds.setSoTimeout(2000);
				dp.setData(new byte[PACKTSIZE]);
				
				System.out.println(new String(dp.getData()));

			
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				if(ds!=null)ds.close();
			}
		}
}
