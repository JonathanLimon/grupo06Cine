package gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DBUtils.DBUtils;
import pojos.Cine;
import pojos.Pelicula;

public class GestorPeliculas {

	public ArrayList<Pelicula> obtenerPeliculasCine(int codCineBuscado) {
		ArrayList<Pelicula> ret = null;

		String sql = "SELECT Pelicula.Titulo, Pelicula.Genero, Pelicula.PrecioPelicula FROM Cine JOIN Sala ON Cine.Codigo = Sala.CodigoCine JOIN Proyeccion ON Sala.Codigo = Proyeccion.CodigoSala JOIN Pelicula ON Proyeccion.CodigoPelicula = Pelicula.Codigo WHERE Cine.Codigo = '"
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
				String genero = resultSet.getString("Genero");
				float precioPelicula = resultSet.getFloat("PrecioPelicula");

				pelicula.setTitulo(titulo);
				pelicula.setGenero(genero);
				pelicula.setPrecio(precioPelicula);

				ret.add(pelicula);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR SQL: Vuelve a intentar");
		} catch (Exception e) {
			e.printStackTrace();
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
}
