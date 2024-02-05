package gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DBUtils.DBUtils;
import pojos.Cine;

public class GestorCines {

	public ArrayList<Cine> obtenerTodosLosCines() {
		ArrayList<Cine> ret = null;

		String sql = "select Nombre, Direccion from cine";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				if (ret == null)
					ret = new ArrayList<Cine>();

				Cine cine = new Cine();

				String nombre = resultSet.getString("Nombre");
				String direccion = resultSet.getString("Direccion");

				cine.setNombre(nombre);
				cine.setDireccion(direccion);

				ret.add(cine);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace(); // Muestra información detallada de la excepción
			JOptionPane.showMessageDialog(null, "ERROR SQL: Vuelve a intentar");
		} catch (Exception e) {
			e.printStackTrace(); // Muestra información detallada de la excepción
			JOptionPane.showMessageDialog(null, "ERROR: Vuelve a intentar");
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public int obtenerCodCinePorNombre(String cineNom) {
		Cine cine = new Cine();
		int ret = 0;
		String sql = "select codigo from t_cine where nombre = '" + cineNom + "'";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				int codCine = resultSet.getInt("codigo");

				cine.setCodCine(codCine);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
		}
		ret = cine.getCodCine();
		return ret;
	}

}
