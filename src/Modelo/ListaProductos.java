package Modelo;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import java.io.Serializable;

public class ListaProductos implements Serializable {
	
	public ArrayList<Producto> productos;

	public ListaProductos() {
		productos = new ArrayList<>();
	}

	public void agregarProducto(Producto producto) {
		if (buscarProductoPorId(producto.getCodigo()) == null) {
			productos.add(producto);
		}
	}

	public void eliminarProductoPorId(String id) {
		Producto producto = buscarProductoPorId(id);
		if (producto != null) {
			productos.remove(producto);
		}
	}

	public String toLinea() {
		String resultado = "";
		for (Producto producto : productos) {
			resultado += producto.toString() + "\n";
		}
		return resultado;
	}

	public Producto buscarProductoPorId(String id) {
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(id)) {
				return producto;
			}
		}
		return null;
	}

	public String buscarCategoria(String id) {
		Producto producto = buscarProductoPorId(id);
		if (producto != null) {
			return producto.getNombre();
		}
		return null;
	}

	public void cargarProductos(ArrayList<String[]> productosString) {
	    for (String[] productoString : productosString) {
	        try {
	            String idProducto = productoString[0]; 
	            String nombreProducto = productoString[1];
	            int cantidadProducto = Integer.valueOf(productoString[2]);
	            double precioProducto = Double.valueOf(productoString[3]);
	            String categoriaProducto = productoString[4];
	            Producto producto = new Producto(idProducto, nombreProducto, cantidadProducto, precioProducto, categoriaProducto);
	            this.agregarProducto(producto);
	        } catch (ArrayIndexOutOfBoundsException e) {
	            System.err.println("Array incompleto, saltando...");
	        }
	    }
	}

	public DefaultListModel<Producto> generarModeloProductos() {
		DefaultListModel<Producto> modelo = new DefaultListModel<>();
		for (Producto producto : productos) {
			modelo.addElement(producto);
		}
		return modelo;
	}
	
	public ArrayList<Producto> getProductos() {
        return productos;
    }
	
}
