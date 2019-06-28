package quiz.gugudan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JFrame;
 
public class MTableMain extends JFrame {
 
    TextArea ta;
 
    public MTableMain() {
        Panel p = new Panel();
        Button[] btn = new Button[8];
        ta = new TextArea("", 11, 50, TextArea.SCROLLBARS_VERTICAL_ONLY);
        
        p.add(ta);
        
        for (int i = 0; i < btn.length; i++) {
        	//int score = 999;
            btn[i] = new Button((i+2) + "단");   
            final int k = btn[i].getName().charAt(6) - '1' + 3;
                      
            btn[i].addActionListener(new ActionListener() {  //익명 클래스 영역이라서...
            	//int score = 80;
                @Override
                public void actionPerformed(ActionEvent e) {
                    ta.setText("");
                     for (int i = 1; i <= 9; i++) {  
                        String str = k + " * " +i + " = " + k * i + "\n";
                        ta.append(str);
                    } // in for end
                    ta.append(k + "단이 입력되었습니다.\n\n");
                }
            });
            p.add(btn[i], BorderLayout.SOUTH);
        } // out for end
        
        add(p);
 
        setBounds(300, 350, 400, 300);
        setVisible(true);
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public static void main(String[] args) {
        new MTableMain();
    }
}
