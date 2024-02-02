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

	public ArrayList<Cine> obtenerTodosLosCines(ArrayList<Cine> cine) {
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

				if (null == ret)
					ret = new ArrayList<Cine>();

				Cine cines = new Cine();

				String nombre = resultSet.getString("nombre");
				String direccion = resultSet.getString("direccion");

				cines.setNombre(nombre);
				cines.setDireccion(direccion);

				ret.add(cines);
				cine.add(cines);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentar");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentar");
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
		return ret;
	}

}
