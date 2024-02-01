package gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import DBUtils.DBUtils;
import pojos.Cliente;

public class GestorClientes {

	public void insertEjemplo(Cliente cliente) {

		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "insert into cliente (idCliente, DNI, Nombre, Apellido, Sexo, Contraseña) VALUES (1,'" + cliente.getDNI() + " ','" + 
			cliente.getNombre() + "','" + cliente.getApellido() + "','" + cliente.getSexo() + "','" + cliente.getContraseña() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
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

}
