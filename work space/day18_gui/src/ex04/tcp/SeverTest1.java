//package ex04.tcp;
//import java.io.*;
//import java.net.*;
//
//public class SeverTest1 {
//	public static void main(String[] args) {
//		ServerSocket ss = null;
//		Socket s = null;
//		System.out.println("Server Start~~~");
//		
//		try {
//			ss = new ServerSocket(9000);
//			s = ss.accept(); // client socket, ������
//			// I/O
//			InputStream is = s.getInputStream(); //read
//			OutputStream os = s.getOutputStream(); //write
//			
//			byte[] arr = new byte[100];
//			is.read(arr);
//			System.out.println(new String(arr));
//			String msg = "�ȳ�....Client~~~";
//			os.write(msg.getBytes());
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try { 
//				s.close(); ss.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}
//
//
//
//
//
//
//
//
