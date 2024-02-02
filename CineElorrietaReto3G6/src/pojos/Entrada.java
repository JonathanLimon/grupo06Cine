package pojos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class Entrada {

	// Clave primaria
	private int codEntrada = 0;

	// Atributos
	private Date fechaCompra = null;
	private float precioTotal = 0;

	// Relacion 1:N con Proyeccion
	private ArrayList<Proyeccion> proyecciones = null;

	// Relacion 1:N con Cliente
	private ArrayList<Cliente> clientes = null;

	public Entrada() {

	}

	public Entrada(int codEntrada, Date fechaCompra, float precioTotal, ArrayList<Proyeccion> proyecciones,
			ArrayList<Cliente> clientes) {
		super();
		this.codEntrada = codEntrada;
		this.fechaCompra = fechaCompra;
		this.precioTotal = precioTotal;
		this.proyecciones = proyecciones;
		this.clientes = clientes;
	}

	public int getCodEntrada() {
		return codEntrada;
	}

	public void setCodEntrada(int codEntrada) {
		this.codEntrada = codEntrada;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public ArrayList<Proyeccion> getProyecciones() {
		return proyecciones;
	}

	public void setProyecciones(ArrayList<Proyeccion> proyecciones) {
		this.proyecciones = proyecciones;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientes, codEntrada, fechaCompra, precioTotal, proyecciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return Objects.equals(clientes, other.clientes) && codEntrada == other.codEntrada
				&& Objects.equals(fechaCompra, other.fechaCompra)
				&& Float.floatToIntBits(precioTotal) == Float.floatToIntBits(other.precioTotal)
				&& Objects.equals(proyecciones, other.proyecciones);
	}

	@Override
	public String toString() {
		return "Entrada [codEntrada=" + codEntrada + ", fechaCompra=" + fechaCompra + ", precioTotal=" + precioTotal
				+ ", proyecciones=" + proyecciones + ", clientes=" + clientes + "]";
	}

}
