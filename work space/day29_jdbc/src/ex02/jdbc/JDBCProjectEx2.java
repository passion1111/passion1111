package ex02.jdbc;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Service.Mode;

public class JDBCProjectEx2 extends JFrame 
			implements ActionListener {
	//component ��ü ����
	JPanel panWest, panSouth;  //�����ؽ�Ʈ�ʵ�, �Ʒ��� ��ư
	JPanel p1,p2,p3,p4,p5; 
	JTextField txtNo, txtName, txtEmail, txtPhone;
	JButton  btnTotal, btnAdd, btnDel, btnSearch, btnCancel;
	
	JTable table; //�˻��� ��ü ���⸦ ���� ���̺� ��ü ����
	//���º�ȭ�� ���� ���� ����
	private static final int NONE = 0;
	private static final int ADD = 1;
	private static final int DELETE = 2;
	private static final int SEARCH = 3;
	private static final int TOTAL = 4;
	int cmd = NONE;
	
	MyModel model;//���� �ϰ� ������ ����.
	
	public JDBCProjectEx2(){ //�������Լ� - �ʱ�ȭ
		//component ���
		panWest = new JPanel(new GridLayout(5, 0));
		p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(new JLabel("��    ȣ"));
		p1.add(txtNo = new JTextField(12));
		panWest.add(p1);
		
		p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(new JLabel("��    ��"));
		p2.add(txtName = new JTextField(12));
		panWest.add(p2);
		
		p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(new JLabel("��  ��  ��"));
		p3.add(txtEmail = new JTextField(12));
		panWest.add(p3);
		
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4.add(new JLabel("��ȭ��ȣ"));
		p4.add(txtPhone = new JTextField(12));
		panWest.add(p4);
		
		p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p5.add(new JLabel(""));
		panWest.add(p5);
		
		this.add(panWest, "West");
		
		//button ȭ�� �Ʒ� ���
		panSouth = new JPanel();
		panSouth.add(btnTotal= new JButton("��ü����")); 
		panSouth.add(btnAdd= new JButton("��     ��"));
		panSouth.add(btnDel= new JButton("��     ��"));
		panSouth.add(btnSearch= new JButton("��     ��"));
		panSouth.add(btnCancel= new JButton("��     ��"));
		add(panSouth, "South");
		
		//event ó��
		btnTotal.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnSearch.addActionListener(this);
		btnCancel.addActionListener(this);
		
		//���̺� ��ü ����
		add(new JScrollPane(table = new JTable()), "Center");
		//close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���� â ���
		setBounds(100, 100, 700, 300); //setSize(W,H);   pack(); 
		setVisible(true);	
		
		dbConnect();  //DB ���� ���� �Լ� ȣ��
		total();
	} //constuctor end
	
	//////// db setting //////////
	Connection conn;
	Statement stmt;
	PreparedStatement pstmtInsert, pstmtDelete;
	PreparedStatement pstmtTotal, pstmtTotalScroll;
	PreparedStatement pstmtSearch, pstmtSearchScroll;

	private String driver ="oracle.jdbc.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "kim";
	private String pwd = "oracle";
	
	private String sqlInsert = "INSERT INTO CUSTOMERS VALUES(?, ?, ?, ?)";
	private String sqlDelete = "DELETE FROM CUSTOMERS WHERE NAME = ?";
	private String sqlTotal = "SELECT * FROM CUSTOMERS";
	private String sqlSearch = "SELECT * FROM CUSTOMERS WHERE NAME = ?";
	
	public void dbConnect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			
			pstmtInsert = conn.prepareStatement(sqlInsert);
			pstmtDelete = conn.prepareStatement(sqlDelete);
			pstmtTotal = conn.prepareStatement(sqlTotal);
			pstmtSearch = conn.prepareStatement(sqlSearch);
			
			pstmtTotalScroll = conn.prepareCall(sqlTotal,
						ResultSet.TYPE_SCROLL_SENSITIVE, //Ŀ�� �̵��� �����Ӱ��ϰ� ������Ʈ ������ �ݿ��Ѵ�.
						ResultSet.CONCUR_UPDATABLE); // resultset object �� ������ ���� <=> CONCUR_READ_ONLY
			
			pstmtSearchScroll = conn.prepareCall(sqlSearch,
					ResultSet.TYPE_SCROLL_SENSITIVE, //Ŀ�� �̵��� �����Ӱ��ϰ� ������Ʈ ������ �ݿ��Ѵ�.
					ResultSet.CONCUR_UPDATABLE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // dbConnect() end
	
	
	@Override // button event ó�� 
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if( obj == btnAdd ){
			if( cmd != ADD ){
				setText(ADD);  //user method
				return;
			} //if in
			setTitle(e.getActionCommand());
			add();  //�߰�
			
		}else if( obj == btnDel ){
			if( cmd != DELETE ){
				setText(DELETE);  //user method
				return;
			} //if in
			setTitle(e.getActionCommand());
			//del();  ����
			
		}else if( obj == btnSearch ){
			if( cmd != SEARCH ){
				setText(SEARCH);  //user method
				return;
			} //if in
			setTitle(e.getActionCommand());
			//search();  �˻�
			
		}else if( obj == btnTotal ){
			setTitle(e.getActionCommand());
			//System.out.println("connection success!!");
			total(); //��ü����
		}
		setText(NONE);
		init(); //�ʱ�ȭ �޼ҵ�, user method
	}// actionPerformed end
	
	//button event user method ////
	private void total() {   //��ü����(select) ��ư �̺�Ʈ ó�� �Լ�.
		
		try {
			ResultSet rsScroll=pstmtTotalScroll.executeQuery();
			ResultSet rs=pstmtTotal.executeQuery();
			
			if(model==null)model=new MyModel();
			model.getRowCount(rsScroll);
			model.setData(rs);
			
//			table.setModel(model);
			table.setModel(new DefaultTableModel(model.data,model.columnName));
			table.updateUI();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public void add() {
		try {
			String strNo = txtNo.getText();
			String strName = txtName.getText();
			String strMail = txtEmail.getText();
			String strPhone = txtPhone.getText();
			
			//System.out.println(strNo+", " + strName + ", " + strMail + ", " +strPhone);
			
//			if( strNo.length() < 1 || strName.length() < 1) {
//				JOptionPane.showMessageDialog(null, 
//						"��ȣ�� �̸��� �ʼ� �����Դϴ�. �Է����ּ���");
//				return;
//			} // if end
			
			switch( JOptionPane.showConfirmDialog(null, 
						"("+ strNo + ", " + strName + ", " + strMail +", "
						   + strPhone + ")", "�߰��Ͻðڽ��ϱ�? ",
							JOptionPane.YES_NO_OPTION) ) {
				
				case 0 : //Ȯ��
					break;
				case 1 : //�ƴϿ�
					return;
			} // switch end
			
			// db save
			
			pstmtInsert.setInt(1, Integer.parseInt(strNo));
			pstmtInsert.setString(2, strName);
			pstmtInsert.setString(3, strMail);
			pstmtInsert.setString(4, strPhone);
			
			pstmtInsert.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} // try end
		
		JOptionPane.showMessageDialog(null, "�߰� �ƽ��ϴ�");
		total();
		init();		
		
	}// add() end


	private void init() {  //�ʱ�ȭ �޼ҵ�
		txtNo.setText("");			txtNo.setEditable(false);
		txtName.setText("");		txtName.setEditable(false);
		txtEmail.setText("");		txtEmail.setEditable(false);
		txtPhone.setText("");		txtPhone.setEditable(false);
	}// init() end

	private void setText(int command) {
		switch(command){
			case ADD :
				txtNo.setEditable(true);
				txtName.setEditable(true);
				txtEmail.setEditable(true);
				txtPhone.setEditable(true);
				break;
			case DELETE :
			case SEARCH :
				txtName.setEditable(true);
				break;
		}//switch end
		
		setButton(command);  //user method
	}// setText() end

	private void setButton(int command) {
		//cancel button �����ϰ� � ��ư�� �������� ��� ��ư�� ��Ȱ��ȭ
		btnTotal.setEnabled(false);
		btnAdd.setEnabled(false);
		btnDel.setEnabled(false);
		btnSearch.setEnabled(false);
		
		switch(command){
			case ADD :
				btnAdd.setEnabled(true);
				cmd = ADD;
				break;
			case DELETE :
				btnDel.setEnabled(true);
				cmd = DELETE;
				break;
				
			case SEARCH :
				btnSearch.setEnabled(true);
				cmd = SEARCH;
				break;
			case TOTAL :
				btnTotal.setEnabled(true);
				cmd = TOTAL;
				break;
			case NONE :
				btnTotal.setEnabled(true);
				btnAdd.setEnabled(true);
				btnDel.setEnabled(true);
				btnSearch.setEnabled(true);
				btnCancel.setEnabled(true);  //
				cmd = NONE;
				break;
		}//switch end	
	}//setButton end

	public static void main(String[] args) {
		new JDBCProjectEx2();
	}
}




