package gestores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorRecibos {

	public void imprimirRecibo(String recibo) {

		String rutaArchivo = "C:\\Users\\%USERNAME%\\Desktop\\recibo.txt";

		try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
			writer.println(recibo);
		} catch (IOException e) {
		}
	}
}
