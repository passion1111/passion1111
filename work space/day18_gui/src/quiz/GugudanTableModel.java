package quiz;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class GugudanTableModel extends AbstractTableModel {
    String[] columnNames = { "X 1", "X 2", "X 3", "X 4", "X 5", "X 6", "X 7", "X 8", "X 9" };
    Object[][] data = null;
    
    public GugudanTableModel() {
    }

    public GugudanTableModel(Object[][] data) {
        this.data = data; 
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        if(data != null) {
            return data.length;
        } else {
            return 0;
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if(data != null) {
            return data[rowIndex][columnIndex];
        } else {
            return null;
        }
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}

