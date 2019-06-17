package ex01.net.tcp;

import java.net.*;
import java.util.zip.InflaterInputStream;
import java.io.*;

public class ClientEx {
	public static void main(String[] args) {
		BufferedReader br = null, stin = null;
		BufferedWriter bw = null;
		Socket client = null;  //socket 1
		
		try {
			client = new Socket("10.10.10.194", 9999); // 127.0.0.1 or 192.168.0.14\
			br = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			stin = new BufferedReader(new InputStreamReader(System.in));
			//출력 스트림
			bw = new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream()));
			String outputMessage;
			while(true) {
				System.out.println("message input : ");
				outputMessage = stin.readLine();
				
				if( outputMessage.equalsIgnoreCase("exit")) {
					bw.write(outputMessage);
					bw.flush();
					break;
				}//if end
				
				//키보드에서 읽은 문자열 전송
				bw.write("클라이언트 > " + outputMessage + "\n");
				bw.flush();
				
				String inputMessage = br.readLine();
				System.out.println(inputMessage);
			} //end while
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				client.close();	
			} catch (IOException e) {
				System.out.println("Server와 채팅 중 오류 발생....");
			}
		} // try end
	}
}






