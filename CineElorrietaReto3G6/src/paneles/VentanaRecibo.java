package paneles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

public class VentanaRecibo {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRecibo window = new VentanaRecibo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaRecibo() {
		initialize();
	}

	private void initialize() {
		
		CrearUsuario cu = new CrearUsuario();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelRecibo = new JPanel();
		panelRecibo.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(panelRecibo);
		panelRecibo.setLayout(null);
		
		JButton btnImprimirRecibo = new JButton("IMPRIMIR RECIBO");
		btnImprimirRecibo.setBounds(197, 156, 145, 42);
		panelRecibo.add(btnImprimirRecibo);
		
		JLabel lblTituloRecibo = new JLabel("RECIBO");
		lblTituloRecibo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloRecibo.setBounds(228, 7, 78, 53);
		panelRecibo.add(lblTituloRecibo);
		
		JLabel lblPrecio = new JLabel("Precio Total:");
		lblPrecio.setBounds(197, 104, 66, 21);
		panelRecibo.add(lblPrecio);
		
		JLabel lblImagenRecibo = new JLabel("");
		lblImagenRecibo.setBounds(194, 248, 159, 165);
		panelRecibo.add(lblImagenRecibo);
		
		JLabel lblPrecioTotal = new JLabel("");
		lblPrecioTotal.setBounds(284, 111, 46, 14);
		panelRecibo.add(lblPrecioTotal);
	}
}