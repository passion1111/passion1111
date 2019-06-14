package ex02.net.tcp;
import java.io.*;
import java.net.*;

public class ServerTest {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s = null;
		System.out.println("Server Start~~~");
		
		try {
			ss = new ServerSocket(9000);
			s = ss.accept(); // client socket, 응답대기
			// I/O
			InputStream is = s.getInputStream(); //read
			OutputStream os = s.getOutputStream(); //write
			
			byte[] arr = new byte[100];
			is.read(arr);
			System.out.println(new String(arr));
			String msg = "안녕....Client~~~";
			os.write(msg.getBytes());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { 
				s.close(); ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}








