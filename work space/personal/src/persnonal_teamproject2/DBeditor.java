package persnonal_teamproject2;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBeditor {
	static Scanner scan = new Scanner(System.in);
	//

	public static void main(String[] args)

			throws ClassNotFoundException, SQLException {
		String k ,sql;
		sql = k = null;
		PreparedStatement pstmt = null;
		DBeditor me = new DBeditor();

		// �� �̰͵� ���� Class.forName("oracle.driver.jdbc.OracleDriver");
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("driver load sucess"); // �̺κм���
		// 2. Connection & Open
		// driver : @IP:portnumber:sid(or���������ͺ��̽���)
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uid = "kim";
		String pwd = "oracle";

		Connection conn = DriverManager.getConnection(url, uid, pwd); // �� �κ��� �����ͺ��̽��� ����Ǵ� �κ�
		System.out.println("connection sucess");

		while (true) {
			  // ������ ���� Ŭ���� (����Ʈ > stmt.executequery / �μ�Ʈ,������Ʈ,����Ʈ >
																// stmt.excuteUpdate

			me.select(pstmt,conn);

			System.out.println("\n������ ����� ���ÿ�.\n 1.�߰� 2.���� 3.���� 4.����");

			k = scan.nextLine();
			while(!k.equalsIgnoreCase("1")&&!k.equalsIgnoreCase("2")&&
					!k.equalsIgnoreCase("3")&&!k.equalsIgnoreCase("4")){
				System.out.println("1~4 ������ ����� �����ϼ���");
				k=scan.nextLine();
			}
			

			switch (k) {

			case "1":
				me.insert(pstmt, conn); 
				break;
			case "2":
				me.update(pstmt, conn);
				break;
			case "3":
				me.delete(pstmt, conn);
				break;
			case "4":
				System.out.println("���α׷��� �����մϴ� ");
				conn.close(); 
				System.exit(0);
				break;

			}
			
			 // �������� Ŭ������ ������Ʈ ����� ����
			pstmt = null;
		} // while end

	}

	public void insert(PreparedStatement pstmt, Connection conn) throws SQLException {
		pstmt = null;
		System.out.println("��ȣ �Է� :"); // gno
		String gno = scan.next();
		System.out.println("��ǰ�� �Է�"); // gname
		String gname = scan.next();
		System.out.println("���� �Է�"); // g_start
		String g_start = scan.next();
		System.out.println("����2 �Է�"); // g_end
		String g_end = scan.next();

		String sql = "INSERT INTO GIFT VALUES( ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, gno);
		pstmt.setString(2, gname);
		pstmt.setString(3, g_start);
		pstmt.setString(4, g_end);
		pstmt.executeUpdate(); //���� �߰� �κ�
		
		System.out.println("������ �߰� ����!");
		pstmt.close();
		

	}


	public void select(PreparedStatement pstmt, Connection conn) throws SQLException {// PreparedStatement pstmt

		System.out.println("��ǰ��ȣ\t��ǰ��\t������\t�ְ�");
		pstmt = conn.prepareStatement("SELECT * FROM GIFT");
		ResultSet rs = pstmt.executeQuery("SELECT * FROM GIFT"); // ����Ʈ�� Ŭ������ ����Ʈ�� �����͸� ���� ���� ����� stmt.executeQuery��
									// �����Ѵ�
//		pstmt = conn.prepareStatement("select*from dept2");
//		rs = pstmt.executeQuery();
//		System.out.println("\n dcode \t\t dname\t\t pdept \t\t area");

		try {
			while (rs.next()) { // rs���� �����°��� ������
				int gno = rs.getInt("gno");// or index number
				String gname = rs.getString("gname");
				int g_s = rs.getInt("g_start");
				int g_e = rs.getInt("g_end");

				System.out.println(gno + "\t" + gname + "\t" + g_s + "\t" + g_e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(PreparedStatement pstmt, Connection conn) throws SQLException {
		
		
		System.out.println("������ ��ǰ������ �����ϼ��� \n 1.gno 2.gname 3.g_start 4.g_end");
		int i = scan.nextInt();
		System.out.println("������ ��ǰ��ȣ�� �����ϼ���");
		int j = scan.nextInt();

		int a = 0, c = 0, d = 0;

		String b = null;
		String sql = null;

		switch (i) {
		case 1:
			System.out.println("gno �Է�");
			a = scan.nextInt();
			sql = "UPDATE GIFT SET GNO=? WHERE GNO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a);
			pstmt.setInt(2, j);
			
			break;
		case 2:
			System.out.println("gname �Է�");
			b = scan.next();
			sql = "UPDATE GIFT SET GNAME=? WHERE GNO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b);
			pstmt.setInt(2, j);
	
			break;
		case 3:
			System.out.println("g_start �Է�");
			c = scan.nextInt();
			sql = "UPDATE GIFT SET G_START=? WHERE GNO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c);
			pstmt.setInt(2, j);
			
			break;
		case 4:
			System.out.println("g_end �Է�");
			d = scan.nextInt();
			sql = "UPDATE GIFT SET G_END=? WHERE GNO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d);
			pstmt.setInt(2, j);
			
			break;

		}
		pstmt.executeUpdate();
		System.out.println("������ ���� ����!");
		pstmt.close();

	}

	public void delete(PreparedStatement pstmt, Connection conn) throws SQLException {

		System.out.println("gno �Է�");
		int a = scan.nextInt();
		
		String sql = "DELETE GIFT WHERE GNO=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, a);
		
		pstmt.executeUpdate();
		System.out.println("������ ���� ����!");
		pstmt.close();

		// delete �����̺�� where �ػ���Į����=�ػ�����
	}

}