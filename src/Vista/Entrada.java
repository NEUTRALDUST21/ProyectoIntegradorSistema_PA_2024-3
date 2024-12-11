package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Entrada extends JFrame {
	
	public javax.swing.JProgressBar Myprogress;
    public javax.swing.JLabel Percentage;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
	
	public Entrada() {
		initComponents();
	}
	
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Percentage = new javax.swing.JLabel();
        Myprogress = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new Color(0, 0, 255));

        Percentage.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        Percentage.setForeground(new java.awt.Color(255, 255, 255));
        Percentage.setText("%");

        Myprogress.setForeground(new java.awt.Color(51, 153, 255));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("\"Tienda Abarrotes Doña Vicky\"");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(Myprogress, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(262)
        			.addComponent(Percentage)
        			.addContainerGap(264, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(124, Short.MAX_VALUE)
        			.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
        			.addGap(107))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(jLabel3)
        			.addPreferredGap(ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
        			.addComponent(Percentage)
        			.addGap(11)
        			.addComponent(Myprogress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }

}
