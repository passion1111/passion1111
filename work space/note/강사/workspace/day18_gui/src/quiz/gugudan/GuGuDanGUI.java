package quiz.gugudan;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuGuDanGUI {

	TextArea area;
	Frame fr = new Frame();

	public GuGuDanGUI() {
		fr.setTitle("구구단프로그램");
		fr.setBackground(Color.BLUE);
		Button[] b = new Button[9];
		fr.setLayout(new FlowLayout());

		area = new TextArea("구구단을\n입력하세요", 10, 12, TextArea.SCROLLBARS_VERTICAL_ONLY);

		EventProc evt = new EventProc();
		for (int i = 1; i < 9; i++) {
			b[i] = new Button((i + 1) + "단");
			b[i].addActionListener(evt);
		}
		Panel p = new Panel();
		for (int i = 1; i < 5; i++)
			p.add(b[i]);
		Panel p2 = new Panel();
		for (int i = 5; i < 9; i++)
			p2.add(b[i]);
		Panel p3 = new Panel(new BorderLayout(5, 10));

		p3.add("South", p2);
		p3.add("North", p);
		fr.add("North", area);
		fr.add("South", p3);
		fr.setSize(200, 300);
		fr.setVisible(true);
		
		fr.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	} //GuGuDanGUI() 생성자함수

	public static void main(String[] args) {
		new GuGuDanGUI();
	}

	class EventProc implements ActionListener {   // inner class
		public void actionPerformed(ActionEvent e) {
			Button target = (Button) e.getSource();
			String cap = target.getActionCommand();
			
			for (int j = 2; j <= 9; j++) {

				if (cap.equals(j + "단")) {
					String a = "";
					for (int i = 1; i < 10; i++) {
						a += (" " + j + " x " + i + " = " + (j * i) + "\n");
					} // in for end
					area.setText(a);
				} // if end
			}// out for end
		}
	}
}
