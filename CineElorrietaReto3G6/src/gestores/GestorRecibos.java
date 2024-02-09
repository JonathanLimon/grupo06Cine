package gestores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorRecibos {

	public void imprimirRecibo(String recibo) {

		String rutaArchivo = "recibo.txt";

		try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
			writer.println(recibo);
			System.out.println("String impreso en el archivo correctamente.");
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}
}
