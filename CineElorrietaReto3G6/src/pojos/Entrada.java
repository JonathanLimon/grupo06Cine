package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class Entrada {

	// Clave primaria
	private int codEntrada = 0;

	// Atributos
	private int codProyeccion = 0;
	private int codRecibo = 0;

	// Relacion 1:N con Proyeccion
	private ArrayList<Proyeccion> proyecciones = null;

	public Entrada() {

	}

	public Entrada(int codEntrada, int codProyeccion, int codRecibo, ArrayList<Proyeccion> proyecciones) {
		this.codEntrada = codEntrada;
		this.codProyeccion = codProyeccion;
		this.codRecibo = codRecibo;
		this.proyecciones = proyecciones;
	}

	public int getCodEntrada() {
		return codEntrada;
	}

	public void setCodEntrada(int codEntrada) {
		this.codEntrada = codEntrada;
	}

	public int getCodProyeccion() {
		return codProyeccion;
	}

	public void setCodProyeccion(int codProyeccion) {
		this.codProyeccion = codProyeccion;
	}

	public int getCodRecibo() {
		return codRecibo;
	}

	public void setCodRecibo(int codRecibo) {
		this.codRecibo = codRecibo;
	}

	public ArrayList<Proyeccion> getProyecciones() {
		return proyecciones;
	}

	public void setProyecciones(ArrayList<Proyeccion> proyecciones) {
		this.proyecciones = proyecciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codEntrada, codProyeccion, codRecibo, proyecciones);
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
		return codEntrada == other.codEntrada && codProyeccion == other.codProyeccion && codRecibo == other.codRecibo
				&& Objects.equals(proyecciones, other.proyecciones);
	}

	@Override
	public String toString() {
		return "Entrada [codEntrada=" + codEntrada + ", codProyeccion=" + codProyeccion + ", codRecibo=" + codRecibo
				+ ", proyecciones=" + proyecciones + "]";
	}

}
