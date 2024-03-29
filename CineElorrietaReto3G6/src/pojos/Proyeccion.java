package pojos;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class Proyeccion {

	// Claves primarias
	private int codProyeccion = 0;

	// Atributos
	private int codSala = 0;
	private int codPelicula = 0;
	private Date fecha = null;
	private Time hora = null;

	public Proyeccion() {

	}

	public Proyeccion(int codProyeccion, int codSala, int codPelicula, Date fecha, Time hora) {
		super();
		this.codProyeccion = codProyeccion;
		this.codSala = codSala;
		this.codPelicula = codPelicula;
		this.fecha = fecha;
		this.hora = hora;
	}

	public int getCodProyeccion() {
		return codProyeccion;
	}

	public void setCodProyeccion(int codProyeccion) {
		this.codProyeccion = codProyeccion;
	}

	public int getCodSala() {
		return codSala;
	}

	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}

	public int getCodPelicula() {
		return codPelicula;
	}

	public void setCodPelicula(int codPelicula) {
		this.codPelicula = codPelicula;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codPelicula, codProyeccion, codSala, fecha, hora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyeccion other = (Proyeccion) obj;
		return codPelicula == other.codPelicula && codProyeccion == other.codProyeccion && codSala == other.codSala
				&& Objects.equals(fecha, other.fecha) && Objects.equals(hora, other.hora);
	}

	@Override
	public String toString() {
		return "Proyeccion [codProyeccion=" + codProyeccion + ", codSala=" + codSala + ", codPelicula=" + codPelicula
				+ ", fecha=" + fecha + ", hora=" + hora + "]";
	}

}
