
package Modelo;

public class Ticket {
	
	public String codigo;
	public int cantidad;
	public double total;
	public String fecha;
	
	public Ticket(String codigo, int cantidad, double total, String fecha) {
		super();
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.total = total;
		this.fecha = fecha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}

