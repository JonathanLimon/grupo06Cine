package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class Recibo {

	private static final long serialVersionUID = 8091926587816980311L;

	// Clave primaria
	private int codRecibo = 0;

	// Relacion 1:N con Entrada
	private ArrayList<Entrada> entradas = null;

	// Relacion N:1 con Cliente
	private Cliente cliente = null;

	public Recibo() {

	}

	public int getCodRecibo() {
		return codRecibo;
	}

	public void setCodRecibo(int codRecibo) {
		this.codRecibo = codRecibo;
	}

	public ArrayList<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(ArrayList<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, codRecibo, entradas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recibo other = (Recibo) obj;
		return Objects.equals(cliente, other.cliente) && codRecibo == other.codRecibo
				&& Objects.equals(entradas, other.entradas);
	}

	@Override
	public String toString() {
		return "Recibo [codRecibo=" + codRecibo + ", entradas=" + entradas + ", cliente=" + cliente + "]";
	}

}
