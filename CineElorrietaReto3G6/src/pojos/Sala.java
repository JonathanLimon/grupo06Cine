package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class Sala {

	// Clave primaria
	private int codSala = 0;

	// Atributos
	private int numSala = 0;

	// Relacion 1:N con Proyeccion
	private ArrayList<Proyeccion> proyecciones = null;

	// Relacion N:1 con Cine
	private Cine cine = null;

	public Sala() {

	}

	public Sala(int codSala, int numSala, ArrayList<Proyeccion> proyecciones, Cine cine) {
		this.codSala = codSala;
		this.numSala = numSala;
		this.proyecciones = proyecciones;
		this.cine = cine;
	}

	public int getCodSala() {
		return codSala;
	}

	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}

	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}

	public ArrayList<Proyeccion> getProyecciones() {
		return proyecciones;
	}

	public void setProyecciones(ArrayList<Proyeccion> proyecciones) {
		this.proyecciones = proyecciones;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cine, codSala, numSala, proyecciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(cine, other.cine) && codSala == other.codSala && numSala == other.numSala
				&& Objects.equals(proyecciones, other.proyecciones);
	}

	@Override
	public String toString() {
		return "Sala [codSala=" + codSala + ", numSala=" + numSala + ", proyecciones=" + proyecciones + ", cine=" + cine
				+ "]";
	}

}
