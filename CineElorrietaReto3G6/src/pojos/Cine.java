package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class Cine {

	private int codCine = 0;

	private String nombre = null;
	private String direccion = null;

	// Relacion 1:N con Sala
	private ArrayList<Sala> salas = null;

	public Cine() {
		
	}
	
	public int getCodCine() {
		return codCine;
	}

	public void setCodCine(int codCine) {
		this.codCine = codCine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCine, direccion, nombre, salas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return codCine == other.codCine && Objects.equals(direccion, other.direccion)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(salas, other.salas);
	}

	@Override
	public String toString() {
		return "Cine [codCine=" + codCine + ", nombre=" + nombre + ", direccion=" + direccion + ", salas=" + salas
				+ "]";
	}

}
