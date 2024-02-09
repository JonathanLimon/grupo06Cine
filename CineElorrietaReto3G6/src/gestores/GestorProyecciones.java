package gestores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DBUtils.DBUtils;
import pojos.Pelicula;
import pojos.Proyeccion;

public class GestorProyecciones {

	public ArrayList<Proyeccion> obtenerFechaPeliculaCine(int codCineBuscado, String nombrePelicula) {
		ArrayList<Proyeccion> ret = null;

		String sql = "SELECT DISTINCT Proyeccion.Fecha FROM Cine JOIN Sala ON Cine.Codigo = Sala.CodigoCine JOIN Proyeccion ON Sala.Codigo = Proyeccion.CodigoSala JOIN Pelicula ON Proyeccion.CodigoPelicula = Pelicula.Codigo WHERE Cine.Codigo = '"
				+ codCineBuscado + "'and Pelicula.titulo = '" + nombrePelicula + "'";
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
					ret = new ArrayList<Proyeccion>();

				Proyeccion proyeccion = new Proyeccion();

				Date fecha = resultSet.getDate("Fecha");

				proyeccion.setFecha(fecha);

				ret.add(proyeccion);
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

	public ArrayList<Proyeccion> obtenerHoraPeliculaCineFecha(int codCineBuscado, String tituloPelicula,
			String fechaElegida) {
		ArrayList<Proyeccion> ret = null;

		String sql = "SELECT DISTINCT Proyeccion.Horario FROM Cine JOIN Sala ON Cine.Codigo = Sala.CodigoCine JOIN Proyeccion ON Sala.Codigo = Proyeccion.CodigoSala JOIN Pelicula ON Proyeccion.CodigoPelicula = Pelicula.Codigo WHERE Cine.Codigo = '"
				+ codCineBuscado + "'and Pelicula.titulo = '" + tituloPelicula + "' and Proyeccion.Fecha = '"
				+ fechaElegida + "'";
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
					ret = new ArrayList<Proyeccion>();

				Proyeccion proyeccion = new Proyeccion();

				Time horario = resultSet.getTime("Horario");

				proyeccion.setHora(horario);

				ret.add(proyeccion);
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
