package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import gestores.GestorCines;
import gestores.GestorClientes;
import gestores.GestorEntradas;
import gestores.GestorPeliculas;
import gestores.GestorProyecciones;
import gestores.GestorSalas;
import pojos.Cine;
import pojos.Cliente;
import pojos.Pelicula;
import pojos.Proyeccion;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class VentanaPrincipal {

	private JFrame frame;

	private GestorClientes gestorCliente = new GestorClientes();
	private GestorPeliculas gestorPelicula = new GestorPeliculas();
	private GestorProyecciones gestorProyecciones = new GestorProyecciones();
	private ArrayList<String> peliculasCarrito = new ArrayList<String>();
	private GestorCines gestorCine = new GestorCines();
	public String tituloSeleccionado = null;
	public Date fechaSeleccionada = null;
	public Time horaSeleccionada = null;
	public Float precioSeleccionado = null;
	public int numSalaSeleccionada = 0;
	private JPanel panelSelecCines;
	private JPanel PanelLogin;
	private JPanel PanelRegistro;
	private JPanel panelSelecPelis;
	private JPanel panelCarrito;
	private JPanel panelSelecFecha;
	private JPanel PanelBienvenida;
	private JLabel lblPrecioNum;
	private JLabel lblPrecioTotalCarrito;
	private String mensaje;
	private JTextField txtNombre = null;
	private JTextField txtApellido = null;
	private JTextField txtDni = null;
	private JTextField txtUsuario = null;
	private JTextField txtUserLogin;
	private JComboBox<String> comboBoxFecha;
	private JComboBox<String> comboBoxSexo;
	private JComboBox<String> comboBoxHora;
	private JList<String> listCines;
	private JList<String> listPeliculas;
	private JList<String> listCarrito;
	private JPasswordField txtUserPass;
	private JTextField txtContras;
	public String nombreCine = null;
	private JLabel lblTitulo;
	private JLabel lblPeliculaSelec;
	private JTextField textFieldCantidad;
	private JLabel lblSalaSelec;
	private int codCineBuscado;
	private int codProyeccion = 0;
	private String fechaBuscada = null;
	private JLabel lblFotoPelicula;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
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

		panelSelecFecha = new JPanel();
		panelSelecFecha.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(panelSelecFecha);
		panelSelecFecha.setLayout(null);
		panelSelecFecha.setVisible(false);

		lblTitulo = new JLabel("Pelicula:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTitulo.setBounds(191, 38, 61, 19);
		panelSelecFecha.add(lblTitulo);

		comboBoxHora = new JComboBox<String>();
		comboBoxHora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionSala();
			}
		});
		comboBoxHora.setBounds(327, 309, 173, 22);
		panelSelecFecha.add(comboBoxHora);

		lblPeliculaSelec = new JLabel("");
		lblPeliculaSelec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPeliculaSelec.setBounds(251, 27, 234, 42);
		panelSelecFecha.add(lblPeliculaSelec);

		JLabel lblFechas = new JLabel("DIAS:");
		lblFechas.setBounds(133, 284, 31, 14);
		panelSelecFecha.add(lblFechas);

		comboBoxFecha = new JComboBox<String>();
		comboBoxFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarHora();
			}
		});
		comboBoxFecha.setBounds(56, 309, 173, 22);
		panelSelecFecha.add(comboBoxFecha);

		JLabel lblHora = new JLabel("HORAS:");
		lblHora.setBounds(396, 284, 46, 14);
		panelSelecFecha.add(lblHora);

		lblFotoPelicula = new JLabel("");
		lblFotoPelicula.setBounds(191, 80, 165, 180);
		panelSelecFecha.add(lblFotoPelicula);

		JButton btnAceptarPelicula = new JButton("ACEPTAR");
		btnAceptarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecFecha.setVisible(false);
				panelSelecCines.setVisible(true);

				String horaBuscada = comboBoxHora.getSelectedItem().toString();
				String fechaBuscadaProyeccion = comboBoxFecha.getSelectedItem().toString();
				String tituloPelicula = lblPeliculaSelec.getText();

				ArrayList<Proyeccion> proyecciones = gestorProyecciones.obtenerCodProyeccion(codCineBuscado,
						tituloPelicula, fechaBuscadaProyeccion, horaBuscada);

				for (Proyeccion proyeccion : proyecciones) {
					codProyeccion = proyeccion.getCodProyeccion();
				}

				añadirCarrito();

				textFieldCantidad.setText("");
				lblPeliculaSelec.setText("");
			}
		});
		btnAceptarPelicula.setBounds(233, 407, 89, 23);
		panelSelecFecha.add(btnAceptarPelicula);

		JButton btnAtrasFechas = new JButton("ATRAS");
		btnAtrasFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecFecha.setVisible(false);
				panelSelecPelis.setVisible(true);

				lblTitulo.setText("");
				lblSalaSelec.setText("");
				comboBoxHora.removeAllItems();
			}
		});
		btnAtrasFechas.setBounds(10, 11, 77, 23);
		panelSelecFecha.add(btnAtrasFechas);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(56, 366, 83, 14);
		panelSelecFecha.add(lblPrecio);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidad.setBounds(327, 366, 61, 14);
		panelSelecFecha.add(lblCantidad);

		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(396, 364, 104, 20);
		panelSelecFecha.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);

		lblPrecioNum = new JLabel("10");
		lblPrecioNum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecioNum.setBounds(101, 366, 83, 14);
		panelSelecFecha.add(lblPrecioNum);

		JLabel lblSala = new JLabel("Sala:");
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSala.setBounds(133, 366, 46, 14);
		panelSelecFecha.add(lblSala);

		lblSalaSelec = new JLabel("");
		lblSalaSelec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalaSelec.setBounds(171, 366, 46, 14);
		panelSelecFecha.add(lblSalaSelec);

		panelCarrito = new JPanel();
		panelCarrito.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(panelCarrito);
		panelCarrito.setLayout(null);
		panelCarrito.setVisible(false);

		JButton btnPagarCarrito = new JButton("Pagar");
		btnPagarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pagarCarrito();

					panelCarrito.setVisible(false);
					PanelBienvenida.setVisible(true);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPagarCarrito.setBounds(465, 11, 89, 23);
		panelCarrito.add(btnPagarCarrito);

		JButton btnAtrasCarrito = new JButton("Atrás");
		btnAtrasCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelCarrito.setVisible(false);
				PanelLogin.setVisible(true);
			}
		});
		btnAtrasCarrito.setBounds(10, 11, 89, 23);
		panelCarrito.add(btnAtrasCarrito);

		JLabel lblCarrito = new JLabel("CARRITO");
		lblCarrito.setBounds(241, 27, 89, 48);
		lblCarrito.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCarrito.add(lblCarrito);

		listCarrito = new JList<String>();
		listCarrito.setBounds(68, 96, 426, 275);
		panelCarrito.add(listCarrito);

		JScrollPane scrollCarrito = new JScrollPane(listCarrito);
		scrollCarrito.setBounds(68, 96, 426, 275);
		panelCarrito.add(scrollCarrito);

		lblPrecioTotalCarrito = new JLabel("0");
		lblPrecioTotalCarrito.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecioTotalCarrito.setBounds(276, 407, 148, 23);
		panelCarrito.add(lblPrecioTotalCarrito);

		PanelLogin = new JPanel();
		PanelLogin.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(PanelLogin);
		PanelLogin.setVisible(false);
		PanelLogin.setLayout(null);

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
		lblTexto.setBounds(193, 15, 256, 14);
		PanelLogin.add(lblTexto);

		JButton btnRegistrarse = new JButton("Registrarme");
		btnRegistrarse.setBounds(10, 11, 117, 23);
		PanelLogin.add(btnRegistrarse);

		PanelBienvenida = new JPanel();
		PanelBienvenida.setLayout(null);
		PanelBienvenida.setBounds(0, 0, 564, 441);
		frame.getContentPane().add(PanelBienvenida);

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
		btnAccederCuenta.setBounds(292, 334, 89, 23);
		PanelLogin.add(btnAccederCuenta);

		JButton btnAtrasLogin = new JButton("Atrás");
		btnAtrasLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelRegistro.setVisible(false);
				PanelLogin.setVisible(false);
				PanelBienvenida.setVisible(true);

				txtUserLogin.setText("");
				txtUserPass.setText("");
			}
		});
		btnAtrasLogin.setBounds(171, 334, 80, 23);
		PanelLogin.add(btnAtrasLogin);

		txtUserLogin = new JTextField();
		txtUserLogin.setBounds(221, 197, 86, 20);
		PanelLogin.add(txtUserLogin);
		txtUserLogin.setColumns(10);

		txtUserPass = new JPasswordField();
		txtUserPass.setBounds(221, 259, 86, 20);
		PanelLogin.add(txtUserPass);

		JButton btnCarritoLogin = new JButton("CARRITO");
		btnCarritoLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PanelLogin.setVisible(false);
				panelCarrito.setVisible(true);

			}
		});
		btnCarritoLogin.setBounds(441, 11, 107, 23);
		PanelLogin.add(btnCarritoLogin);

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

				txtUserLogin.setText("");
				txtUserPass.setText("");
			}
		});
		frame.getContentPane().add(panelSelecPelis);

		JLabel labelSeleccionPelis = new JLabel("Selecciona una Pelicula");
		labelSeleccionPelis.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelSeleccionPelis.setBounds(173, 100, 250, 37);
		panelSelecPelis.add(labelSeleccionPelis);

		listPeliculas = new JList<String>();
		listPeliculas.setForeground(Color.BLACK);
		listPeliculas.setBounds(114, 177, 359, 230);
		panelSelecPelis.add(listPeliculas);

		JScrollPane scrollPelicula = new JScrollPane(listPeliculas);
		scrollPelicula.setBounds(114, 177, 359, 230);
		panelSelecPelis.add(scrollPelicula);

		JButton btnAtrasPelicula = new JButton("Atrás");
		btnAtrasPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecPelis.setVisible(false);
				panelSelecCines.setVisible(true);

				mostrarListaCines();

			}
		});
		btnAtrasPelicula.setBounds(10, 11, 89, 23);
		panelSelecPelis.add(btnAtrasPelicula);

		JButton btnPelicula = new JButton("ACEPTAR");
		btnPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecPelis.setVisible(false);
				panelSelecFecha.setVisible(true);

				lblSalaSelec.setText("");

				fechasPeliculas();
				cambiarImagen();
			}
		});
		btnPelicula.setBounds(240, 407, 89, 23);
		panelSelecPelis.add(btnPelicula);

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

		JButton btnAceptarCine = new JButton("ACEPTAR");
		btnAceptarCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarCine();
			}
		});
		btnAceptarCine.setBounds(221, 392, 96, 38);
		panelSelecCines.add(btnAceptarCine);

		listCines = new JList<String>();
		listCines.setForeground(new Color(0, 0, 0));
		listCines.setBounds(78, 132, 406, 230);
		panelSelecCines.add(listCines);

		JScrollPane scrollCines = new JScrollPane(listCines);
		scrollCines.setBounds(78, 132, 406, 230);
		panelSelecCines.add(scrollCines);

		JButton btnAtrasCine = new JButton("Atrás");
		btnAtrasCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSelecCines.setVisible(false);
				PanelLogin.setVisible(true);
			}
		});
		btnAtrasCine.setBounds(10, 11, 89, 23);
		panelSelecCines.add(btnAtrasCine);

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

				txtNombre.setText("");
				txtApellido.setText("");
				txtDni.setText("");
				txtContras.setText("");
				txtUsuario.setText("");
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

			gestorCliente.insertCliente(cliente);

			txtNombre.setText("");
			txtApellido.setText("");
			txtDni.setText("");
			txtContras.setText("");
			txtUsuario.setText("");

			PanelRegistro.setVisible(false);
			PanelLogin.setVisible(true);

		}

	}

	private void mostrarListaCines() {

		ArrayList<Cine> listaCines = gestorCine.obtenerTodosLosCines();
		DefaultListModel<String> modeloCine = new DefaultListModel<String>();

		for (Cine cine : listaCines) {
			String infoCine = cine.getNombre() + ", " + cine.getDireccion();
			modeloCine.addElement(infoCine);
		}

		listCines.setModel(modeloCine);

	}

	private void seleccionarCine() {
		String cineSeleccionado = listCines.getSelectedValue();
		String[] partes = cineSeleccionado.split(", ");

		String nombreCine = partes[0];

		codCineBuscado = gestorCine.obtenerCodCinePorNombre(nombreCine);

		ArrayList<Pelicula> listaPeliculas = gestorPelicula.obtenerPeliculasCine(codCineBuscado);

		DefaultListModel<String> modeloPelicula = new DefaultListModel<String>();

		for (Pelicula pelicula : listaPeliculas) {
			String peliculas = pelicula.getTitulo();
			modeloPelicula.addElement(peliculas);
		}

		listPeliculas.setModel(modeloPelicula);

		panelSelecCines.setVisible(false);
		panelSelecPelis.setVisible(true);
	}

	private void añadirCarrito() {

		String entrada = null;
		int precioTotal = 0;
		DefaultListModel<String> modeloCarrito = new DefaultListModel<>();
		int precioEntrada = Integer.parseInt(lblPrecioNum.getText());
		int cantidadEntrada = Integer.parseInt(textFieldCantidad.getText());
		int precioSelec = Integer.parseInt(lblPrecioTotalCarrito.getText());
		String peliculaSeleccionada = lblPeliculaSelec.getText();
		String fechaSeleccionada = comboBoxFecha.getSelectedItem().toString();
		String horaSeleccionada = comboBoxHora.getSelectedItem().toString();

		if (precioSelec == 0) {
			precioTotal = precioEntrada * cantidadEntrada;
		} else {
			precioTotal = precioSelec + (precioEntrada * cantidadEntrada);
		}

		lblPrecioTotalCarrito.setText("" + precioTotal);

		entrada = peliculaSeleccionada + ", " + fechaSeleccionada + ", " + horaSeleccionada;

		for (int i = 0; i < cantidadEntrada; i++) {
			peliculasCarrito.add(entrada);
		}

		for (String pelicula : peliculasCarrito) {
			modeloCarrito.addElement(pelicula);
		}
		listCarrito.setModel(modeloCarrito);

	}

	private void fechasPeliculas() {

		String peliSeleccionada = listPeliculas.getSelectedValue();
		String[] partes = peliSeleccionada.split(", ");

		String nombrePelicula = partes[0];

		lblPeliculaSelec.setText(nombrePelicula);

		ArrayList<Proyeccion> fechas = gestorProyecciones.obtenerFechaPeliculaCine(codCineBuscado, nombrePelicula);

		DefaultComboBoxModel<String> modeloFecha = new DefaultComboBoxModel<String>();

		for (Proyeccion proyeccion : fechas) {
			String fecha = proyeccion.getFecha().toString();
			modeloFecha.addElement(fecha);
		}
		comboBoxFecha.setModel(modeloFecha);
	}

	private void seleccionarHora() {

		fechaBuscada = comboBoxFecha.getSelectedItem().toString();

		String tituloPelicula = lblPeliculaSelec.getText();

		ArrayList<Proyeccion> horas = gestorProyecciones.obtenerHoraPeliculaCineFecha(codCineBuscado, tituloPelicula,
				fechaBuscada);

		DefaultComboBoxModel<String> modeloHora = new DefaultComboBoxModel<String>();

		for (Proyeccion proyeccion : horas) {
			String hora = proyeccion.getHora().toString();
			modeloHora.addElement(hora);
		}
		comboBoxHora.setModel(modeloHora);
	}

	private void pagarCarrito() throws IOException {

		int codCliente = 0;
		String DNI = txtUserPass.getText();

		GestorEntradas gestorEntrada = new GestorEntradas();
		LocalDate fechaCompra = LocalDate.now();

		ArrayList<Cliente> clientes = gestorCliente.obtenerClienteDNI(DNI);

		for (Cliente cliente : clientes) {
			codCliente = cliente.getCodCliente();
		}

		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaFormateada = fechaCompra.format(formatoFecha);

//		gestorEntrada.insertEntrada(codProyeccion, codCliente, fechaFormateada);
		double precioTotal = Double.parseDouble(lblPrecioTotalCarrito.getText());

		HashSet<String> listaCarrito = new HashSet<>(peliculasCarrito);
		peliculasCarrito.clear();
		peliculasCarrito.addAll(listaCarrito);

		int longitud = peliculasCarrito.size();

		if (longitud == 0) {

			JOptionPane.showMessageDialog(null, "ERROR, Noo has seleccionado ninguna pelicula");

		} else if (longitud == 1) {

			mensaje = "BUENAS, SU COMPRAR COMPRA CON SE A QUEDADO EN: " + precioTotal + ". ¿DESEAS IMPRIMIR UN RECIBO?";

			comprar(precioTotal);

		} else if (longitud == 2) {

			double porcentajeDescuento = 0.20;
			double cantidadDescuento = precioTotal * porcentajeDescuento;

			precioTotal = precioTotal - cantidadDescuento;

			mensaje = "BUENAS, SE HA APLICADO UN DESCUENTO DEL 20% SU COMPRAR COMPRA CON SE A QUEDADO EN: "
					+ precioTotal + ". ¿DESEAS IMPRIMIR UN RECIBO?";

			comprar(precioTotal);

		} else {

			double porcentajeDescuento = 0.30;
			double cantidadDescuento = precioTotal * porcentajeDescuento;

			precioTotal = precioTotal - cantidadDescuento;

			mensaje = "BUENAS, SE HA APLICADO UN DESCUENTO DEL 30% SU COMPRAR COMPRA CON SE A QUEDADO EN: "
					+ precioTotal + ". ¿DESEAS IMPRIMIR UN RECIBO?";

			comprar(precioTotal);

		}
	}

	private void comprar(double precioTotal) throws IOException {

		String clienteBuscado = null;
		int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION);

		String DNI = txtUserPass.getText();

		ArrayList<Cliente> clientes = gestorCliente.obtenerClienteDNI(DNI);

		for (Cliente cliente : clientes) {
			clienteBuscado = cliente.getNombre() + ", " + cliente.getApellido();
		}

		if (opcion == JOptionPane.YES_OPTION) {
			String recibo = peliculasCarrito.toString();
			imprimirRecibo(recibo);
			JOptionPane.showMessageDialog(null, "RECIBO IMPRESO");
		} else {
			JOptionPane.showMessageDialog(null, "RECIBO NO IMPRESO");
		}

	}

	private void seleccionSala() {

		String tituloBuscado = lblPeliculaSelec.getText();
		GestorSalas gestorSala = new GestorSalas();
		int codigoSala = gestorSala.obtenerCodSala(codCineBuscado, tituloBuscado, fechaBuscada);

		lblSalaSelec.setText("" + codigoSala);

	}

	private void cambiarImagen() {

		String rutaFoto = null;
		String tituloBuscado = listPeliculas.getSelectedValue();

		if (tituloBuscado.equals("Black Panther")) {
			rutaFoto = "lib/Fotos/blackpanther.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("Los Vengadores: Endgame")) {
			rutaFoto = "lib/Fotos/endgame.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("Lady Bird")) {
			rutaFoto = "lib/Fotos/ladybird.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("Misión Imposible 6")) {
			rutaFoto = "lib/Fotos/misionimposible.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("Metropolis")) {
			rutaFoto = "lib/Fotos/metropolis.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("La novia de Frankenstein")) {
			rutaFoto = "lib/Fotos/lanovia.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("Hijos de los hombres")) {
			rutaFoto = "lib/Fotos/hijos.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("Looper")) {
			rutaFoto = "lib/Fotos/looper.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("Fuerza mayor ")) {
			rutaFoto = "lib/Fotos/fuerzamayor.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("Mortadelo y Filemón contra Jimmy el Cachondo")) {
			rutaFoto = "lib/Fotos/mortadelo.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("El cuarto pasajero")) {
			rutaFoto = "lib/Fotos/cuarto.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("Dos buenos tipos")) {
			rutaFoto = "lib/Fotos/dosbuenos.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("La Monja")) {
			rutaFoto = "lib/Fotos/monja.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("It 2")) {
			rutaFoto = "lib/Fotos/it2.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("La matanza de Texas")) {
			rutaFoto = "lib/Fotos/matanza.jpg";
			mostrarImagen(rutaFoto);
		} else if (tituloBuscado.equals("El resplandor")) {
			rutaFoto = "lib/Fotos/resplandor.jpg";
			mostrarImagen(rutaFoto);
		}
	}

	private void mostrarImagen(String rutaFoto) {
		try {
			BufferedImage imagenOriginal = ImageIO.read(new File(rutaFoto));

			int nuevoAncho = 165;
			int nuevoAlto = 180;
			Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

			ImageIcon icono = new ImageIcon(imagenRedimensionada);

			lblFotoPelicula.setIcon(icono);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void imprimirRecibo(String recibo) {
		try {
			FileWriter escritor = new FileWriter("C:\\Users\\in1dw3\\Desktop\\recibo.txt");
			escritor.write(recibo);
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}