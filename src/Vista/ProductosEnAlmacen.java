package Vista;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Modelo.Categoria;
import Modelo.ListaCategorias;
import Modelo.ListaProductos;
import Modelo.Producto;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductosEnAlmacen extends JFrame {
	
	private javax.swing.JButton Addboton;
    private javax.swing.JComboBox<String> CatCb;
    private javax.swing.JButton Deleteboton;
    private javax.swing.JTextField ProdCantidad;
    private javax.swing.JTextField ProdId;
    private javax.swing.JTextField ProdNombre;
    private javax.swing.JTextField ProdPrecio;
    private javax.swing.JTable ProductoTabla;
    private javax.swing.JButton Updateboton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    ListaProductos listaProductos = new ListaProductos();
    ListaCategorias listaCategorias;
    private Map<String, JLabel> mapaLabelProductos = new HashMap<>();
	
	public ProductosEnAlmacen() {
		listaCategorias = new ListaCategorias();
		initComponents();
		cargarDatos();
        SelectSeller();
        GetCat();
	}
	
	public static void main(String parametro[]) 
	{
		ProductosEnAlmacen ventana = new ProductosEnAlmacen();
		ventana.setVisible(true);
	}
	
	Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    private JLabel lblReportes;
    private JLabel lblNewLabel;
    
    public void SelectSeller()
    {
        try {
        	Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from producto");
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
	        ProductoTabla.setModel(model);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void GetCat()
    {
    	try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC","root","");
            St = Con.createStatement();
            String query = "Select * from categoria";
            Rs = St.executeQuery(query);
            while (Rs.next())
            {
                String Mycat = Rs.getString("Nombre");
                CatCb.addItem(Mycat);
            }
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
        ProdId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ProdPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ProdNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ProdCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CatCb = new javax.swing.JComboBox<>();
        Addboton = new javax.swing.JButton();
        Updateboton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Deleteboton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductoTabla = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame3"); // NOI18N

        jPanel2.setBackground(new Color(0, 0, 255));
        jPanel2.setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel12.setForeground(new Color(0, 0, 255));
        jLabel12.setText("Productos En Almacen");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(0, 0, 255));
        jLabel4.setText("    ID");

        ProdId.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProdId.setForeground(new Color(0, 0, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(0, 0, 255));
        jLabel5.setText("NOMBRE");

        ProdPrecio.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProdPrecio.setForeground(new Color(0, 0, 255));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new Color(0, 0, 255));
        jLabel6.setText("CANTIDAD");

        ProdNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProdNombre.setForeground(new Color(0, 0, 255));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new Color(0, 0, 255));
        jLabel7.setText("PRECIO");

        ProdCantidad.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProdCantidad.setForeground(new Color(0, 0, 255));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new Color(0, 0, 255));
        jLabel8.setText("CATEGORIA");

        CatCb.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CatCb.setForeground(new Color(0, 0, 255));
        CatCb.setToolTipText("");

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

        Updateboton.setBackground(new Color(0, 0, 255));
        Updateboton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Updateboton.setForeground(new java.awt.Color(255, 255, 255));
        Updateboton.setText("Modificar");
        Updateboton.setBorder(null);
        Updateboton.setBorderPainted(false);
        Updateboton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdatebotonMouseClicked(evt);
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

        ProductoTabla.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ProductoTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "CANTIDAD", "PRECIO", "CATEGORIA"
            }
        ));
        ProductoTabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ProductoTabla.setRowHeight(25);
        ProductoTabla.setSelectionBackground(new Color(0, 0, 255));
        ProductoTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductoTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductoTabla);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel13.setForeground(new Color(0, 0, 255));
        jLabel13.setText("LISTA DE PRODUCTOS");
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

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
        							.addGap(101)
        							.addComponent(Addboton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        							.addGap(26)
        							.addComponent(Updateboton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addComponent(jLabel8)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(CatCb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(jLabel5)
        										.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
        									.addGap(36)
        									.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        										.addComponent(ProdNombre, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
        										.addComponent(ProdId, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))))
        							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addComponent(jLabel6)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(ProdCantidad, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        								.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        									.addComponent(jLabel7)
        									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(Deleteboton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        										.addComponent(ProdPrecio, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))))))
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGap(41)
        							.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))))
        			.addContainerGap(66, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(0, 312, Short.MAX_VALUE)
        			.addComponent(jLabel12)
        			.addGap(283))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(330, Short.MAX_VALUE)
        			.addComponent(jLabel13)
        			.addGap(280))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel12)
        					.addGap(34)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(ProdId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ProdCantidad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ProdNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ProdPrecio, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel8)
        						.addComponent(CatCb, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Addboton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Updateboton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Deleteboton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
        			.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Categorias");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Salir");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Usuarios");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
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
        				.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        					.addGap(47)
        					.addComponent(jLabel15)
        					.addGap(26))
        				.addComponent(jLabel16)
        				.addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lblReportes, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(157)
        					.addComponent(jLabel16)
        					.addGap(26)
        					.addComponent(lblReportes, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        					.addGap(28)
        					.addComponent(jLabel14)
        					.addPreferredGap(ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
        					.addComponent(jLabel15))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(32)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }
    
    private void AddbotonMouseClicked(java.awt.event.MouseEvent evt) {                                      
        if (ProdId.getText().isEmpty() || ProdNombre.getText().isEmpty() || ProdCantidad.getText().isEmpty()|| ProdPrecio.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta la Información");
        }
        else
        {
        	// Obtener datos de las cajas de texto
            String codigo = ProdId.getText();
            if (listaProductos.buscarProductoPorId(codigo) != null) {
                JOptionPane.showMessageDialog(this, "El prducto con el código " + codigo + " ya existe");
            }
            else
            {
	            String nombre = ProdNombre.getText();
	            int cantidad = Integer.valueOf(ProdCantidad.getText());
	            double precio = Double.valueOf(ProdPrecio.getText());
	            String categoria = CatCb.getSelectedItem().toString();
	            Producto nuevoProducto = new Producto(codigo, nombre, cantidad, precio, categoria);
	            listaProductos.agregarProducto(nuevoProducto);
	            actualizarTabla();
	            guardarProductoEnBaseDeDatos(nuevoProducto);
	            guardarDatos();
            }
        }
    }
    
    private void actualizarTabla() {
    	DefaultTableModel model = (DefaultTableModel) ProductoTabla.getModel();
        for (Producto producto : listaProductos.productos) {
            boolean productoPresente = false;
            for (int i = 0; i < model.getRowCount(); i++) {
            	Object valorCelda = model.getValueAt(i, 0);
            	if (valorCelda != null && valorCelda.equals(producto.getCodigo())) {
                    productoPresente = true;
                    break;
                }
            }
            if (!productoPresente) {
                model.addRow(new Object[]{producto.getCodigo(), producto.getNombre(), producto.getCantidad(), producto.getPrecio(), producto.getCategoria()});
            }
        }
    }
    
    private void guardarProductoEnBaseDeDatos(Producto producto) {
        try {
            // Establecer la conexión con la base de datos
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            // Preparar la consulta SQL para insertar la nueva categoría
            String query = "INSERT INTO producto VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = Con.prepareStatement(query);
            preparedStatement.setString(1, producto.getCodigo());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setInt(3, producto.getCantidad());
            preparedStatement.setDouble(4, producto.getPrecio());
            preparedStatement.setString(5, producto.getCategoria());
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
        ProdId.setText("");
        ProdNombre.setText("");
        ProdCantidad.setText("");
        ProdPrecio.setText("");
    }                                     

    private void UpdatebotonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        if (ProdId.getText().isEmpty()||ProdNombre.getText().isEmpty()||ProdCantidad.getText().isEmpty()||ProdPrecio.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta la Información");
        }
        else
        {
            String codigo = ProdId.getText();
            Producto producto = listaProductos.buscarProductoPorId(codigo);
            if (producto == null) {
                JOptionPane.showMessageDialog(this, "El producto con el código " + codigo + " no existe");
            } else {
                int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea actualizar el producto?", "Confirmar la actualización", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    producto.setNombre(ProdNombre.getText());
                    producto.setCantidad(Integer.valueOf(ProdCantidad.getText()));
                    producto.setPrecio(Double.valueOf(ProdPrecio.getText()));
                    producto.setCategoria((String) CatCb.getSelectedItem());
                    // Actualizar la categoría en la tabla
                    actualizarProductoEnTabla(producto);
                    // Actualizar la categoría en la base de datos
                    actualizarProductoEnBaseDeDatos(producto);
                    guardarDatos();
                }
            }
        }
    }
    
    private void actualizarProductoEnTabla(Producto producto) {
        DefaultTableModel model = (DefaultTableModel) ProductoTabla.getModel();
        // Buscar la fila correspondiente a la categoría y actualizarla
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(producto.getCodigo())) {
                model.setValueAt(producto.getNombre(), i, 1);
                model.setValueAt(producto.getCantidad(), i, 2);
                model.setValueAt(producto.getPrecio(), i, 3);
                model.setValueAt(producto.getCategoria(), i, 4);
                break;
            }
        }
    }
    
    private void actualizarProductoEnBaseDeDatos(Producto producto) {
        try {
            // Establecer la conexión con la base de datos
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            // Preparar la consulta SQL para actualizar la categoría
            String query = "UPDATE producto SET Nombre = ?, Cantidad = ?, Precio = ?, Categoria = ? WHERE Codigo = ?";
            PreparedStatement preparedStatement = Con.prepareStatement(query);
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setInt(2, producto.getCantidad());
            preparedStatement.setDouble(3, producto.getPrecio());
            preparedStatement.setString(4, producto.getCategoria());
            preparedStatement.setString(5, producto.getCodigo());
            preparedStatement.executeUpdate();
            Con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar el producto en la base de datos");
        }
    }
    
    private void DeletebotonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        if (ProdId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Introduzca el producto que se eliminara");
        }
        else
        {
            String codigo = ProdId.getText();
            Producto producto = listaProductos.buscarProductoPorId(codigo);
            if (producto == null) {
                JOptionPane.showMessageDialog(this, "El Producto con el código " + codigo + " no existe");
            } else {
                int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el producto?", "Confirmar la eliminación", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    listaProductos.eliminarProductoPorId(codigo);
                    quitarProductoDeTabla(codigo);
                    actualizarTabla();
                    eliminarProductoDeBaseDeDatos(codigo);
                    guardarDatos();
                }
            }
        }
    }
    
    private void quitarProductoDeTabla(String id) {
        DefaultTableModel model = (DefaultTableModel) ProductoTabla.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(id)) {
                model.removeRow(i);
                break;
            }
        }
    }
    
     private void eliminarProductoDeBaseDeDatos(String id) {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            String query = "DELETE FROM producto WHERE Codigo = ?";
            PreparedStatement preparedStatement = Con.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            Con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar la categoría de la base de datos");
        }
    }
    
    private void ProductoTablaMouseClicked(java.awt.event.MouseEvent evt) {                                           
    	int index = ProductoTabla.getSelectedRow();
        TableModel model = ProductoTabla.getModel();
        String value = model.getValueAt(index, 0).toString(); // Cambia 0 por el índice de la columna que necesitas
        System.out.println(value);
        int Myindex = ProductoTabla.getSelectedRow();
        ProdId.setText(model.getValueAt(Myindex, 0).toString());
        ProdNombre.setText(model.getValueAt(Myindex, 1).toString());
        ProdCantidad.setText(model.getValueAt(Myindex, 2).toString());
        ProdPrecio.setText(model.getValueAt(Myindex, 3).toString());
    }                                      
    
    private void actualizarImagenProducto(JLabel labelProducto, String rutaImagen) {
        if (labelProducto != null) {
            ImageIcon imagen = new ImageIcon(rutaImagen);
            Image image = imagen.getImage().getScaledInstance(labelProducto.getWidth(), labelProducto.getHeight(), Image.SCALE_SMOOTH);
            labelProducto.setIcon(new ImageIcon(image));
        } else {
            System.out.println("Error: labelProducto es nulo");
        }
    }
    
    private JLabel obtenerLabelProducto(Producto producto) {
        return mapaLabelProductos.get(producto.getCodigo());
    }
    
    private void inicializarMapaLabelProductos() {
    	mapaLabelProductos.clear();
        for (Producto producto : listaProductos.getProductos()) {
        	lblNewLabel = new JLabel("Imagen");
        	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            // Ajusta el tamaño según tus necesidades
        	lblNewLabel.setSize(100, 100);
            mapaLabelProductos.put(producto.getCodigo(), lblNewLabel);
        }
    }
    
    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {                                      
        new Usuarios().setVisible(true);
        this.dispose();
    }
    
    private void lblReportesMouseClicked(java.awt.event.MouseEvent evt)
    {
    	new Reportes().setVisible(true);
        this.dispose();
    }
    
    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {                                      
        new Categorias().setVisible(true);
        this.dispose();
    }                                     

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {                                      
        new Sesion().setVisible(true);
        this.dispose();
    }
    
    private void cargarImagenProducto(Producto producto) {
        if (producto.getImagen() != null && !producto.getImagen().isEmpty()) {
            ImageIcon imagen = new ImageIcon(producto.getImagen());
            Image image = imagen.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
            lblNewLabel.setIcon(new ImageIcon(image));
        }
    }
    
    private void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productos.dat"))) {
            ListaProductos productosGuardados = (ListaProductos) ois.readObject();
            listaProductos = productosGuardados;
            actualizarTabla(); // Actualiza la tabla después de cargar los datos
            // Ahora también carga la ruta de la imagen para cada producto
            for (Producto producto : listaProductos.getProductos()) {
                cargarImagenProducto(producto);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar los datos.");
        }
    }
    
    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productos.dat"))) {
            oos.writeObject(listaProductos);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los datos.");
        }
    }
}
