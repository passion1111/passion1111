package teacher_gui.employee1;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel {
	Object[][] data;
	String[] columnName;
	int rows, cols;  // ���ڵ��� ��� ���� ������ ������ ����
	
	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public int getRowCount() { //���ڵ� ������ �˾Ƴ���
		return data.length;
	}

	public void getRowCount(ResultSet rsScroll) { //���ڵ� ������ �˾Ƴ���
		try {
			rsScroll.last();
			rows = rsScroll.getRow();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override  
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
	//DB�� ����� �����͸� ä��
	public void setData(ResultSet rs) {
		try {
			ResultSetMetaData rsmd;
			rsmd = rs.getMetaData(); 
			cols = rsmd.getColumnCount();
			columnName = new String[cols];
			
			for (int i = 0; i < cols ; i++) {
				columnName[i] = rsmd.getColumnName(i+1);
			}
			
			data = new Object[rows][cols];
			int r = 0;
			
			while( rs.next() ){
				for (int i = 0; i < cols ; i++) {
					if( i != 1 ) data[r][i] = rs.getObject(i+ 1);
					else data[r][i] = Util.tokor((String)rs.getObject(i + 1));    //!!!! �ѱ� ����ó��...	
				} //for end
				
				r++;
			} //while end
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


