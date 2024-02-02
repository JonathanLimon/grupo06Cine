package paneles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gestores.GestorClientes;
import pojos.Cliente;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CrearUsuario {

	private JFrame frame;
	public JTextField txtNombre = null;
	public JTextField txtApellido = null;
	public JTextField txtDni = null;
	public JTextField txtUsuario = null;
	public JTextField txtContraseña = null;
	public JComboBox comboBoxSexo = null;
	private JTextField txtUserLogin;
	
	private JPasswordField txtUserPass;
	private JPasswordField txtContras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuario window = new CrearUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		GestorClientes gestorCliente = new GestorClientes();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// JPanels
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelLogin);
		panelLogin.setVisible(true);

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelRegistro);
		panelRegistro.setLayout(null);
		panelLogin.setLayout(null);
		panelRegistro.setVisible(false);

		// JLabels
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(188, 40, 66, 30);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelLogin.add(lblLogin);

		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(198, 81, 46, 14);
		panelLogin.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setBounds(188, 137, 72, 14);
		panelLogin.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("¿No tienes cuenta? Registrate gratis");
		lblNewLabel_3.setBounds(126, 15, 184, 14);
		panelLogin.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("Regristrarme");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(145, 11, 135, 26);
		panelRegistro.add(lblNewLabel);

		JLabel lblNewLabelNombre = new JLabel("Nombre");
		lblNewLabelNombre.setBounds(10, 60, 46, 14);
		panelRegistro.add(lblNewLabelNombre);

		JLabel lblNewLabelApellido = new JLabel("Apellido");
		lblNewLabelApellido.setBounds(10, 96, 46, 14);
		panelRegistro.add(lblNewLabelApellido);

		JLabel lblNewLabelDni = new JLabel("DNI");
		lblNewLabelDni.setBounds(10, 132, 46, 14);
		panelRegistro.add(lblNewLabelDni);

		JLabel lblNewLabelSexo = new JLabel("Sexo");
		lblNewLabelSexo.setBounds(10, 168, 46, 14);
		panelRegistro.add(lblNewLabelSexo);

		JLabel lblNewLabelUsuario = new JLabel("Usuario");
		lblNewLabelUsuario.setBounds(224, 60, 46, 14);
		panelRegistro.add(lblNewLabelUsuario);

		JLabel lblNewLabelContraseña = new JLabel("Contraseña");
		lblNewLabelContraseña.setBounds(224, 96, 56, 14);
		panelRegistro.add(lblNewLabelContraseña);

		// JTextField
		txtUserLogin = new JTextField();
		txtUserLogin.setBounds(178, 106, 86, 20);
		panelLogin.add(txtUserLogin);
		txtUserLogin.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(74, 57, 86, 20);
		panelRegistro.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(74, 93, 86, 20);
		panelRegistro.add(txtApellido);
		txtApellido.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(74, 129, 86, 20);
		panelRegistro.add(txtDni);
		txtDni.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(294, 57, 86, 20);
		panelRegistro.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtUserPass = new JPasswordField();
		txtUserPass.setBounds(178, 161, 86, 20);
		panelLogin.add(txtUserPass);
		
		txtContras = new JPasswordField();
		txtContras.setBounds(290, 93, 90, 20);
		panelRegistro.add(txtContras);


		// JComboBox
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione", "Hombre", "Mujer" }));
		comboBoxSexo.setBounds(74, 164, 86, 22);
		panelRegistro.add(comboBoxSexo);

		// JButtons

		JButton btnRegistrarse = new JButton("Registrarme");
		btnRegistrarse.setBounds(320, 11, 104, 23);
		panelLogin.add(btnRegistrarse);

		JButton btnAccederCuenta = new JButton("Acceder");
		btnAccederCuenta.setBounds(178, 227, 89, 23);
		panelLogin.add(btnAccederCuenta);
		
		JButton btnAtrasLogin = new JButton("Atrás");
		btnAtrasLogin.setBounds(10, 11, 89, 23);
		panelLogin.add(btnAtrasLogin);
		
		

		JButton btnAtrasRegistro = new JButton("Atrás");
		btnAtrasRegistro.setBounds(222, 227, 89, 23);
		panelRegistro.add(btnAtrasRegistro);

		JButton btnAceptarRegistro = new JButton("Aceptar");
		btnAceptarRegistro.setBounds(321, 227, 89, 23);
		panelRegistro.add(btnAceptarRegistro);
		
		
		// Action Listeners

		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				panelRegistro.setVisible(true);
			}
		});

		btnAccederCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorClientes gestCli = new GestorClientes();
				String pwd = new String(txtUserPass.getPassword());
				if(gestCli.validarLogin(txtUserLogin.getText(), pwd)) {					
					panelLogin.setVisible(false);
					
				}
				
				//Añadir panel-----------------------------------------------------------

			}
		});


		btnAtrasRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistro.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		
		btnAtrasLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				//spPanelSeleccionPelis.setVisible(true);
			}
		});
	}
}