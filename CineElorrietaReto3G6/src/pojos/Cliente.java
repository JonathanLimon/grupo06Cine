package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

	// Clave primaria
	private int idCliente = 0;

	// Atributos
	private String DNI = null;
	private String nombre = null;
	private String apellido = null;
	private String sexo = null;
	private String usuario = null;
	private String contraseña = null;

	// Relacion 1:N con Entrada
	private ArrayList<Entrada> entradas = null;

	// Relacion 1:N con Recibo
	private ArrayList<Recibo> recibos = null;

	public Cliente() {

	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public ArrayList<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(ArrayList<Entrada> entradas) {
		this.entradas = entradas;
	}

	public ArrayList<Recibo> getRecibos() {
		return recibos;
	}

	public void setRecibos(ArrayList<Recibo> recibos) {
		this.recibos = recibos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI, apellido, idCliente, contraseña, entradas, nombre, recibos, sexo, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(DNI, other.DNI) && Objects.equals(apellido, other.apellido)
				&& idCliente == other.idCliente && Objects.equals(contraseña, other.contraseña)
				&& Objects.equals(entradas, other.entradas) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(recibos, other.recibos) && sexo == other.sexo
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", sexo=" + sexo + ", usuario=" + usuario + ", contraseña=" + contraseña + ", entradas=" + entradas
				+ ", recibos=" + recibos + "]";
	}

}
