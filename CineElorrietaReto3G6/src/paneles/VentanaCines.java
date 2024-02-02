package paneles;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaCines {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCines window = new VentanaCines();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaCines() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBackground(SystemColor.text);
		frame.getContentPane().setForeground(SystemColor.text);
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setResizable(false);
		frame.setBounds(100, 100, 580, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelSelecCines = new JPanel();
		panelSelecCines.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(panelSelecCines);
		panelSelecCines.setLayout(null);

		JLabel labelSeleccionCines = new JLabel("Selecciona un Cine");
		labelSeleccionCines.setHorizontalAlignment(SwingConstants.CENTER);
		labelSeleccionCines.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelSeleccionCines.setBounds(33, 69, 241, 57);
		panelSelecCines.add(labelSeleccionCines);

		JLabel seleccionCinesLogo = new JLabel("");
		seleccionCinesLogo.setIcon(new ImageIcon("C:\\Users\\in1dw3\\Desktop\\Ibai\\Reto 3\\bienvenida.png"));
		seleccionCinesLogo.setBounds(376, 11, 137, 156);
		panelSelecCines.add(seleccionCinesLogo);

		JButton seleccionBtnCine1 = new JButton("Cine1\r\n");
		seleccionBtnCine1.setBounds(97, 184, 121, 74);
		panelSelecCines.add(seleccionBtnCine1);

		JButton seleccionBtnCine2 = new JButton("Cine2\r\n");
		seleccionBtnCine2.setBounds(317, 184, 127, 74);
		panelSelecCines.add(seleccionBtnCine2);

		JButton seleccionBtnCine3 = new JButton("Cine3");
		seleccionBtnCine3.setBounds(97, 282, 121, 74);
		panelSelecCines.add(seleccionBtnCine3);

		JButton seleccionBtnCine4 = new JButton("Cine4\r\n");
		seleccionBtnCine4.setBounds(317, 282, 127, 74);
		panelSelecCines.add(seleccionBtnCine4);

		JButton btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.setBounds(221, 392, 96, 38);
		panelSelecCines.add(btnFinalizar);

	}

}