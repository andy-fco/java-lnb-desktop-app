package GUI;



import javax.swing.JFrame;
import javax.swing.JPanel;


import BLL.Aficionado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre;
	private JTextField inpDOB;
	private JTextField inpApellido;
	private JTextField inpID;
	private JTextField inpMail;
	private JPasswordField inpPass1;
	private JPasswordField inpPass2;


	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			Registro registro = new Registro();
			registro.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		setTitle("Registro de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(580, 550);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Creá tu cuenta");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblTitulo.setBounds(160, 20, 250, 40);
		contentPane.add(lblTitulo);

		// Campo: Nombre
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNombre.setBounds(50, 80, 100, 20);
		contentPane.add(lblNombre);

		inpNombre = new JTextField();
		inpNombre.setBounds(50, 105, 200, 27);
		contentPane.add(inpNombre);

		// Campo: Apellido
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblApellido.setBounds(314, 80, 100, 20);
		contentPane.add(lblApellido);

		inpApellido = new JTextField();
		inpApellido.setBounds(314, 105, 200, 27);
		contentPane.add(inpApellido);

		// Campo: Correo
		JLabel lblMail = new JLabel("Correo electrónico:");
		lblMail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblMail.setBounds(50, 140, 200, 20);
		contentPane.add(lblMail);

		inpMail = new JTextField();
		inpMail.setBounds(50, 165, 464, 27);
		contentPane.add(inpMail);

		// Campo: Fecha de nacimiento
		JLabel lblDOB = new JLabel("Fecha de nacimiento [YYYY-MM-DD]:");
		lblDOB.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblDOB.setBounds(50, 200, 300, 20);
		contentPane.add(lblDOB);

		inpDOB = new JTextField();
		inpDOB.setBounds(50, 225, 200, 27);
		contentPane.add(inpDOB);

		// Campo: Usuario
		JLabel lblID = new JLabel("Nombre de usuario:");
		lblID.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblID.setBounds(314, 200, 200, 20);
		contentPane.add(lblID);

		inpID = new JTextField();
		inpID.setBounds(314, 225, 200, 27);
		contentPane.add(inpID);

		// Campo: Contraseña
		JLabel lblPass1 = new JLabel("Contraseña:");
		lblPass1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPass1.setBounds(50, 260, 200, 20);
		contentPane.add(lblPass1);

		inpPass1 = new JPasswordField();
		inpPass1.setBounds(50, 285, 200, 27);
		contentPane.add(inpPass1);

		// Campo: Repetir contraseña
		JLabel lblPass2 = new JLabel("Repetir contraseña:");
		lblPass2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPass2.setBounds(314, 260, 200, 20);
		contentPane.add(lblPass2);

		inpPass2 = new JPasswordField();
		inpPass2.setBounds(314, 285, 200, 27);
		contentPane.add(inpPass2);

		// Label de error
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblError.setBounds(50, 320, 440, 20);
		lblError.setVisible(false);
		contentPane.add(lblError);

		// Botón crear cuenta
		JButton btnCrear = new JButton("Crear cuenta");
		btnCrear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCrear.setBackground(new Color(0, 123, 255));
		btnCrear.setForeground(Color.WHITE);
		btnCrear.setBounds(50, 350, 464, 35);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblError.setVisible(false);
				Aficionado user = Aficionado.registro(
					inpNombre.getText(), inpApellido.getText(), inpID.getText(),
					new String(inpPass1.getPassword()), new String(inpPass2.getPassword()),
					inpMail.getText(), inpDOB.getText()
				);

				if (user != null) {
					JOptionPane.showMessageDialog(null, "¡Bienvenid@! Tu cuenta se creó con éxito");
					new MainMenu(user).run(user);
					dispose();
				} else {
					lblError.setText("Error al registrar cuenta. Verificá los campos.");
					lblError.setVisible(true);
				}
			}
		});
		contentPane.add(btnCrear);

		// Texto y botón para iniciar sesión
		JLabel lblYaTenes = new JLabel("¿Ya tenés una cuenta?");
		lblYaTenes.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblYaTenes.setBounds(260, 463, 150, 20);
		contentPane.add(lblYaTenes);

		JButton btnLogin = new JButton("Iniciar sesión");
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnLogin.setBounds(394, 461, 120, 25);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Index().setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnLogin);
	}
}
