
package Vista;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import Modelo.Categoria;
import Modelo.ListaCategorias;
import Modelo.ListaProductos;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Categorias extends JFrame {
	
	private javax.swing.JButton Actualizarboton;
    private javax.swing.JButton Addboton;
    private javax.swing.JTextField CatDescripcion;
    private javax.swing.JTextField CatId;
    private javax.swing.JTextField CatNombre;
    private javax.swing.JTable CategoriaTabla;
    private javax.swing.JButton Deleteboton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    ListaCategorias listaCategorias = new ListaCategorias();
	
	public Categorias() {
		initComponents();
		cargarDatos();
        SelectSeller();
	}
	
	Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    private JLabel lblReportes;
    
    public void SelectSeller()
    {
    	try {
    		Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * From categoria");
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
	        CategoriaTabla.setModel(model);
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
        CatId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CatNombre = new javax.swing.JTextField();
        CatDescripcion = new javax.swing.JTextField();
        Addboton = new javax.swing.JButton();
        Actualizarboton = new javax.swing.JButton();
        Actualizarboton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jButton3 = new javax.swing.JButton();
        Deleteboton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CategoriaTabla = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame5"); // NOI18N

        jPanel2.setBackground(new Color(0, 0, 255));
        jPanel2.setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel12.setForeground(new Color(0, 0, 255));
        jLabel12.setText("CATEGORIAS");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(0, 0, 255));
        jLabel4.setText("     ID");

        CatId.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CatId.setForeground(new Color(0, 0, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(0, 0, 255));
        jLabel5.setText("NOMBRE");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new Color(0, 0, 255));
        jLabel6.setText("DESCRIPCION");

        CatNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CatNombre.setForeground(new Color(0, 0, 255));

        CatDescripcion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CatDescripcion.setForeground(new Color(0, 0, 255));

        Addboton.setBackground(new Color(0, 0, 255));
        Addboton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Addboton.setForeground(new java.awt.Color(255, 255, 255));
        Addboton.setText("Agregar");
        Addboton.setBorder(null);
        Addboton.setBorderPainted(false);
        Addboton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddbotonMouseClicked(evt);
            }
        });

        Actualizarboton.setBackground(new Color(0, 0, 255));
        Actualizarboton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Actualizarboton.setForeground(new java.awt.Color(255, 255, 255));
        Actualizarboton.setText("Modificar");
        Actualizarboton.setBorder(null);
        Actualizarboton.setBorderPainted(false);
        Actualizarboton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActualizarbotonMouseClicked(evt);
            }
        });

        jButton3.setBackground(new Color(0, 0, 255));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Limpiar");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        Deleteboton.setBackground(new Color(0, 0, 255));
        Deleteboton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Deleteboton.setForeground(new java.awt.Color(255, 255, 255));
        Deleteboton.setText("Eliminar");
        Deleteboton.setBorder(null);
        Deleteboton.setBorderPainted(false);
        Deleteboton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeletebotonMouseClicked(evt);
            }
        });

        CategoriaTabla.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        CategoriaTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCCION"
            }
        ));
        CategoriaTabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        CategoriaTabla.setRowHeight(25);
        CategoriaTabla.setSelectionBackground(new Color(0, 0, 255));
        CategoriaTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoriaTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CategoriaTabla);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel13.setForeground(new Color(0, 0, 255));
        jLabel13.setText("LISTA DE CATEGORIAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(14, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(14)
        					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(CatId, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(109)
        					.addComponent(Addboton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        					.addGap(32)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel13)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(Actualizarboton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        							.addGap(55)
        							.addComponent(Deleteboton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        							.addGap(57)
        							.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))))
        			.addGap(41))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(0, 58, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel5)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(CatNombre, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
        					.addGap(68))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel6)
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE))
        					.addGap(42))))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(310, Short.MAX_VALUE)
        			.addComponent(jLabel12)
        			.addGap(275))
        		.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        			.addGap(162)
        			.addComponent(CatDescripcion, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel12)
        			.addGap(34)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(CatId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(CatNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(31)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(CatDescripcion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(65)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Addboton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Actualizarboton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Deleteboton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
        			.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Productos");
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
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, jPanel2Layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(jLabel2)
        					.addComponent(jLabel1)
        					.addGroup(jPanel2Layout.createSequentialGroup()
        						.addGap(31)
        						.addComponent(jLabel7)))
        				.addComponent(lblReportes, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
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
        					.addGap(76)
        					.addComponent(jLabel2)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jLabel1)
        					.addGap(18)
        					.addComponent(lblReportes, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jLabel7)))
        			.addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    private void AddbotonMouseClicked(java.awt.event.MouseEvent evt) {                                      
        if (CatId.getText().isEmpty() || CatNombre.getText().isEmpty() || CatDescripcion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta la Información");
        }
        else
        {
        	// Obtener datos de las cajas de texto
            String id = CatId.getText();
            if (listaCategorias.buscarCategoriaPorId(id) != null) {
                JOptionPane.showMessageDialog(this, "La categoría con el código " + id + " ya existe");
            }
            else
            {
	            String nombre = CatNombre.getText();
	            String descripcion = CatDescripcion.getText();
	            // Crear un objeto Categoria
	            Categoria nuevaCategoria = new Categoria(id, nombre, descripcion);
				// Agregar la nueva categoría a la lista
	            listaCategorias.agregarCategoria(nuevaCategoria);
	            // Actualizar la tabla en la interfaz gráfica
	            actualizarTabla();
	            // Guardar la nueva categoría en la base de datos
	            guardarCategoriaEnBaseDeDatos(nuevaCategoria);
	            guardarDatos();
            }
        }
    }                                    
    
    private void actualizarTabla() {
    	DefaultTableModel model = (DefaultTableModel) CategoriaTabla.getModel();
        for (Categoria categoria : listaCategorias.categorias) {
            // Verificar si la categoría ya está presente en la tabla
            boolean categoriaPresente = false;
            for (int i = 0; i < model.getRowCount(); i++) {
            	Object valorCelda = model.getValueAt(i, 0);
            	if (valorCelda != null && valorCelda.equals(categoria.getCodigo())) {
                    categoriaPresente = true;
                    break;
                }
            }
            // Si la categoría no está presente, agregarla a la tabla
            if (!categoriaPresente) {
                model.addRow(new Object[]{categoria.getCodigo(), categoria.getNombre(), categoria.getDescripcion()});
            }
        }
    }
    
    private void guardarCategoriaEnBaseDeDatos(Categoria categoria) {
        try {
            // Establecer la conexión con la base de datos
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            // Preparar la consulta SQL para insertar la nueva categoría
            String query = "INSERT INTO categoria VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = Con.prepareStatement(query);
            preparedStatement.setString(1, categoria.getCodigo());
            preparedStatement.setString(2, categoria.getNombre());
            preparedStatement.setString(3, categoria.getDescripcion());
            // Ejecutar la consulta
            preparedStatement.executeUpdate();
            // Cerrar la conexión
            Con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar en la base de datos");
        }
    }
    
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {                                      
        CatId.setText("");
        CatNombre.setText("");
        CatDescripcion.setText("");
    }                                     

    private void CategoriaTablaMouseClicked(java.awt.event.MouseEvent evt) {                                            
    	int index = CategoriaTabla.getSelectedRow();
        TableModel model = CategoriaTabla.getModel();
        String value = model.getValueAt(index, 0).toString(); // Cambia 0 por el índice de la columna que necesitas
        System.out.println(value);
        int Myindex = CategoriaTabla.getSelectedRow();
        CatId.setText(model.getValueAt(Myindex, 0).toString());
        CatNombre.setText(model.getValueAt(Myindex, 1).toString());
        CatDescripcion.setText(model.getValueAt(Myindex, 2).toString());
    }                                           

    private void DeletebotonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        if (CatId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Introduzca la Categoria que se eliminara");
        }
        else
        {
        	// Obtener el ID de la categoría seleccionada
            String id = CatId.getText();
            // Buscar la categoría por ID en la lista
            Categoria categoria = listaCategorias.buscarCategoriaPorId(id);
            if (categoria == null) {
                JOptionPane.showMessageDialog(this, "La categoría con el código " + id + " no existe");
            } else {
                // Confirmar la eliminación con el usuario
                int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar la categoría?", "Confirmar la eliminación", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    // Eliminar la categoría de la lista
                    listaCategorias.eliminarCategoriaPorId(id);
                    // Actualizar la tabla en la interfaz gráfica
                    quitarCategoriaDeTabla(id);
                    actualizarTabla();
                    // Eliminar la categoría de la base de datos
                    eliminarCategoriaDeBaseDeDatos(id);
                    guardarDatos();
                }
            }
        }
    }
    
    private void quitarCategoriaDeTabla(String id) {
        DefaultTableModel model = (DefaultTableModel) CategoriaTabla.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(id)) {
                model.removeRow(i);
                break; // Salir del bucle después de encontrar y eliminar la categoría
            }
        }
    }
    
    private void eliminarCategoriaDeBaseDeDatos(String id) {
        try {
        	// Establecer la conexión con la base de datos
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            // Preparar la consulta SQL para eliminar la categoría
            String query = "DELETE FROM categoria WHERE Codigo = ?"; // Cambié 'id' a 'ID'
            PreparedStatement preparedStatement = Con.prepareStatement(query);
            preparedStatement.setString(1, id);
            // Ejecutar la consulta
            preparedStatement.executeUpdate();
            // Cerrar la conexión
            Con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar la categoría de la base de datos");
        }
    }
    
    private void ActualizarbotonMouseClicked(java.awt.event.MouseEvent evt) {                                             
        if (CatId.getText().isEmpty()||CatNombre.getText().isEmpty()||CatDescripcion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "informacion faltante");
        }
        else
        {
        	// Obtener datos de las cajas de texto
            String id = CatId.getText();
            // Buscar la categoría por ID en la lista
            Categoria categoria = listaCategorias.buscarCategoriaPorId(id);
            if (categoria == null) {
                JOptionPane.showMessageDialog(this, "La categoría con el código " + id + " no existe");
            } else {
                // Confirmar la actualización con el usuario
                int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea actualizar la categoría?", "Confirmar la actualización", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    // Actualizar la categoría en la lista
                    categoria.setNombre(CatNombre.getText());
                    categoria.setDescripcion(CatDescripcion.getText());
                    // Actualizar la categoría en la tabla
                    actualizarCategoriaEnTabla(categoria);
                    // Actualizar la categoría en la base de datos
                    actualizarCategoriaEnBaseDeDatos(categoria);
                    guardarDatos();
                }
            }
        }
    }                                            
    
    private void actualizarCategoriaEnTabla(Categoria categoria) {
        DefaultTableModel model = (DefaultTableModel) CategoriaTabla.getModel();
        // Buscar la fila correspondiente a la categoría y actualizarla
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(categoria.getCodigo())) {
                model.setValueAt(categoria.getNombre(), i, 1);
                model.setValueAt(categoria.getDescripcion(), i, 2);
                break;
            }
        }
    }
    
    private void actualizarCategoriaEnBaseDeDatos(Categoria categoria) {
        try {
            // Establecer la conexión con la base de datos
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            // Preparar la consulta SQL para actualizar la categoría
            String query = "UPDATE categoria SET Nombre = ?, Descripcion = ? WHERE Codigo = ?";
            PreparedStatement preparedStatement = Con.prepareStatement(query);
            preparedStatement.setString(1, categoria.getNombre());
            preparedStatement.setString(2, categoria.getDescripcion());
            preparedStatement.setString(3, categoria.getCodigo());
            // Ejecutar la consulta
            preparedStatement.executeUpdate();
            // Cerrar la conexión
            Con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar la categoría en la base de datos");
        }
    }
    
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {                                     
        new ProductosEnAlmacen().setVisible(true);
        this.dispose();
    }                                    

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        new Usuarios().setVisible(true);
        this.dispose();
    }
    
    private void lblReportesMouseClicked(java.awt.event.MouseEvent evt) {
    	new Reportes().setVisible(true);
        this.dispose();
    }

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {                                     
        new Sesion().setVisible(true);
        this.dispose();
    }
    
    private void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("categorias.dat"))) {
            ListaCategorias categoriasGuardadas = (ListaCategorias) ois.readObject();
            listaCategorias = categoriasGuardadas;
            actualizarTabla(); // Actualiza la tabla después de cargar los datos
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar los datos.");
        }
    }
    
    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("categorias.dat"))) {
            oos.writeObject(listaCategorias);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los datos.");
        }
    }
	
}
