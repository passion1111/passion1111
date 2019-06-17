//package ex04.tcp;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.*;
//
//public class ClientTest {
//	public static void main(String[] args) {
//		
//		Socket s = null;
//		
//		try {
//			s = new Socket("127.0.0.1", 9000);
//			// I/O
//			InputStream is = s.getInputStream(); //read
//			OutputStream os = s.getOutputStream(); //write
//			
//			
//			
//			String str = "¾È³ç....Server~~~";
//			
//			
//			os.write(str.getBytes());
//			
//			byte[] buffer = new byte[100];
//			is.read(buffer);
//			System.out.println(new String(buffer));
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try { s.close(); }catch(Exception e) { e.printStackTrace();}
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
//
//
//
//
//
//
//
//
//
//
//
//
//
///*package ex04.tcp;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.*;
//public class ClientTest {
//
//	public static void main(String[] args) throws IOException {
//		
//		Socket s=null;
//		byte[] arr=new byte[100];
//		try {
//			s=new Socket("127.0.0.1",9000);//
////			I/O
//			InputStream is=s.getInputStream();//read
//			OutputStream os=s.getOutputStream();
//			String str="¾È³ç...server~";
//			os.write(str.getBytes());
//			
//			byte[] buffer=new byte[100];
//			is.read(buffer);
//			System.out.println(new String(buffer));
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally {
//			s.close();
//			}
//		}
//	}
//*/
