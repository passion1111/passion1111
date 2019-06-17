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
			System.out.println("전송 대상( server ip ) = ");
			String ipAddress = br.readLine(); // 10.10.10.194
			System.out.println("전송 파일(파일명.확장자) = ");
			String fileName = br.readLine();
			
			File file = new File(fileName);
			
			if( !file.exists() ) {
				System.out.println("파일이 존재하지 않습니다.");
				System.exit(0);
			}//end if
			
			ds = new DatagramSocket();
			InetAddress ip = InetAddress.getByName(ipAddress);
			str = "start";
			b = str.getBytes();
			
			dp = new DatagramPacket(b, b.length, ip, port);
			ds.send(dp); //송신...
			
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


/*package ex03.net.udp;
import java.io.*;
import java.net.*;

public class DatagramClient {
	
	
	public static void main(String[] args) {
		DatagramPacket dp=null;
		DatagramSocket ds=null;
		DataInputStream dis=null;
		BufferedReader br=null;
		
		int port=5000;
		String str;
		byte[] b;
		try {
			System.out.println("@@@@@file udp client @@@");
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("전송 대상(server ip)=");//웹을통해서 오고가는건 무조건 txt 스트링으로 보내야함. 
			String ipAddress =br.readLine();//10.10.10.174 스트링이니 실제 ip주소로 바꿔줘야함
					System.out.println("전송파일(파일명,확장자)");
					String fileName=br.readLine();
					
					File file=new File(fileName);
					if(!file.exists()) {//파일이 있다면 boolean데이터형
						System.out.println("파일이 존재하지 않습니다");
						System.exit(0);
						
					}//end if
					ds =new DatagramSocket();
					InetAddress ip=InetAddress.getByName(ipAddress);//실제 ip주소로 바꿔줌
					str="start";
					b=str.getBytes();
					dp=new DatagramPacket(b, b.length,ip,port);
					ds.send(dp);//송신
					
					dis=new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
					
					b=new byte[65536];
					
					while(true) {
						int count=dis.read(b,0,b.length);
						
						if(count==-1)break;
						dp=new DatagramPacket(b, b.length,ip,port);
						ds.send(dp);
					}//파일 읽어오는 부분
					
					str = "end";
					b = str.getBytes();
					
					dp = new DatagramPacket(b, b.length, ip, port);
					ds.send(dp);
					
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {	br.close(); dis.close();} catch (IOException e) {e.printStackTrace();	} 
			
		}
	}
}
*/