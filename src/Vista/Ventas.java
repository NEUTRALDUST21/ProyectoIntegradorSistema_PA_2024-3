package Vista;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Modelo.Ticket;

import java.awt.Color;
import java.awt.print.PrinterAbortException;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.util.Date;

public class Ventas extends JFrame {
	
	private javax.swing.JButton Addboton;
    private javax.swing.JTextArea BillTxt;
    private javax.swing.JComboBox<String> CatCb;
    private javax.swing.JButton Filterboton;
    private javax.swing.JLabel Grdtotallbl;
    private javax.swing.JTextField ProdCantidad;
    private javax.swing.JTextField ProdNombre;
    private javax.swing.JTable ProductoTabla;
    private javax.swing.JButton Refreshboton;
    private javax.swing.JButton Updateboton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    static String fecha;
	
	public Ventas() {
		initComponents();
        SelectSeller();
        GetCat();
	}
	
	public static void main(String parametro[]) 
	{
		Ventas ventana = new Ventas();
		ventana.setVisible(true);
	}
	
	Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ProdNombre = new javax.swing.JTextField();
        ProdCantidad = new javax.swing.JTextField();
        CatCb = new javax.swing.JComboBox<>();
        Addboton = new javax.swing.JButton();
        Addboton.setText("Añadir a la factura");
        Updateboton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Refreshboton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductoTabla = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillTxt = new javax.swing.JTextArea();
        Grdtotallbl = new javax.swing.JLabel();
        Filterboton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new Color(0, 0, 255));
        jPanel2.setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel12.setForeground(new Color(0, 0, 255));
        jLabel12.setText("Punto De Venta");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(0, 0, 255));
        jLabel5.setText("NOMBRE");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new Color(0, 0, 255));
        jLabel6.setText("CANTIDAD");

        ProdNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProdNombre.setForeground(new Color(0, 0, 255));

        ProdCantidad.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProdCantidad.setForeground(new Color(0, 0, 255));

        CatCb.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CatCb.setForeground(new Color(0, 0, 255));
        CatCb.setToolTipText("");
        CatCb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CatCbMouseClicked(evt);
            }
        });

        Addboton.setBackground(new Color(0, 0, 255));
        Addboton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Addboton.setForeground(new java.awt.Color(255, 255, 255));
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
        Updateboton.setText("Imprimir");
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

        Refreshboton.setBackground(new Color(0, 0, 255));
        Refreshboton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Refreshboton.setForeground(new java.awt.Color(255, 255, 255));
        Refreshboton.setText("Refrescar");
        Refreshboton.setBorder(null);
        Refreshboton.setBorderPainted(false);
        Refreshboton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RefreshbotonItemStateChanged(evt);
            }
        });
        Refreshboton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshbotonMouseClicked(evt);
            }
        });

        ProductoTabla.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ProductoTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "QUANTITY", "PRICE", "CATEGORY"
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
        jLabel13.setText("LISTA PRODUCTOS");

        BillTxt.setColumns(20);
        BillTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        BillTxt.setRows(5);
        jScrollPane2.setViewportView(BillTxt);

        Grdtotallbl.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        Grdtotallbl.setForeground(new Color(0, 0, 255));
        Grdtotallbl.setText("Rs");

        Filterboton.setBackground(new Color(0, 0, 255));
        Filterboton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Filterboton.setForeground(new java.awt.Color(255, 255, 255));
        Filterboton.setText("Filtrar");
        Filterboton.setBorder(null);
        Filterboton.setBorderPainted(false);
        Filterboton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilterbotonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(0, 341, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel12)
        					.addGap(303))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(Updateboton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        					.addGap(158))))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(Addboton)
        					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
        					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(28)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel5)
        							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
        							.addComponent(ProdNombre, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel6)
        							.addGap(18)
        							.addComponent(ProdCantidad, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))))
        			.addGap(82)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
        						.addContainerGap())
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        							.addComponent(CatCb, 0, 179, Short.MAX_VALUE)
        							.addComponent(jLabel13))
        						.addPreferredGap(ComponentPlacement.UNRELATED)
        						.addComponent(Filterboton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(Refreshboton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        						.addGap(23)))))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(581, Short.MAX_VALUE)
        			.addComponent(Grdtotallbl)
        			.addGap(194))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel12)
        			.addGap(34)
        			.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(4)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ProdNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ProdCantidad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        					.addGap(76)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(Addboton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(25)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(CatCb, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        						.addComponent(Filterboton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        						.addComponent(Refreshboton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(Grdtotallbl)
        			.addGap(13)
        			.addComponent(Updateboton)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Salir");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap(39, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addGap(18)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
        			.addGap(51))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(22)
        					.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(91)
        					.addComponent(jLabel1)))
        			.addContainerGap())
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
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    public static String Fecha()
	{
		Date fecha=new Date();
		SimpleDateFormat formatodia=new SimpleDateFormat("dd-MM-yyyy");
		return formatodia.format(fecha);
	}
    
    public void SelectSeller()
    {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema","root","");
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
    String Prid;
    int newCantidad;
    public void update()
    {
    	
        try {
        	newCantidad = AvailCantidad - Integer.valueOf(ProdCantidad.getText());
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema","root","");
            String Query = "UPDATE producto SET Cantidad = " + newCantidad + "" + " WHERE Codigo = " + Prid;
            Statement Add = Con.createStatement();
            Add.executeUpdate(Query);
            //JOptionPane.showMessageDialog(this, "Producto Actualizado");
            
            SelectSeller();
        }
        catch (SQLException e)
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

    Double Uprice, ProdTotal=0.0, GrdTotal=0.0;
    int AvailCantidad;
    
    private void ProductoTablaMouseClicked(java.awt.event.MouseEvent evt) {                                           
    	try {
    		int row = ProductoTabla.getSelectedRow();
            if (row < 0 || ProductoTabla.getColumnCount() < 4) {
                return;
            }

            String idProducto = ProductoTabla.getModel().getValueAt(row, 0).toString();
            String nombreCategoria = ProductoTabla.getModel().getValueAt(row, 1).toString();
            int Myindex = row;

            if (ProductoTabla.getColumnCount() >= 3) {
                String availCantidadStr = ProductoTabla.getModel().getValueAt(Myindex, 2).toString();
                if (availCantidadStr != null && availCantidadStr.matches("\\d+")) {
                    AvailCantidad = Integer.valueOf(availCantidadStr);
                }
            }
            
            ProdNombre.setText(ProductoTabla.getModel().getValueAt(Myindex, 1).toString());
            String upriceStr = ProductoTabla.getModel().getValueAt(Myindex, 3).toString();
            double Uprice = upriceStr.isEmpty() ? 0.0 : Double.valueOf(upriceStr);

            // Almacena las cantidades y precios en variables globales para que estén disponibles
            // cuando se haga clic en el botón Addboton
            this.Uprice = Uprice;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }                                          

    private void RefreshbotonMouseClicked(java.awt.event.MouseEvent evt) {                                          
        SelectSeller();
    }                                         

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        ProdNombre.setText("");
        ProdCantidad.setText("");
    }
    
    private void UpdatebotonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        try {
        	fecha = Fecha();
            BillTxt.print();
            String codigoTicket = "Tic" + i + "_" + fecha;
            String nuevaFecha = Fecha();
            
            // Si la fecha es diferente, reiniciar el contador i
            if (!nuevaFecha.equals(fecha)) {
                fecha = nuevaFecha;
                i = 1;
            } else {
            	// Comprobar si el código ya existe en la base de datos
                codigoTicket = "Tic" + i + "_" + fecha;
                while (codigoExisteEnBaseDeDatos(codigoTicket)) {
                    i++;
                    codigoTicket = "Tic" + i + "_" + fecha;
                }
                i++;
            }
            double totalVenta = GrdTotal;
            // Calcular la cantidad de productos comprados
            int cantidadProductos = 0;
            
            cantidadProductos += Integer.valueOf(ProdCantidad.getText());
            // Crear un nuevo objeto Ticket
            
            insertarTicketEnBaseDeDatos(codigoTicket, cantidadProductos, totalVenta, fecha);
            
            System.out.println(codigoTicket + " , " + cantidadProductos + " , " + totalVenta + " , " + fecha);
        }
        catch (PrinterAbortException pae) {
            pae.printStackTrace();
            // Puedes agregar mensajes o lógica de manejo de errores aquí
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
    }
    
    private void insertarTicketEnBaseDeDatos(String codigo, int cantidad, double total, String fecha) {
        try {
        	Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            // Preparar la consulta SQL para insertar la nueva categoría
            String query = "INSERT INTO reporte VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = Con.prepareStatement(query);
            preparedStatement.setString(1, codigo);
            preparedStatement.setInt(2, cantidad);
            preparedStatement.setDouble(3, total);
            preparedStatement.setString(4, fecha);
            // Ejecutar la consulta
            preparedStatement.executeUpdate();
            // Cerrar la conexión
            Con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Puedes agregar mensajes o lógica de manejo de errores aquí
        }
    }
    
    private boolean codigoExisteEnBaseDeDatos(String codigo) {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            String query = "SELECT COUNT(*) FROM reporte WHERE Codigo = ?";
            PreparedStatement preparedStatement = Con.prepareStatement(query);
            preparedStatement.setString(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int count = resultSet.getInt(1);

            Con.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Puedes agregar mensajes o lógica de manejo de errores aquí
        }
        return false;
    }
    
    int i=0;
    private void AddbotonMouseClicked(java.awt.event.MouseEvent evt) {                                      
        if (ProdCantidad.getText().isEmpty()||ProdNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Falta de Informacion");
        }
        else if (AvailCantidad <= Integer.valueOf(ProdCantidad.getText()))
        {
            JOptionPane.showMessageDialog(this, "No hay suficiente Stock");
        }
        else
        {
            i++;
            ProdTotal = Uprice * Double.valueOf(ProdCantidad.getText());
            GrdTotal = GrdTotal + ProdTotal;
            if (i==1)
            {
                BillTxt.setText(BillTxt.getText()+"               ************* Venta Ticket Tienda *************                    \n"+" Num     Producto               Precio Cantidad Total\n"+i+"     "+ProdNombre.getText()+"    "+Uprice+"    "+ProdCantidad.getText()+"    "+ProdTotal+"\n");
            }
            else
            {
                BillTxt.setText(BillTxt.getText()+i+"         "+ProdNombre.getText()+"      "+Uprice+"        "+ProdCantidad.getText()+"   "+ProdTotal+"\n");
            }
            Grdtotallbl.setText("Rs: $"+GrdTotal);
            update();
        }
    }
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        new Sesion().setVisible(true);
        this.dispose();
    }                                    

    private void CatCbMouseClicked(java.awt.event.MouseEvent evt) {                                   
    	try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from producto where Nombre = '"+CatCb.getSelectedItem().toString()+"'");
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

    private void RefreshbotonItemStateChanged(java.awt.event.ItemEvent evt) {                                              
        try
        {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from categoria where Nombre='" + CatCb.getSelectedItem().toString().replace("'", "''") + "'");
            // Construir el modelo de tabla directamente desde el ResultSet
            DefaultTableModel model = new DefaultTableModel();
            ResultSetMetaData metaData = Rs.getMetaData();

            // Añadir las columnas al modelo
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                model.addColumn(metaData.getColumnName(column));
            }

            // Añadir las filas al modelo
            while (Rs.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = Rs.getObject(columnIndex);
                }
                model.addRow(row);
            }

            // Establecer el modelo en la tabla
            ProductoTabla.setModel(model);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }                                          

    private void FilterbotonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from categoria where Nombre='" + CatCb.getSelectedItem().toString().replace("'", "''") + "'");
            // Construir el modelo de tabla directamente desde el ResultSet
            DefaultTableModel model = new DefaultTableModel();
            ResultSetMetaData metaData = Rs.getMetaData();

            // Añadir las columnas al modelo
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                model.addColumn(metaData.getColumnName(column));
            }

            // Añadir las filas al modelo
            while (Rs.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = Rs.getObject(columnIndex);
                }
                model.addRow(row);
            }

            // Establecer el modelo en la tabla
            ProductoTabla.setModel(model);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
