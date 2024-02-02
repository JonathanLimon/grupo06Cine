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

public class VentanaBienvenida {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBienvenida window = new VentanaBienvenida();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaBienvenida() {
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

		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(panelBienvenida);
		panelBienvenida.setLayout(null);

		JButton botonBienvenida = new JButton("\r\n\r\n\r\n\r\nBIENVENIDO\r\n");

		botonBienvenida.setIcon(new ImageIcon("C:\\Users\\in1dw3\\Desktop\\Ibai\\Reto 3\\bienvenida.png"));
		botonBienvenida.setBounds(0, 0, 564, 441);
		botonBienvenida.setForeground(Color.BLACK);
		botonBienvenida.setFont(new Font("Yu Gothic", Font.PLAIN, 50));
		botonBienvenida.setBackground(new Color(255, 255, 240));
		panelBienvenida.add(botonBienvenida);

	}

}