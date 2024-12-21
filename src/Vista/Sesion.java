
package Vista;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Sesion extends JFrame {
	
	private javax.swing.JComboBox<String> RoleCb;
    private javax.swing.JTextField Uid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField password;
	
    public static void main(String parametro[]) 
	{
    	Sesion ventana = new Sesion();
		ventana.setVisible(true);
	}
    
	public Sesion() {
		initComponents();
	}
	
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel10 = new javax.swing.JLabel();
        jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11 = new javax.swing.JLabel();
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel2 = new javax.swing.JPanel();
        password = new javax.swing.JTextField();
        Uid = new javax.swing.JTextField();
        RoleCb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame2"); // NOI18N

        jPanel1.setBackground(new Color(0, 0, 255));

        jLabel8.setIcon(new ImageIcon("C:\\Users\\Personal\\eclipse-workspace\\ProyectoIntegradorSistema\\Imagenes\\78339577-icono-de-carrito-de-compras-de-supermercado-fondo-naranja-con-negro-ilustración-vectorial - copia.jpg")); // NOI18N

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("\"Variedad y frescura,");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tienda");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("todos los dias\".");
        
        lblLosMejoresPrecios = new JLabel();
        lblLosMejoresPrecios.setHorizontalAlignment(SwingConstants.CENTER);
        lblLosMejoresPrecios.setForeground(Color.WHITE);
        lblLosMejoresPrecios.setFont(new Font("Century Gothic", Font.BOLD, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(42, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel8)
        					.addGap(77))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(lblLosMejoresPrecios, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGap(10))
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addGap(23)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(40)
        					.addComponent(jLabel11)
        					.addPreferredGap(ComponentPlacement.RELATED, 21, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(20))
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap(103, Short.MAX_VALUE)
        			.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
        			.addGap(72))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(66)
        			.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addComponent(jLabel10)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel9)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel11)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblLosMejoresPrecios, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        password.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        password.setForeground(new Color(0, 0, 255));

        Uid.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Uid.setForeground(new Color(0, 0, 255));

        RoleCb.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        RoleCb.setForeground(new Color(0, 0, 255));
        RoleCb.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Usuario"}));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(0, 0, 255));
        jLabel4.setText("USUARIO");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(0, 0, 255));
        jLabel5.setText("CONTRASEÑA");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new Color(0, 0, 255));
        jLabel6.setText("ELEGIR ROL");

        jButton1.setBackground(new Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Iniciar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Limpiar");
        jButton2.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 2, 20)); // NOI18N
        jLabel7.setForeground(new Color(0, 0, 255));

        jLabel2.setIcon(new ImageIcon("C:\\Users\\Personal\\eclipse-workspace\\ProyectoIntegradorSistema\\Imagenes\\70512368-ilustración-de-bolsa-de-compras-icono-naranja-con-una-etiqueta-engomada-de-sombra-plana.jpg")); // NOI18N

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel12.setForeground(new Color(0, 0, 255));
        jLabel12.setText("Inicio de Sesion");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(jPanel2Layout.createSequentialGroup()
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jLabel4)
        							.addComponent(jLabel6)
        							.addComponent(jLabel5))
        						.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(Uid, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        							.addComponent(password)
        							.addComponent(RoleCb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGap(19))
        					.addGroup(jPanel2Layout.createSequentialGroup()
        						.addComponent(jLabel2)
        						.addGap(122))
        					.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        						.addGap(26)
        						.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        						.addGap(76)))
        				.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel7)
        					.addGap(121))))
        		.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
        			.addGap(118)
        			.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(48)
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(21)
        					.addComponent(jLabel12)))
        			.addGap(2)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(RoleCb, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(Uid, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(password, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5))
        			.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addGap(31)
        			.addComponent(jLabel7)
        			.addContainerGap())
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    private JLabel lblLosMejoresPrecios;
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
    	String userRole = RoleCb.getSelectedItem().toString();
        String username = Uid.getText();
        String userPassword = password.getText();

        try {
            String url = "jdbc:mysql://localhost:3306/proyectointegradorsistema";
            String dbUser = "root";
            String dbPassword = "";

            Con = DriverManager.getConnection(url, dbUser, dbPassword);
            St = Con.createStatement();

            if (userRole.equals("Usuario")) {
                String query = "SELECT * FROM usuario WHERE Nombre='" + username + "' AND Contraseña='" + userPassword + "'";
                Rs = St.executeQuery(query);

                if (Rs.next()) {
                    new Ventas().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Id de Usuario o Contraseña Incorrectos");
                }
            } else {
                String query = "SELECT * FROM administrador WHERE Nombre='" + username + "' AND Contraseña='" + userPassword + "'";
                Rs = St.executeQuery(query);

                if (Rs.next()) {
                    new ProductosEnAlmacen().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Id de Administrador o Contraseña Incorrectos");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
