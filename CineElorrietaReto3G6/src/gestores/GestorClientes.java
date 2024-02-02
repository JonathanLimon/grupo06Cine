package gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBUtils.DBUtils;
import pojos.Cliente;

public class GestorClientes {

	public void insertCliente(Cliente cliente) {

		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "insert into cliente (DNI, Nombre, Apellido, Sexo, Contraseña, Usuario) VALUES ('"
					+ cliente.getDNI() + " ','" + cliente.getNombre() + "','" + cliente.getApellido() + "','"
					+ cliente.getSexo() + "','" + cliente.getContraseña() + "','" + cliente.getUsuario() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentar");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentar");
		} finally {
			try {
				if (statement != null)
					statement.close();
				JOptionPane.showMessageDialog(null, "Cliente creado");
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
	}

	public boolean validarLogin(String usuario, String contraseña) {

		boolean ret = false;

		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		Statement statement = null;

		// ResultSet
		ResultSet resultSet = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			statement = connection.createStatement();

			// Montamos la SQL
			String sql = "select * from cliente where usuario = '" + usuario + "' and contraseña = '" + contraseña
					+ "'";

			// La ejecutamos...
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				JOptionPane.showMessageDialog(null, "Usuario y contraseña correctos");
				ret = true;
			} else {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}

}
