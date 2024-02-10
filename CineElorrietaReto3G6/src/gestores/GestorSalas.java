package gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBUtils.DBUtils;
import pojos.Sala;

public class GestorSalas {

	public int obtenerCodSala(int codCineBuscado, String tituloBuscado, String fechaBuscada) {
		Sala sala = new Sala();
		int ret = 0;
		String sql = "SELECT Sala.codigo FROM Sala JOIN Proyeccion ON Sala.Codigo = Proyeccion.CodigoSala JOIN Pelicula ON Proyeccion.CodigoPelicula = Pelicula.Codigo WHERE Sala.CodigoCine = '"
				+ codCineBuscado + "' AND Pelicula.Titulo = '" + tituloBuscado + "' AND Proyeccion.Fecha = '"
				+ fechaBuscada + "'";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				int codigo = resultSet.getInt("Codigo");

				sala.setCodSala(codigo);

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
		ret = sala.getCodSala();
		return ret;
	}

}
