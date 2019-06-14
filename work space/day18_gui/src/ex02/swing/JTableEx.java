package ex02.swing;
import javax.swing.*;
import java.awt.*;
public class JTableEx extends JFrame{

		JTable table;
		String[] fieldName= {"학번","국어","전산","수학"};
		String[][]data= {{"001","60","7","80"},
						{"002","50","6","80"},
						{"003","70","5","80"},
						{"004","80","5","80"},
						{"005","90","0","80"},
						{"006","60","76","80"}
						}; //배열 끝
		
		public JTableEx(String str) {
			super(str);
			table=new JTable(data,fieldName);
			JScrollPane sp=new JScrollPane(table);
			getContentPane().add(sp,"Center");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(350,150);
			setVisible(true);
		}
	
		public static void main(String[] args) {
			new JTableEx("테이블예제");
		}
}
