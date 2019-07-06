package Kiosk_Counter1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Kiosk_DB.KioskDBManager;

public class Kiosk_counter implements Runnable {
	ServerSocket ss = null; 
	Socket s = null; 
	Connection conn = null;

	class ServerReceiver extends Thread { 
		Socket s; 
		DataInputStream dis;
		DataOutputStream dos;

		public ServerReceiver(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());

				dos = new DataOutputStream(s.getOutputStream());
				conn = KioskDBManager.getConnection();

			} catch (Exception e) {
				System.out.println("���� ���ú� ����!!");
			}
		} 

		@Override
		public void run() { 

			try {

				String a = null;

				if (dis != null) {
					do {
						String sql = "select*from jumunnum order by 1";
						PreparedStatement pstm = conn.prepareStatement(sql);
						ResultSet rs = pstm.executeQuery();
						while (rs.next()) {
							System.out.printf(rs.getInt(1) + "\t" + rs.getString(2));

							System.out.println();
						}

					} while (dis == null);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			} 
		}

	} 
	

	public static void main(String[] args) {//Kiosk�����尡 ����Ǹ� �Ʒ��� �ִ� run�޼ҵ尡 ����ȴ�.
		Thread Kiosk_counter = new Thread(new Kiosk_counter());

		Kiosk_counter.start();

	}

	@Override
	public void run() {
		try {
			ss = new ServerSocket(7999);
			System.out.println("7999���� ���� �Ǿ����ϴ�.");

			while (true) {
				s = ss.accept();

				if (s != null) {
					ServerReceiver thread = new ServerReceiver(s);
					thread.start();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}