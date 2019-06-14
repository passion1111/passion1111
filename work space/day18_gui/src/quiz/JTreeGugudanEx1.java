package quiz;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.Rectangle;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class JTreeGugudanEx1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JTree jTree = null;
    private JScrollPane jScrollPane = null;
    private JTable jTable = null;
    
    /**
     * This method initializes jTree    
     *     
     * @return javax.swing.JTree    
     */
    private JTree getJTree() {
        if (jTree == null) {
            DefaultMutableTreeNode top = new DefaultMutableTreeNode("구구단");
            top.add(new DefaultMutableTreeNode("1 단"));
            top.add(new DefaultMutableTreeNode("2 단"));
            top.add(new DefaultMutableTreeNode("3 단"));
            top.add(new DefaultMutableTreeNode("4 단"));
            top.add(new DefaultMutableTreeNode("5 단"));
            top.add(new DefaultMutableTreeNode("6 단"));
            top.add(new DefaultMutableTreeNode("7 단"));
            top.add(new DefaultMutableTreeNode("8 단"));
            top.add(new DefaultMutableTreeNode("9 단"));
            jTree = new JTree(top);
            jTree.setBounds(new Rectangle(15, 15, 197, 311));
            jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
                public void valueChanged(javax.swing.event.TreeSelectionEvent e) {
                    jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
                        public void valueChanged(javax.swing.event.TreeSelectionEvent e) {
                        }
                    });
                }
            });
            jTree.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
                    if (node != null) {
                        String nodeInfo = (String)node.getUserObject();
                        if(!node.equals("구구단")) {
                            int dan = Integer.parseInt(nodeInfo.replaceAll(" 단", ""));
                            Object[][] data = new Object[1][9];
                            for(int i=0 ; i<data[0].length ; i++) {
                                data[0][i] = dan + " X " + (i+1) + " = " + (dan * (i+1)); 
                            }
                            jTable.setModel(new GugudanTableModel(data));
                        }
                    }
                }
            });
        }
        return jTree;
    }

    /**
     * This method initializes jScrollPane    
     *     
     * @return javax.swing.JScrollPane    
     */
    private JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new JScrollPane();
            jScrollPane.setBounds(new Rectangle(225, 16, 679, 79));
            jScrollPane.setViewportView(getJTable());
        }
        return jScrollPane;
    }

    /**
     * This method initializes jTable    
     *     
     * @return javax.swing.JTable    
     */
    private JTable getJTable() {
        if (jTable == null) {
            jTable = new JTable(new GugudanTableModel());
        }
        return jTable;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JTreeGugudanEx1 thisClass = new JTreeGugudanEx1();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }

    /**
     * This is the default constructor
     */
    public JTreeGugudanEx1() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(931, 368);
        this.setContentPane(getJContentPane());
        this.setTitle("JFrame");
    }

    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getJTree(), null);
            jContentPane.add(getJScrollPane(), null);
        }
        return jContentPane;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"

