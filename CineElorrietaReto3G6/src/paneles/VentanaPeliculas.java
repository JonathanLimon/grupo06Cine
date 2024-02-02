package paneles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.Color;
import java.awt.SystemColor;

public class VentanaPeliculas {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPeliculas window = new VentanaPeliculas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPeliculas() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelSelecPelis = new JPanel();
		panelSelecPelis.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(panelSelecPelis);
		panelSelecPelis.setLayout(null);

		JLabel labelSeleccionPelis = new JLabel("Selecciona una Pelicula");
		labelSeleccionPelis.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelSeleccionPelis.setBounds(43, 101, 250, 37);
		panelSelecPelis.add(labelSeleccionPelis);

		JLabel labelLogoPelis = new JLabel("");
		labelLogoPelis.setIcon(new ImageIcon("C:\\Users\\in1dw3\\Desktop\\Ibai\\Reto 3\\bienvenida.png"));
		labelLogoPelis.setBounds(362, 11, 192, 188);
		panelSelecPelis.add(labelLogoPelis);

		JList listaPeliculas = new JList();
		listaPeliculas.setForeground(SystemColor.text);
		listaPeliculas.setBackground(new Color(0, 0, 0));
		listaPeliculas.setBounds(298, 406, -261, -221);
		panelSelecPelis.add(listaPeliculas);
	}
}