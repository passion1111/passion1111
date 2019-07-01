package ex02.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel {
	Object[][] data;
	String[] columnName;
	int rows,cols; //레코드 행과 열의 개수를 저장하는 변수.

	@Override
	public int getColumnCount() {  //필드(열)의 개수
		// TODO Auto-generated method stub
		return columnName.length;
	}
	
	@Override
	public int getRowCount() {   //레코드 개수 알아내기
		// TODO Auto-generated method stub
		return data.length;
	}

	public void  getRowCount(ResultSet rsScroll) {   //레코드 개수 알아내기
		try {
			rsScroll.last(); //레코드의마지막행으로 커서 이동
			rows=rsScroll.getRow();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

	//DB에 저장된 데이터를 채움
	public void setData(ResultSet rs) {
		try {
			String title;
			ResultSetMetaData rsmd=rs.getMetaData();
			
			cols=rsmd.getColumnCount();
			columnName=new String[cols];
			for (int i = 0; i < cols; i++) {
				columnName[i]=rsmd.getColumnName(i+1);//필드는 1부터시작합니다.
				
				
			}
			data=new Object[rows][cols];
			int r=0;
			
			while(rs.next()) {
				for (int i = 0; i < cols; i++) {
					
					
					if(i!=1) data[r][i]=rs.getObject(i+1);
					else data[r][i]=Util.toKor((String)rs.getObject(i+1));//varchar2 type한글 꺠짐 처리
				
				}//for end
				r++;
				
			}//while end
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
