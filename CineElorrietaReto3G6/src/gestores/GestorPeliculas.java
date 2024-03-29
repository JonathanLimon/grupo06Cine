package gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBUtils.DBUtils;
import pojos.Pelicula;

public class GestorPeliculas {

	public ArrayList<Pelicula> obtenerPeliculasCine(int codCineBuscado) {
		ArrayList<Pelicula> ret = null;

		String sql = "SELECT DISTINCT Pelicula.Titulo FROM Cine JOIN Sala ON Cine.Codigo = Sala.CodigoCine JOIN Proyeccion ON Sala.Codigo = Proyeccion.CodigoSala JOIN Pelicula ON Proyeccion.CodigoPelicula = Pelicula.Codigo WHERE Cine.Codigo = '"
				+ codCineBuscado + "' Order by Pelicula.titulo";
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
					ret = new ArrayList<Pelicula>();

				Pelicula pelicula = new Pelicula();

				String titulo = resultSet.getString("Titulo");

				pelicula.setTitulo(titulo);

				ret.add(pelicula);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
}
