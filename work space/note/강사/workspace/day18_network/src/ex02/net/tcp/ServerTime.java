package ex02.net.tcp;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// Server - socket 2개
public class ServerTime {
	public static void main(String[] args) {
		int port = 7000;  // 0~1024 예약됨
		
		try {
			System.out.println("강사컴 server Start!!!");
			ServerSocket ss = new ServerSocket(port); // socket 1
			
			while(true) {
				Socket s = ss.accept(); // socket 2
				OutputStream os = s.getOutputStream(); //net 통해서 출력함
				ObjectOutputStream oos = new ObjectOutputStream(os);
				
				oos.writeObject(new Date()); // 서버측 날짜를...
				oos.flush();
				s.close();
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}








