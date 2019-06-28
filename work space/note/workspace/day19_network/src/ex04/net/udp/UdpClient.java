package ex04.net.udp;
import java.io.*;
import java.net.*;

public class UdpClient {
	private final static int PACKTSIZE = 100;
	
	public static void main(String[] args) {
		
		if( args.length != 2 ) {
			System.out.println("using: DatagrameServer host, port number :");
			return;  //제어권 넘김
		}
		
		DatagramSocket ds = null;
		try {
			InetAddress host = InetAddress.getByName(args[0]); //서버 IP
			int port = Integer.parseInt(args[1]); // server port number
			
			ds = new DatagramSocket();
			byte[] data ="Hello Server BitCamp 129 UDP test 32482938429348".getBytes();
			DatagramPacket dp = new DatagramPacket(
							data, data.length, host, port);
			
			ds.send(dp);
			
			ds.setSoTimeout( 2000 );
			dp.setData(new byte[PACKTSIZE]);
			
			System.out.println(new String(dp.getData()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if( ds != null ) ds.close();
		}
	}
}










