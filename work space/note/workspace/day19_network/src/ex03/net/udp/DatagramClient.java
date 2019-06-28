package ex03.net.udp;
import java.io.*;
import java.net.*;

public class DatagramClient {
	public static void main(String[] args) {
		DatagramPacket dp = null;
		DatagramSocket ds = null;
		DataInputStream dis = null;
		BufferedReader br = null;
		
		int port = 5000;
		String str;
		byte[] b;
		
		try {
			System.out.println("@@@ File UDP Client @@@");
			br = new BufferedReader(
					new InputStreamReader(System.in));
			System.out.println("���� ���( server ip ) = ");
			String ipAddress = br.readLine(); // 10.10.10.194
			System.out.println("���� ����(���ϸ�.Ȯ����) = ");
			String fileName = br.readLine();
			
			File file = new File(fileName);
			
			if( !file.exists() ) {
				System.out.println("������ �������� �ʽ��ϴ�.");
				System.exit(0);
			}//end if
			
			ds = new DatagramSocket();
			InetAddress ip = InetAddress.getByName(ipAddress);
			str = "start";
			b = str.getBytes();
			
			dp = new DatagramPacket(b, b.length, ip, port);
			ds.send(dp); //�۽�...
			
			dis = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(file)));
			
			b = new byte[65536];
			
			while(true) {
				int count = dis.read(b, 0, b.length);
				
				if (count == -1 ) break;
				
				dp = new DatagramPacket(b, count, ip, port);
				ds.send(dp);
			} // while end
			
			str = "end";
			b = str.getBytes();
			
			dp = new DatagramPacket(b, b.length, ip, port);
			ds.send(dp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { br.close(); dis.close(); }catch (Exception e) { e.printStackTrace();}
		}//try end
	}
}








