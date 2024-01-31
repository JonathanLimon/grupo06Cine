package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import gestores.GestorCines;
import gestores.GestorEntradas;
import gestores.GestorPeliculas;
import gestores.GestorProyecciones;
import gestores.GestorSalas;
import pojos.Cine;
import pojos.Pelicula;
import pojos.Proyeccion;

public class VentanaPrincipalIbai {

	private JFrame frame;

	private GestorCines gestorCines = new GestorCines();
	private GestorPeliculas gestorPeliculas = new GestorPeliculas();
	private GestorProyecciones gestorProyecciones = new GestorProyecciones();
	private GestorSalas gestorSalas = new GestorSalas();
	private GestorEntradas gestorEntradas = new GestorEntradas();

	public String tituloSeleccionado = null;
	public Date fechaSeleccionada = null;
	public Time horaSeleccionada = null;
	public Float precioSeleccionado = null;
	public String nombreCine = null;

	public int numSalaSeleccionada = 0;
	public int codCine = 0;
	private int codProyeccion = 0;

	public Float precioTotal = null;

	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	DefaultTableModel model = new DefaultTableModel();
	private JTextField txtNombre = null;
	private JTextField txtApellido = null;
	private JTextField txtDni = null;
	private JTextField txtUsuario = null;
	private JTextField txtUserLogin;

	private JPasswordField txtUserPass;
	private JPasswordField txtContras;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalIbai window = new VentanaPrincipalIbai();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipalIbai() {
		initialize();
	}

	public void initialize() {

		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBackground(SystemColor.text);
		frame.getContentPane().setForeground(SystemColor.text);
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setResizable(false);
		frame.setBounds(100, 100, 580, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel bPanelBienvenida = new JPanel();
		bPanelBienvenida.setLayout(null);
		bPanelBienvenida.setBounds(-90, -153, 1028, 857);
		frame.getContentPane().add(bPanelBienvenida);

		JPanel rPanelRegistro = new JPanel();
		rPanelRegistro.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(rPanelRegistro);
		rPanelRegistro.setLayout(null);
		rPanelRegistro.setVisible(false);

		JPanel lPanelLogin = new JPanel();
		lPanelLogin.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(lPanelLogin);
		lPanelLogin.setVisible(false);
		lPanelLogin.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(145, 11, 135, 26);
		rPanelRegistro.add(lblNewLabel);

		JLabel lblNewLabelNombre = new JLabel("Nombre");
		lblNewLabelNombre.setBounds(81, 208, 46, 14);
		rPanelRegistro.add(lblNewLabelNombre);

		JLabel lblNewLabelApellido = new JLabel("Apellido");
		lblNewLabelApellido.setBounds(81, 233, 46, 14);
		rPanelRegistro.add(lblNewLabelApellido);

		JLabel lblNewLabelDni = new JLabel("DNI");
		lblNewLabelDni.setBounds(81, 261, 46, 14);
		rPanelRegistro.add(lblNewLabelDni);

		JLabel lblNewLabelSexo = new JLabel("Sexo");
		lblNewLabelSexo.setBounds(81, 286, 46, 14);
		rPanelRegistro.add(lblNewLabelSexo);

		JLabel lblNewLabelUsuario = new JLabel("Usuario");
		lblNewLabelUsuario.setBounds(293, 236, 46, 14);
		rPanelRegistro.add(lblNewLabelUsuario);

		JLabel lblNewLabelContraseña = new JLabel("Contraseña");
		lblNewLabelContraseña.setBounds(283, 279, 56, 14);
		rPanelRegistro.add(lblNewLabelContraseña);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(249, 100, 66, 30);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lPanelLogin.add(lblLogin);

		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(238, 172, 46, 14);
		lPanelLogin.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setBounds(238, 234, 72, 14);
		lPanelLogin.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("¿No tienes cuenta? Registrate gratis");
		lblNewLabel_3.setBounds(193, 15, 184, 14);
		lPanelLogin.add(lblNewLabel_3);

		// Buttons

		JButton bBotonBienvenida = new JButton("BIENVENIDO");
		bBotonBienvenida.setIcon(new ImageIcon("img/bienvenida.png"));
		bBotonBienvenida.setForeground(Color.BLACK);
		bBotonBienvenida.setFont(new Font("Yu Gothic", Font.PLAIN, 50));
		bBotonBienvenida.setFocusable(false);
		bBotonBienvenida.setBackground(Color.WHITE);
		bBotonBienvenida.setBounds(92, 154, 564, 441);
		bPanelBienvenida.add(bBotonBienvenida);

		JButton btnAtrasRegistro = new JButton("Atrás");
		btnAtrasRegistro.setBounds(181, 361, 89, 23);
		rPanelRegistro.add(btnAtrasRegistro);

		JButton btnAceptarRegistro = new JButton("Aceptar");
		btnAceptarRegistro.setBounds(349, 361, 89, 23);
		rPanelRegistro.add(btnAceptarRegistro);

		JButton btnRegistrarse = new JButton("Registrarme");
		btnRegistrarse.setBounds(440, 11, 104, 23);
		lPanelLogin.add(btnRegistrarse);

		JButton btnAccederCuenta = new JButton("Acceder");
		btnAccederCuenta.setBounds(221, 334, 89, 23);
		lPanelLogin.add(btnAccederCuenta);

		JButton btnAtrasLogin = new JButton("Atrás");
		btnAtrasLogin.setBounds(10, 11, 89, 23);
		lPanelLogin.add(btnAtrasLogin);

		txtNombre = new JTextField();
		txtNombre.setBounds(125, 205, 86, 20);
		rPanelRegistro.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(125, 233, 86, 20);
		rPanelRegistro.add(txtApellido);
		txtApellido.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(125, 258, 86, 20);
		rPanelRegistro.add(txtDni);
		txtDni.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(349, 235, 86, 20);
		rPanelRegistro.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContras = new JPasswordField();
		txtContras.setBounds(349, 276, 90, 20);
		rPanelRegistro.add(txtContras);

		txtUserLogin = new JTextField();
		txtUserLogin.setBounds(221, 197, 86, 20);
		lPanelLogin.add(txtUserLogin);
		txtUserLogin.setColumns(10);

		txtUserPass = new JPasswordField();
		txtUserPass.setBounds(221, 259, 86, 20);
		lPanelLogin.add(txtUserPass);

		JComboBox<String> comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setModel(new DefaultComboBoxModel<String>(new String[] { "Seleccione", "Hombre", "Mujer" }));
		comboBoxSexo.setBounds(125, 286, 86, 22);
		rPanelRegistro.add(comboBoxSexo);

		// Action Listeners
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lPanelLogin.setVisible(false);
				rPanelRegistro.setVisible(true);
			}
		});

	}

}