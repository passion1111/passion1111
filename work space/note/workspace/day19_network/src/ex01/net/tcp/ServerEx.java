package ex01.net.tcp;

import java.net.*;
import java.io.*;

public class ServerEx {
	public static void main(String[] args) {
		BufferedReader br = null, stin = null;
		BufferedWriter bw = null;
		ServerSocket server = null;  // socket 1
		Socket client = null;  //socket 2
		
		System.out.println("연결됨......나는 서버야~~~");
		try {
			server = new ServerSocket(9999);
			client = server.accept();  //응답대기, 클라이언트 소켓
			
			br = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			
			//키보드로부터 입력 스트림
			stin = new BufferedReader(new InputStreamReader(System.in));
			//클라이언트로의 출력 스트림
			bw = new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream()));
			
			String inputMessage;
			while(true) {
				inputMessage = br.readLine(); //클라이언트에서 한행의 문자열 읽음
				//클라이언트가 "EXIT"를 보내면 연결 종료
				if( inputMessage.equalsIgnoreCase("exit")) break;
				//클라이언트가 보낸 메세지 화면 출력
				System.out.println(inputMessage); 
				//키보드에서 한 행의 문자열 읽음
				String outputMessage = stin.readLine();
				//키보드에서 읽은 문자열 전송
				bw.write("kingsmile서버 > " + outputMessage + "\n");
				bw.flush();
			}//while end
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				client.close();			server.close();
			} catch (IOException e) {
				System.out.println("클라이언트와 채팅 중 오류 발생....");
			}
			
		} //try end
	}
}












