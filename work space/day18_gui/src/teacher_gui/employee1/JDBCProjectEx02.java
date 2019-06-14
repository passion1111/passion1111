package teacher_gui.employee1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JDBCProjectEx02 extends JFrame implements ActionListener{
	private static final int NONE = 0;
	private static final int ADD = 1;
	private static final int DELETE = 2;
	private static final int SEARCH = 3;
	private static final int TOTAL = 4;
	
	private int cmd = NONE;
	
	private JTextField tfNum;
	private JTextField tfName;
	private JTextField tfMail;
	private JTextField tfTel;
	
	private JButton btnAll;
	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnSearch;
	private JButton btnCancle;
	
	private JTable table;
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmtInsert, pstmtDelete;
	PreparedStatement pstmtTotal, pstmtTotalScroll;
	PreparedStatement pstmtSearch, pstmtSearchScroll;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private String user = "kingsmile";
	private String pwd = "oracle";
	
	private String sqlInsert = "insert into Customer values(?, ?, ?, ?)";
	private String sqlDelete = "delete from Customer where name = ?";
	private String sqlTotal = "select * from Customer";
	private String sqlSearch = "select * from Customer where name = ?";
	
	MyModel model;
	
	
	
	public JDBCProjectEx02(){
		init();
		setDisplay();
		addListener();
		showFrame();
	}
	
	private void init() {
		int inputSize = 13;
		tfNum = new JTextField(inputSize);
		tfNum.setToolTipText("번호");
		tfName = new JTextField(inputSize);
		tfName.setToolTipText("이름");
		tfMail = new JTextField(inputSize);
		tfMail.setToolTipText("메일");
		tfTel = new JTextField(inputSize);
		tfTel.setToolTipText("연락처");
		
		
		btnAll = new JButton("전체");
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		btnSearch = new JButton("검색");
		btnCancle = new JButton("취소");
	}
	
	private void setInit(){
		tfNum.setText("");
		tfNum.setEditable(false);
		tfName.setText("");
		tfName.setEditable(false);
		tfMail.setText("");
		tfMail.setEditable(false);
		tfTel.setText("");
		tfTel.setEditable(false);
	}

	private void setDisplay() {
		JPanel pnlWestNorth = new JPanel();
		
		JPanel pnlNum = new JPanel();
		JPanel pnlName = new JPanel();
		JPanel pnlMail = new JPanel();
		JPanel pnlTel = new JPanel();
		
		Dimension lblSize = new Dimension(120, 20);
		
		JLabel lblNum = new JLabel("번    호", JLabel.CENTER);
		JLabel lblName = new JLabel("이    름", JLabel.CENTER);
		JLabel lblMail = new JLabel("메    일", JLabel.CENTER);
		JLabel lblTel = new JLabel("연락처", JLabel.CENTER);
		
		lblNum.setBorder(new EmptyBorder(15, 10, 15, 10));
		lblName.setBorder(new EmptyBorder(15, 10, 15, 10));
		lblMail.setBorder(new EmptyBorder(15, 10, 15, 10));
		lblTel.setBorder(new EmptyBorder(15, 10, 15, 10));
		
		JPanel pnlNorth = new JPanel();
		JPanel pnlWest = new JPanel(new GridLayout(0, 1));
		
		pnlNorth.add(btnAll);
		pnlNorth.add(btnAdd);
		pnlNorth.add(btnDel);
		pnlNorth.add(btnSearch);
		pnlNorth.add(btnCancle);
		
		pnlNum.add(lblNum);
		pnlNum.add(tfNum);
		pnlName.add(lblName);
		pnlName.add(tfName);
		pnlMail.add(lblMail);
		pnlMail.add(tfMail);
		pnlTel.add(lblTel);
		pnlTel.add(tfTel);
		
		pnlWest.add(pnlNum);
		pnlWest.add(pnlName);
		pnlWest.add(pnlMail);
		pnlWest.add(pnlTel);
		
		pnlWestNorth.add(pnlWest, BorderLayout.NORTH);
		
		add(new JScrollPane(table = new JTable()), BorderLayout.CENTER);
		
		add(pnlWestNorth, BorderLayout.WEST);
		add(pnlNorth, BorderLayout.SOUTH);
	}

	private void addListener() {
		btnAll.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnSearch.addActionListener(this);
		btnCancle.addActionListener(this);
	}

	private void showFrame() {
		setTitle("창차라창창");
		setSize(800, 400);
//		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		dbConnect();
		setVisible(true);
	}

	private void dbConnect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmtInsert = conn.prepareStatement(sqlInsert);
			pstmtDelete = conn.prepareStatement(sqlDelete);
			
			pstmtTotalScroll = conn.prepareStatement(sqlTotal,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			
			pstmtSearchScroll = conn.prepareStatement(sqlSearch,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pstmtTotal = conn.prepareStatement(sqlTotal);
			pstmtSearch = conn.prepareStatement(sqlSearch);
			
			//setInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnAdd){
			if(cmd != ADD){
				setText(ADD);
				return;
			}
			setTitle(e.getActionCommand());
			add();
		}else if(obj == btnDel){
			if(cmd != DELETE){
				setText(DELETE);
				return;
			}
			setTitle(e.getActionCommand());
			del();
		}else if(obj == btnSearch){
			if(cmd != SEARCH){
				setText(SEARCH);
				return;
			}
			setTitle(e.getActionCommand());
			search();
		}else if(obj == btnAll){
			setTitle(e.getActionCommand());
			total();
		}
		setText(NONE);
		//setInit();
	}

	public void setText(int command){
		switch(command){
		case ADD :
			tfNum.setEditable(true);
			tfName.setEditable(true);
			tfMail.setEditable(true);
			tfTel.setEditable(true);
			break;
		case DELETE :
		case SEARCH :
			tfName.setEditable(true);
			break;
		}
		setButton(command);
	}
	
	public void add(){
		try{
			String strNo = tfNum.getText();
			String strName = tfName.getText();
			String strMail = tfMail.getText();
			String strTel = tfTel.getText();
			
			if(strNo.length() < 1 || strName.length() < 1){
				JOptionPane.showMessageDialog(null, "번호와 이름을 입력해 주세요!");
				return;
			}
			pstmtInsert.setInt(1, Integer.parseInt(strNo));
			pstmtInsert.setString(2, strName);
			pstmtInsert.setString(3, strMail);
			pstmtInsert.setString(4, strTel);
			pstmtInsert.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "추가성공");
	}
	
	private void del() {
		try {
			String strName = Util.tokor(tfName.getText());
			
			if(strName.length() < 1){
				JOptionPane.showMessageDialog(null, "이름을 입력해 주세요!");
				return;
			}
		
			pstmtDelete.setString(1, strName);
			pstmtDelete.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "삭제완료");
		total();
	}
	

	private void search() {
		try {
			String strName = Util.tokor(tfName.getText());
			
			if(strName.length() < 1){
				JOptionPane.showMessageDialog(null, "이름을 입력해 주세요!");
				return;
			}
			
			pstmtSearchScroll.setString(1, Util.toLatin(strName));
			ResultSet rsScroll = pstmtSearchScroll.executeQuery();
			pstmtSearch.setString(1, Util.tokor(strName));
			ResultSet rs = pstmtSearch.executeQuery();
			
			if(model == null){
				model = new MyModel();
			}
			model.getRowCount(rsScroll);
			model.setData(rs);
			table.setModel(model);
			table.updateUI();
			
			pstmtSearch.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "검색완료");
	}
	
	private void total(){
		try{
			ResultSet rsScroll = pstmtTotalScroll.executeQuery();
			ResultSet rs = pstmtTotal.executeQuery();
			
			if(model == null){
				model = new MyModel();
			}
			model.getRowCount(rsScroll);
			model.setData(rs);
			table.setModel(model);
			table.updateUI();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void setButton(int command){
		btnAll.setEnabled(false);
		btnAdd.setEnabled(false);
		btnDel.setEnabled(false);
		btnSearch.setEnabled(false);
		
		switch(command){
			case ADD:
				btnAdd.setEnabled(true);
				cmd = ADD;
				break;
			case DELETE:
				btnDel.setEnabled(true);
				cmd = DELETE;
				break;
			case SEARCH:
				btnSearch.setEnabled(true);
				cmd = SEARCH;
				break;
			case TOTAL:
				btnAll.setEnabled(true);
				cmd = TOTAL;
				break;
			case NONE:
				btnAll.setEnabled(true);
				btnAdd.setEnabled(true);
				btnDel.setEnabled(true);
				btnSearch.setEnabled(true);
				btnCancle.setEnabled(true);
				cmd = NONE;
				break;
		}
	}
	
	public static void main(String[] args) {
		new JDBCProjectEx02();
	}
}