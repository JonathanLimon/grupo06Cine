package gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBUtils.DBUtils;
import pojos.Entrada;

public class GestorEntradas {

	public void insertEntrada(Entrada entrada) {

		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "insert into entrada (codProyeccion, codCliente, FechaCompra) VALUES ('" + entrada.get
					+ "','" + cliente.getNombre() + "','" + cliente.getApellido() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
		} catch (Exception e) {
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
		}
	}

}
