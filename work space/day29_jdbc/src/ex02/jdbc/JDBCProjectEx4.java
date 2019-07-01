package ex02.jdbc;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Service.Mode;

public class JDBCProjectEx4 extends JFrame 
			implements ActionListener {
	//component 객체 선언
	JPanel panWest, panSouth;  //왼쪽텍스트필드, 아래쪽 버튼
	JPanel p1,p2,p3,p4,p5; 
	JTextField txtNo, txtName, txtEmail, txtPhone;
	JButton  btnTotal, btnAdd, btnDel, btnSearch, btnCancel,btnUpdate;
	
	JTable table; //검색과 전체 보기를 위한 테이블 객체 생성
	//상태변화를 위한 변수 선언
	private static final int NONE = 0;
	private static final int ADD = 1;
	private static final int DELETE = 2;
	private static final int SEARCH = 3;
	private static final int TOTAL = 4;
	private static final int UPDATE = 5;
	int cmd = NONE;
	
	MyModel model;//선언만 하고 생성은 안함.
	
	
	public JDBCProjectEx4(){ //생성자함수 - 초기화
		//component 등록
		panWest = new JPanel(new GridLayout(5, 0));
		p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(new JLabel("번    호"));
		p1.add(txtNo = new JTextField(12));
		panWest.add(p1);
		
		p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(new JLabel("이    름"));
		p2.add(txtName = new JTextField(12));
		panWest.add(p2);
		
		p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(new JLabel("이  메  일"));
		p3.add(txtEmail = new JTextField(12));
		panWest.add(p3);
		
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4.add(new JLabel("전화번호"));
		p4.add(txtPhone = new JTextField(12));
		panWest.add(p4);
		
		p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p5.add(new JLabel(""));
		panWest.add(p5);
		
		this.add(panWest, "West");
		
		//button 화면 아래 등록
		panSouth = new JPanel();
		panSouth.add(btnTotal= new JButton("전체보기")); 
		panSouth.add(btnAdd= new JButton("추     가"));
		panSouth.add(btnDel= new JButton("삭     제"));
		panSouth.add(btnSearch= new JButton("검     색"));
		panSouth.add(btnUpdate=new JButton("업데이트"));
		panSouth.add(btnCancel= new JButton("취     소"));
		add(panSouth, "South");
		
		//event 처리
		btnTotal.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnSearch.addActionListener(this);
		btnCancel.addActionListener(this);
		btnUpdate.addActionListener(this);
		
		//테이블 객체 생성
		add(new JScrollPane(table = new JTable()), "Center");
		//close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//메인 창 출력
		setBounds(100, 100, 700, 300); //setSize(W,H);   pack(); 
		setVisible(true);	
		
		dbConnect();  //DB 연결 관련 함수 호출
		total();
	} //constuctor end
	
	//////// db setting //////////
	Connection conn;
	Statement stmt;
	PreparedStatement pstmtInsert, pstmtDelete;
	PreparedStatement pstmtTotal, pstmtTotalScroll;
	PreparedStatement pstmtSearch, pstmtSearchScroll;
	PreparedStatement pstmtUpdate;

	private String driver ="oracle.jdbc.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "kim";
	private String pwd = "oracle";
	
	private String sqlInsert = "INSERT INTO CUSTOMERS VALUES(?, ?, ?, ?)";
	private String sqlDelete = "DELETE FROM CUSTOMERS WHERE NAME = ?";
	private String sqlTotal = "SELECT * FROM CUSTOMERS";
	private String sqlSearch = "SELECT * FROM CUSTOMERS WHERE NAME = ?";
	private String sqlUpdate="update customers set email=? where code=?";
	
	public void dbConnect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			
			pstmtInsert = conn.prepareStatement(sqlInsert);
			pstmtDelete = conn.prepareStatement(sqlDelete);
			pstmtTotal = conn.prepareStatement(sqlTotal);
			pstmtSearch = conn.prepareStatement(sqlSearch);
			pstmtUpdate= conn.prepareStatement(sqlUpdate);
			
			pstmtTotalScroll = conn.prepareCall(sqlTotal,
						ResultSet.TYPE_SCROLL_SENSITIVE, //커서 이동을 자유롭게하고 업데이트 내용을 반영한다.
						ResultSet.CONCUR_UPDATABLE); // resultset object 의 변경이 가능 <=> CONCUR_READ_ONLY
			
			pstmtSearchScroll = conn.prepareCall(sqlSearch,
					ResultSet.TYPE_SCROLL_SENSITIVE, //커서 이동을 자유롭게하고 업데이트 내용을 반영한다.
					ResultSet.CONCUR_UPDATABLE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // dbConnect() end
	
	
	@Override // button event 처리 
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if( obj == btnAdd ){
			if( cmd != ADD ){
				setText(ADD);  //user method
				return;
			} //if in
			setTitle(e.getActionCommand());
			add();  //추가
			
		}else if( obj == btnDel ){
			if( cmd != DELETE ){
				setText(DELETE);  //user method
				return;
			} //if in
			setTitle(e.getActionCommand());
			del();  
			
		}else if( obj == btnSearch ){
			if( cmd != SEARCH ){
				setText(SEARCH);  //user method
				return;
			} //if in
			setTitle(e.getActionCommand());
			search(); 
			
		}else if( obj == btnTotal ){
			setTitle(e.getActionCommand());
			//System.out.println("connection success!!");
			total(); //전체보기
		}else if(obj==btnUpdate) {
			if(cmd!=UPDATE) {
			setText(UPDATE);
			return;
			}//if in
			setTitle(e.getActionCommand());
			update();
			
		}
		setText(NONE);
		init(); //초기화 메소드, user method
	}// actionPerformed end
	
	private void search() {
		total();
		String strName=null;
		try {
			strName=Util.toKor(txtName.getText());
			
			if(strName.length()<1) {
				JOptionPane.showMessageDialog(null, "이름은 필수 입력란 입니다.");
				return;
			}
			pstmtSearch.setString(1, strName);
			pstmtSearchScroll.setString(1, strName);
			ResultSet rsScroll=pstmtSearchScroll.executeQuery();
			ResultSet rs=pstmtSearch.executeQuery();
			if(model==null)model=new MyModel();
			model.getRowCount(rsScroll);
			model.setData(rs);
			table.setModel(model);
//			table.setModel(new DefaultTableModel(model.data,model.columnName));
			table.updateUI();
//			total();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	private void del() {//삭제 버튼 이벤트
		total();
		String strName=null;
		try {
			strName=Util.toKor(txtName.getText());
			
			if(strName.length()<1) {
				JOptionPane.showMessageDialog(null, "이름은 필수 입력란 입니다.");
				return;
			}
			pstmtDelete.setString(1, strName);
			pstmtDelete.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		JOptionPane.showMessageDialog(null, "삭제 성공");
//		JOptionPane.showConfirmDialog(null, "삭제 성공");  //삭제할떄 창 하나 띄우기.
		switch( JOptionPane.showConfirmDialog(null, 
				"("+ strName+		    ")", "삭제 하시겠습니까? ",
					JOptionPane.YES_NO_OPTION) ) {
		
		case 0 : //확인
			break;
		case 1 : //아니오
			return;
	} // switch end
		
		total(); 
		
	}//del end
	
	private void update() {
		String strNo=txtNo.getText();
		String strMail=txtEmail.getText();
		try {
			pstmtUpdate.setString(1, strMail);
			pstmtUpdate.setString(2, strNo);
			pstmtUpdate.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "업데이트 됐습니다");
		total();
		
		
	}

	//button event user method ////
	private void total() {   //전체보기(select) 버튼 이벤트 처리 함수.
		
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
//						"번호와 이름은 필수 사항입니다. 입력해주세요");
//				return;
//			} // if end
			
			switch( JOptionPane.showConfirmDialog(null, 
						"("+ strNo + ", " + strName + ", " + strMail +", "
						   + strPhone + ")", "추가하시겠습니까? ",
							JOptionPane.YES_NO_OPTION) ) {
				
				case 0 : //확인
					break;
				case 1 : //아니오
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
		
		JOptionPane.showMessageDialog(null, "추가 됐습니다");
		total();
		init();		
		
	}// add() end
	


	private void init() {  //초기화 메소드
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
			case UPDATE:
				txtEmail.setEditable(true);
				txtNo.setEditable(true);
				break;
		}//switch end
		
		setButton(command);  //user method
	}// setText() end

	private void setButton(int command) {
		//cancel button 제외하고 어떤 버튼이 눌리더라도 모든 버튼이 비활성화
		btnTotal.setEnabled(false);
		btnAdd.setEnabled(false);
		btnDel.setEnabled(false);
		btnSearch.setEnabled(false);
		btnUpdate.setEnabled(false);
		
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
			case UPDATE:
				btnUpdate.setEnabled(true);
				cmd=UPDATE;
				break;
			case NONE :
				btnTotal.setEnabled(true);
				btnAdd.setEnabled(true);
				btnDel.setEnabled(true);
				btnSearch.setEnabled(true);
				btnCancel.setEnabled(true);  //
				btnUpdate.setEnabled(true);
				cmd = NONE;
				break;
		}//switch end	
	}//setButton end

	public static void main(String[] args) {
		new JDBCProjectEx4();
	}
}




