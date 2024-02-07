package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import gestores.GestorCines;
import gestores.GestorClientes;
import gestores.GestorPeliculas;
import pojos.Cine;
import pojos.Cliente;
import pojos.Pelicula;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class VentanaPrincipalIbai {

	private JFrame frame;

	private GestorClientes gestorCliente = new GestorClientes();
	private GestorPeliculas gestorPelicula = new GestorPeliculas();
	private GestorCines gestorCine = new GestorCines();
	public String tituloSeleccionado = null;
	public Date fechaSeleccionada = null;
	public Time horaSeleccionada = null;
	public Float precioSeleccionado = null;
	public int numSalaSeleccionada = 0;
	public Float precioTotal = null;
	private JPanel panelSelecCines;
	private JPanel PanelLogin;
	private JPanel PanelRegistro;
	private JPanel panelSelecPelis;
	DefaultTableModel model = new DefaultTableModel();
	private JTextField txtNombre = null;
	private JTextField txtApellido = null;
	private JTextField txtDni = null;
	private JTextField txtUsuario = null;
	private JTextField txtUserLogin;
	private JComboBox<String> comboBoxSexo;
	private JList<String> listCines;
	private JList<String> listPeliculas;
	private JPasswordField txtUserPass;
	private JTextField txtContras;
	public String nombreCine = null;

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

		panelSelecPelis = new JPanel();
		panelSelecPelis.setLayout(null);
		panelSelecPelis.setBounds(0, 0, 564, 441);
		panelSelecPelis.setVisible(false);
		frame.getContentPane().add(panelSelecPelis);

		JLabel labelSeleccionPelis = new JLabel("Selecciona una Pelicula");
		labelSeleccionPelis.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelSeleccionPelis.setBounds(173, 100, 250, 37);
		panelSelecPelis.add(labelSeleccionPelis);

		listPeliculas = new JList<String>();
		listPeliculas.setForeground(Color.BLACK);
		listPeliculas.setBounds(114, 177, 359, 230);
		panelSelecPelis.add(listPeliculas);

		panelSelecCines = new JPanel();
		panelSelecCines.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(panelSelecCines);
		panelSelecCines.setLayout(null);
		panelSelecCines.setVisible(false);

		JLabel labelSeleccionCines = new JLabel("Selecciona un Cine");
		labelSeleccionCines.setHorizontalAlignment(SwingConstants.CENTER);
		labelSeleccionCines.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelSeleccionCines.setBounds(33, 69, 241, 57);
		panelSelecCines.add(labelSeleccionCines);

		JLabel seleccionCinesLogo = new JLabel("");
		seleccionCinesLogo.setIcon(new ImageIcon("C:\\Users\\in1dw3\\Desktop\\Ibai\\Reto 3\\bienvenida.png"));
		seleccionCinesLogo.setBounds(376, 11, 137, 156);
		panelSelecCines.add(seleccionCinesLogo);

		JButton btnFinalizar = new JButton("ACEPTAR");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarCine();
			}
		});
		btnFinalizar.setBounds(221, 392, 96, 38);
		panelSelecCines.add(btnFinalizar);

		listCines = new JList<String>();
		listCines.setForeground(new Color(0, 0, 0));
		listCines.setBounds(78, 132, 406, 230);
		panelSelecCines.add(listCines);

		PanelRegistro = new JPanel();
		PanelRegistro.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(PanelRegistro);
		PanelRegistro.setLayout(null);
		PanelRegistro.setVisible(false);

		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistro.setBounds(236, 54, 89, 26);
		PanelRegistro.add(lblRegistro);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(81, 208, 46, 14);
		PanelRegistro.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(81, 233, 46, 14);
		PanelRegistro.add(lblApellido);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(81, 261, 46, 14);
		PanelRegistro.add(lblDni);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(81, 286, 46, 14);
		PanelRegistro.add(lblSexo);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(293, 236, 46, 14);
		PanelRegistro.add(lblUsuario);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setBounds(279, 279, 74, 14);
		PanelRegistro.add(lblContraseña);

		JButton btnAtrasRegistro = new JButton("Atrás");
		btnAtrasRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelLogin.setVisible(true);
				PanelRegistro.setVisible(false);
			}
		});
		btnAtrasRegistro.setBounds(158, 361, 89, 23);
		PanelRegistro.add(btnAtrasRegistro);

		JButton btnAceptarRegistro = new JButton("Aceptar");
		btnAceptarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarRegistro();
			}
		});
		btnAceptarRegistro.setBounds(305, 361, 89, 23);
		PanelRegistro.add(btnAceptarRegistro);

		txtNombre = new JTextField();
		txtNombre.setBounds(125, 205, 86, 20);
		PanelRegistro.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(125, 233, 86, 20);
		PanelRegistro.add(txtApellido);
		txtApellido.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(125, 258, 86, 20);
		PanelRegistro.add(txtDni);
		txtDni.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(349, 235, 86, 20);
		PanelRegistro.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContras = new JTextField();
		txtContras.setBounds(349, 276, 90, 20);
		PanelRegistro.add(txtContras);

		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setModel(new DefaultComboBoxModel<String>(new String[] { "Hombre", "Mujer", "Otro" }));
		comboBoxSexo.setBounds(125, 286, 86, 22);
		PanelRegistro.add(comboBoxSexo);

		PanelLogin = new JPanel();
		PanelLogin.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(PanelLogin);
		PanelLogin.setVisible(false);
		PanelLogin.setLayout(null);

		JPanel PanelBienvenida = new JPanel();
		PanelBienvenida.setLayout(null);
		PanelBienvenida.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(PanelBienvenida);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(249, 100, 66, 30);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PanelLogin.add(lblLogin);

		JLabel lblUsuarioLogin = new JLabel("Usuario");
		lblUsuarioLogin.setBounds(238, 172, 46, 14);
		PanelLogin.add(lblUsuarioLogin);

		JLabel lblContraseñaLogin = new JLabel("Contraseña");
		lblContraseñaLogin.setBounds(238, 234, 72, 14);
		PanelLogin.add(lblContraseñaLogin);

		JLabel lblTexto = new JLabel("¿No tienes cuenta? Registrate gratis");
		lblTexto.setBounds(161, 15, 256, 14);
		PanelLogin.add(lblTexto);

		JButton btnRegistrarse = new JButton("Registrarme");
		btnRegistrarse.setBounds(427, 11, 117, 23);
		PanelLogin.add(btnRegistrarse);

		JButton btnAccederCuenta = new JButton("Acceder");
		btnAccederCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd = new String(txtUserPass.getPassword());
				if (gestorCliente.validarLogin(txtUserLogin.getText(), pwd)) {
					PanelLogin.setVisible(false);
					panelSelecCines.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentar");
				}
				mostrarListaCines();
			}
		});
		btnAccederCuenta.setBounds(221, 334, 89, 23);
		PanelLogin.add(btnAccederCuenta);

		JButton btnAtrasLogin = new JButton("Atrás");
		btnAtrasLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelRegistro.setVisible(false);
				PanelLogin.setVisible(false);
				PanelBienvenida.setVisible(true);
			}
		});
		btnAtrasLogin.setBounds(10, 11, 105, 23);
		PanelLogin.add(btnAtrasLogin);

		txtUserLogin = new JTextField();
		txtUserLogin.setBounds(221, 197, 86, 20);
		PanelLogin.add(txtUserLogin);
		txtUserLogin.setColumns(10);

		txtUserPass = new JPasswordField();
		txtUserPass.setBounds(221, 259, 86, 20);
		PanelLogin.add(txtUserPass);

		txtUserPass.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnAccederCuenta.doClick();
				}

			}

			public void keyReleased(KeyEvent e) {
			}
		});

		txtUserLogin.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnAccederCuenta.doClick();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		});
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelLogin.setVisible(false);
				PanelRegistro.setVisible(true);
			}
		});

		JButton bBotonBienvenida = new JButton("BIENVENIDO");
		bBotonBienvenida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelBienvenida.setVisible(false);
				PanelLogin.setVisible(true);
			}
		});
		bBotonBienvenida.setIcon(new ImageIcon("img/bienvenida.png"));
		bBotonBienvenida.setForeground(Color.BLACK);
		bBotonBienvenida.setFont(new Font("Yu Gothic", Font.PLAIN, 50));
		bBotonBienvenida.setFocusable(false);
		bBotonBienvenida.setBackground(Color.WHITE);
		bBotonBienvenida.setBounds(0, 0, 564, 441);
		PanelBienvenida.add(bBotonBienvenida);

		JLabel lblFondoBienvenida = new JLabel("");
		lblFondoBienvenida.setBounds(0, 0, 564, 441);
		PanelBienvenida.add(lblFondoBienvenida);

	}

	private void aceptarRegistro() {

		Cliente cliente = new Cliente();

		String sexoSeleccionado = comboBoxSexo.getSelectedItem().toString();
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String dni = txtDni.getText();
		String contraseña = txtContras.getText();
		String usuario = txtUsuario.getText();

		if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || sexoSeleccionado.isEmpty()
				|| contraseña.isEmpty() || usuario.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setDNI(dni);
			cliente.setSexo(sexoSeleccionado);
			cliente.setContraseña(contraseña);
			cliente.setUsuario(usuario);

			PanelRegistro.setVisible(false);
			PanelLogin.setVisible(true);

		}

	}

	private void mostrarListaCines() {

		ArrayList<Cine> listaCines = gestorCine.obtenerTodosLosCines();
		DefaultListModel<String> listModel = new DefaultListModel<String>();

		for (Cine cine : listaCines) {
			String infoCine = cine.getNombre() + ", " + cine.getDireccion();
			listModel.addElement(infoCine);
		}

		listCines.setModel(listModel);

	}

	private void seleccionarCine() {
		String cineSeleccionado = listCines.getSelectedValue();
		String[] partes = cineSeleccionado.split(", ");

		String nombreCine = partes[0];

		int codCineBuscado = gestorCine.obtenerCodCinePorNombre(nombreCine);

		ArrayList<Pelicula> listaPeliculas = gestorPelicula.obtenerPeliculasCine(codCineBuscado);
		DefaultListModel<String> listModel = new DefaultListModel<String>();

		for (Pelicula pelicula : listaPeliculas) {
			String peliculas = pelicula.getTitulo() + ", " + pelicula.getDuracion() + ", " + pelicula.getGenero() + ", "
					+ pelicula.getPrecio();
			listModel.addElement(peliculas);
		}

		listPeliculas.setModel(listModel);

		panelSelecCines.setVisible(false);
		panelSelecPelis.setVisible(true);
	}
}