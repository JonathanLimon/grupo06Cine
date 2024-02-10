package gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		} catch (Exception e) {
			e.printStackTrace(); // Muestra información detallada de la excepción
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
		String sql = "select codigo from cine where nombre = '" + cineNom + "'";
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
		} catch (Exception e) {
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
