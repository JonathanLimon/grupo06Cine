package paneles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class VentanaCarrito {

	private JFrame frame;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCarrito window = new VentanaCarrito();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaCarrito() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelCarrito = new JPanel();
		panelCarrito.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelCarrito);
		panelCarrito.setLayout(null);

		JButton btnPagarCarrito = new JButton("Pagar");
		btnPagarCarrito.setBounds(335, 11, 89, 23);
		panelCarrito.add(btnPagarCarrito);

		JButton btnAtrasCarrito = new JButton("Atrás");
		btnAtrasCarrito.setBounds(10, 11, 89, 23);
		panelCarrito.add(btnAtrasCarrito);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Título", "Número de Sala", "Fecha", "Hora", "Precio" }));
		table.setBounds(10, 87, 414, 32);
		table.setToolTipText("");
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCarrito.add(table);

		JLabel lblCarrito = new JLabel("CARRITO");
		lblCarrito.setBounds(162, 28, 89, 48);
		lblCarrito.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCarrito.add(lblCarrito);

		// action Listener
		btnPagarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// panelLogin.setVisible(true);
				panelCarrito.setVisible(false);
			}
		});

		btnAtrasCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// panelSelecionPelicula.setVisible(true);
				panelCarrito.setVisible(false);
			}
		});

	}
}
