
package Vista;

import javax.swing.JFrame;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Usuarios extends JFrame {
	
	private javax.swing.JButton AddBoton;
    private javax.swing.JButton ClearBoton;
    private javax.swing.JButton DeleteBoton;
    private javax.swing.JButton EditBoton;
    private javax.swing.JTextField SelContraseña;
    private javax.swing.JComboBox<String> SelGenero;
    private javax.swing.JTextField SelId;
    private javax.swing.JTextField SelNombre;
    private javax.swing.JTable SellerTabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
	
	public Usuarios() {
		initComponents();
        SelectSeller();
	}
	
	Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    private JLabel lblAdministrador;
    private JLabel lblReportes;
    
    public void SelectSeller()
    {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM usuario");
            java.sql.ResultSetMetaData metaData = Rs.getMetaData();
	        // Column names
	        Vector<String> columnNames = new Vector<>();
	        int columnCount = metaData.getColumnCount();
	        for (int column = 1; column <= columnCount; column++) {
	            columnNames.add(metaData.getColumnName(column));
	        }
	        // Data of the table
	        Vector<Vector<Object>> data = new Vector<>();
	        while (Rs.next()) {
	            Vector<Object> vector = new Vector<>();
	            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	                vector.add(Rs.getObject(columnIndex));
	            }
	            data.add(vector);
	        }
	        DefaultTableModel model = new DefaultTableModel(data, columnNames);
	        SellerTabla.setModel(model);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
	
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SelId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        SelNombre = new javax.swing.JTextField();
        SelContraseña = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        SelGenero = new javax.swing.JComboBox<>();
        AddBoton = new javax.swing.JButton();
        EditBoton = new javax.swing.JButton();
        ClearBoton = new javax.swing.JButton();
        DeleteBoton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SellerTabla = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame6"); // NOI18N

        jPanel2.setBackground(new Color(0, 0, 255));
        jPanel2.setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel12.setForeground(new Color(0, 0, 255));
        jLabel12.setText("USUARIOS");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(0, 0, 255));
        jLabel4.setText("ID");

        SelId.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SelId.setForeground(new Color(0, 0, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(0, 0, 255));
        jLabel5.setText("NOMBRE");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new Color(0, 0, 255));
        jLabel6.setText("CONTRASEÑA");

        SelNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SelNombre.setForeground(new Color(0, 0, 255));

        SelContraseña.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SelContraseña.setForeground(new Color(0, 0, 255));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new Color(0, 0, 255));
        jLabel8.setText("GENERO");

        SelGenero.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SelGenero.setForeground(new Color(0, 0, 255));
        SelGenero.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
        SelGenero.setToolTipText("");

        AddBoton.setBackground(new Color(0, 0, 255));
        AddBoton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        AddBoton.setForeground(new java.awt.Color(255, 255, 255));
        AddBoton.setText("Agregar");
        AddBoton.setBorder(null);
        AddBoton.setBorderPainted(false);
        AddBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBotonMouseClicked(evt);
            }
        });

        EditBoton.setBackground(new Color(0, 0, 255));
        EditBoton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        EditBoton.setForeground(new java.awt.Color(255, 255, 255));
        EditBoton.setText("Modificar");
        EditBoton.setBorder(null);
        EditBoton.setBorderPainted(false);
        EditBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditBotonMouseClicked(evt);
            }
        });

        ClearBoton.setBackground(new Color(0, 0, 255));
        ClearBoton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        ClearBoton.setForeground(new java.awt.Color(255, 255, 255));
        ClearBoton.setText("Limpiar");
        ClearBoton.setBorder(null);
        ClearBoton.setBorderPainted(false);
        ClearBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBotonMouseClicked(evt);
            }
        });

        DeleteBoton.setBackground(new Color(0, 0, 255));
        DeleteBoton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        DeleteBoton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteBoton.setText("Eliminar");
        DeleteBoton.setBorder(null);
        DeleteBoton.setBorderPainted(false);
        DeleteBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteBotonMouseClicked(evt);
            }
        });

        SellerTabla.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        SellerTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "PASSWORD", "GENDER"
            }
        ));
        SellerTabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        SellerTabla.setRowHeight(25);
        SellerTabla.setSelectionBackground(new Color(0, 0, 255));
        SellerTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SellerTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SellerTabla);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel13.setForeground(new Color(0, 0, 255));
        jLabel13.setText("LISTA DE USUARIOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(48)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 701, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(14)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel5)
        								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
        							.addGap(36)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(SelNombre, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        								.addComponent(SelId))
        							.addGap(208)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel6)
        								.addComponent(jLabel8))
        							.addGap(18)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(SelContraseña, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
        								.addComponent(SelGenero, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGap(101)
        							.addComponent(AddBoton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        							.addGap(57)
        							.addComponent(EditBoton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        							.addGap(48)
        							.addComponent(DeleteBoton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        							.addGap(67)
        							.addComponent(ClearBoton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))))
        			.addContainerGap(63, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(0, 346, Short.MAX_VALUE)
        			.addComponent(jLabel13)
        			.addGap(305))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(374, Short.MAX_VALUE)
        			.addComponent(jLabel12)
        			.addGap(361))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel12)
        			.addGap(34)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(SelId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(SelContraseña, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(SelNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(SelGenero, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel8))
        			.addGap(66)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(AddBoton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(DeleteBoton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(ClearBoton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(EditBoton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
        			.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Categorias");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Salir");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        
        lblAdministrador = new JLabel();
        lblAdministrador.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		lblAdministradorMouseClicked();
        	}
        });
        lblAdministrador.setText("Administrador");
        lblAdministrador.setForeground(Color.WHITE);
        lblAdministrador.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
        
        lblReportes = new JLabel();
        lblReportes.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent evt) {
        		lblReportesMouseClicked(evt);
        	}
        });
        lblReportes.setText("Reportes");
        lblReportes.setForeground(Color.WHITE);
        lblReportes.setFont(new Font("Century Gothic", Font.BOLD, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(jPanel2Layout.createSequentialGroup()
        									.addGap(41)
        									.addComponent(jLabel7))
        								.addComponent(lblAdministrador))
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addContainerGap()
        							.addComponent(jLabel2)
        							.addPreferredGap(ComponentPlacement.RELATED)))
        					.addGroup(jPanel2Layout.createSequentialGroup()
        						.addContainerGap()
        						.addComponent(jLabel1)
        						.addPreferredGap(ComponentPlacement.RELATED)))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblReportes, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(26)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(100)
        					.addComponent(lblReportes, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jLabel1)
        					.addGap(18)
        					.addComponent(jLabel2)
        					.addGap(201)
        					.addComponent(lblAdministrador, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jLabel7)))
        			.addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    private void AddBotonMouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here
        if (SelId.getText().isEmpty() || SelNombre.getText().isEmpty() || SelContraseña.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Buscando la Información");
        }
        else
        {
            try
            {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema","root","");
             // Verificar si el usuario ya existe
                String checkQuery = "SELECT * FROM usuario WHERE Nombre=?";
                PreparedStatement checkStatement = Con.prepareStatement(checkQuery);
                checkStatement.setString(1, SelNombre.getText());
                ResultSet resultSet = checkStatement.executeQuery();

                if (resultSet.next()) {
                    // El usuario ya existe
                    JOptionPane.showMessageDialog(this, "El usuario ya existe. Por favor, elija otro nombre de usuario.");
                } else {
                    // El usuario no existe, proceder con la inserción
                    String insertQuery = "INSERT INTO usuario VALUES(?,?,?,?)";
                    PreparedStatement add = Con.prepareStatement(insertQuery);
                    add.setString(1, SelId.getText());
                    add.setString(2, SelNombre.getText());
                    add.setString(3, SelContraseña.getText());
                    add.setString(4, SelGenero.getSelectedItem().toString());
                    
                    int row = add.executeUpdate();
                    if (row > 0) {
                        JOptionPane.showMessageDialog(this, "Usuario agregado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al agregar el usuario.");
                    }

                    Con.close();
                    SelectSeller();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }                                     

    private void SellerTablaMouseClicked(java.awt.event.MouseEvent evt) {                                         
    	int index = SellerTabla.getSelectedRow();
        TableModel model = SellerTabla.getModel();
        String value = model.getValueAt(index, 0).toString();
        System.out.println(value);
        int Myindex = SellerTabla.getSelectedRow();
        SelId.setText(model.getValueAt(Myindex, 0).toString());
        SelNombre.setText(model.getValueAt(Myindex, 1).toString());
        SelContraseña.setText(model.getValueAt(Myindex, 2).toString());
    }                                        

    private void ClearBotonMouseClicked(java.awt.event.MouseEvent evt) {                                        
        SelId.setText("");
        SelNombre.setText("");
        SelContraseña.setText("");
    }                                       

    private void DeleteBotonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        if (SelId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Introduzca el usuario que se eliminara");
        }
        else
        {
        	int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            
            if (option == JOptionPane.YES_OPTION) {
                try {
                    Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema", "root", "");
                    String SId = SelId.getText();
                    
                    // Verificar si el usuario existe
                    String checkQuery = "SELECT * FROM usuario WHERE Codigo=?";
                    PreparedStatement checkStatement = Con.prepareStatement(checkQuery);
                    checkStatement.setString(1, SId);
                    ResultSet resultSet = checkStatement.executeQuery();
                    if (resultSet.next()) {
                        // El usuario existe, proceder con la eliminación
                        String deleteQuery = "DELETE FROM usuario WHERE Codigo=?";
                        PreparedStatement deleteStatement = Con.prepareStatement(deleteQuery);
                        deleteStatement.setString(1, SId);
                        int row = deleteStatement.executeUpdate();
                        if (row > 0) {
                            JOptionPane.showMessageDialog(this, "Usuario eliminado con éxito");
                            SelectSeller();
                        } else {
                            JOptionPane.showMessageDialog(this, "Error al eliminar el usuario");
                        }
                    } else {
                        // El usuario no existe
                        JOptionPane.showMessageDialog(this, "Este usuario no está registrado");
                    }
                    
                    Con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }                                        

    private void EditBotonMouseClicked(java.awt.event.MouseEvent evt) {                                       
        if (SelId.getText().isEmpty()||SelNombre.getText().isEmpty()||SelContraseña.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "informacion faltante");
        }
        else
        {
        	int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea editar este usuario?", "Confirmar edición", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                try {
                    Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema", "root", "");
                    String Query = "UPDATE usuario SET Nombre = ?, Contraseña = ?, Genero = ? WHERE Codigo = ?";
                    PreparedStatement updateStatement = Con.prepareStatement(Query);
                    updateStatement.setString(1, SelNombre.getText());
                    updateStatement.setString(2, SelContraseña.getText());
                    updateStatement.setString(3, SelGenero.getSelectedItem().toString());
                    updateStatement.setString(4, SelId.getText());

                    int row = updateStatement.executeUpdate();

                    if (row > 0) {
                        JOptionPane.showMessageDialog(this, "Usuario actualizado con éxito");
                        SelectSeller();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al actualizar el usuario");
                    }

                    Con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void lblReportesMouseClicked(java.awt.event.MouseEvent evt) {
    	new Reportes().setVisible(true);
        this.dispose();
    }
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        new ProductosEnAlmacen().setVisible(true);
        this.dispose();
    }                                    

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {                                     
        new Categorias().setVisible(true);
        this.dispose();
    }                                    

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {                                     
        new Sesion().setVisible(true);
        this.dispose();
    }
    
    private void lblAdministradorMouseClicked()
    {                                     
        new Administrador().setVisible(true);
        this.dispose();
    }

}
