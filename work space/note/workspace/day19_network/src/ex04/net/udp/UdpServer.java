package ex04.net.udp;
import java.io.*;
import java.net.*;

public class UdpServer {
	private final static int PACKTSIZE = 100;
	
	public static void main(String[] args) {
		if( args.length != 1 ) {
			System.out.println("using: DatagrameServer port number :");
			return;  //Á¦¾î±Ç ³Ñ±è
		}
		
		try {
			int port = Integer.parseInt(args[0]);
			DatagramSocket ds = new DatagramSocket(port);
			System.out.println("The Server is ready.............");
			
			for(;;) {
				DatagramPacket dp = new DatagramPacket(
								new byte[PACKTSIZE], PACKTSIZE);
				ds.receive(dp);
				System.out.println(dp.getAddress() 
						+" " + dp.getPort() +" : " + new String(dp.getData()));
//				ds.send(dp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








