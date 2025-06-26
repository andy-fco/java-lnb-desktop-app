package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import BLL.Admin;
import BLL.Jugador;
import DLL.DLLJugador;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

public class EditarJugador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre;
	private JTextField inpApellido;
	private JTextField inpPosicion;
	private JTextField inpCiudad;
	private JTextField inpNacionalidad;
	private JTextField inpDOB;

	/**
	 * Launch the application.
	 */

	public void run(Admin admin, Jugador j) {
		try {
			EditarJugador frame = new EditarJugador(admin, j);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public EditarJugador(Admin admin, Jugador j) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 500);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		j = DLLJugador.buscarJugadorPorId(DLLJugador.buscarID(j));
		int j_id = DLLJugador.buscarID(j);
		Jugador jf = DLLJugador.buscarJugadorPorId(DLLJugador.buscarID(j));

		JLabel lblTiro = new JLabel("Tiro ");
		lblTiro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTiro.setBounds(10, 187, 45, 32);
		contentPane.add(lblTiro);

		JLabel lblVelocidad = new JLabel("Velocidad ");
		lblVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVelocidad.setBounds(165, 187, 101, 32);
		contentPane.add(lblVelocidad);

		JLabel lblDribling = new JLabel("Dribling ");
		lblDribling.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDribling.setBounds(10, 261, 85, 32);
		contentPane.add(lblDribling);

		JLabel lblDefensa = new JLabel("Defensa ");
		lblDefensa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDefensa.setBounds(165, 261, 93, 32);
		contentPane.add(lblDefensa);

		JLabel lblPase = new JLabel("Pase ");
		lblPase.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPase.setBounds(10, 347, 63, 32);
		contentPane.add(lblPase);

		JLabel lblSalto = new JLabel("Salto ");
		lblSalto.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSalto.setBounds(165, 347, 63, 32);
		contentPane.add(lblSalto);

		JSpinner spinnerTiro = new JSpinner();
		spinnerTiro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerTiro.setModel(new SpinnerNumberModel(j.getTiro(), 1, 99, 1));
		spinnerTiro.setBounds(92, 187, 63, 32);
		contentPane.add(spinnerTiro);

		JSpinner spinnerVelocidad = new JSpinner();
		spinnerVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerVelocidad.setModel(new SpinnerNumberModel(j.getVelocidad(), 1, 99, 1));
		spinnerVelocidad.setBounds(268, 189, 63, 32);
		contentPane.add(spinnerVelocidad);

		JSpinner spinnerDribling = new JSpinner();
		spinnerDribling.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerDribling.setModel(new SpinnerNumberModel(j.getDribling(), 1, 99, 1));
		spinnerDribling.setBounds(92, 261, 63, 32);
		contentPane.add(spinnerDribling);

		JSpinner spinnerDefensa = new JSpinner();
		spinnerDefensa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerDefensa.setModel(new SpinnerNumberModel(j.getDefensa(), 1, 99, 1));
		spinnerDefensa.setBounds(268, 261, 63, 32);
		contentPane.add(spinnerDefensa);

		JSpinner spinnerPase = new JSpinner();
		spinnerPase.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerPase.setModel(new SpinnerNumberModel(j.getPase(), 1, 99, 1));
		spinnerPase.setBounds(92, 347, 63, 32);
		contentPane.add(spinnerPase);

		JSpinner spinnerSalto = new JSpinner();
		spinnerSalto.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerSalto.setModel(new SpinnerNumberModel(j.getSalto(), 1, 99, 1));
		spinnerSalto.setBounds(268, 347, 63, 32);
		contentPane.add(spinnerSalto);

		JSpinner spinnerMedia = new JSpinner();
		spinnerMedia.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerMedia.setModel(new SpinnerNumberModel(j.getMedia(), 1, 99, 1));
		spinnerMedia.setBounds(10, 93, 63, 32);
		contentPane.add(spinnerMedia);

		JLabel lblNewLabel = new JLabel("Editar Jugador");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(238, 14, 241, 44);
		contentPane.add(lblNewLabel);

		inpNombre = new JTextField(j.getNombre());
		inpNombre.setFont(new Font("Tahoma", Font.PLAIN, 28));
		inpNombre.setBounds(79, 91, 149, 32);
		contentPane.add(inpNombre);
		inpNombre.setColumns(10);

		inpApellido = new JTextField(j.getApellido());
		inpApellido.setFont(new Font("Tahoma", Font.PLAIN, 28));
		inpApellido.setColumns(10);
		inpApellido.setBounds(232, 91, 149, 32);
		contentPane.add(inpApellido);

		inpPosicion = new JTextField(j.getPosicion());
		inpPosicion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		inpPosicion.setColumns(10);
		inpPosicion.setBounds(130, 138, 210, 26);
		contentPane.add(inpPosicion);

		JSpinner spinnerCamiseta = new JSpinner();
		spinnerCamiseta.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinnerCamiseta.setModel(new SpinnerNumberModel(j.getCamiseta(), 0, 99, 1));
		spinnerCamiseta.setBounds(63, 135, 63, 32);
		contentPane.add(spinnerCamiseta);

		JSpinner spinnerAltura = new JSpinner();
		spinnerAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinnerAltura.setModel(new SpinnerNumberModel(j.getAltura(), 1.40, 2.15, 0.01));
		spinnerAltura.setBounds(445, 94, 115, 31);
		contentPane.add(spinnerAltura);

		JComboBox<String> comboBoxEspecialidad = new JComboBox<>();
		comboBoxEspecialidad.setModel(new DefaultComboBoxModel<String>(new String[] { "Tiro", "Volcadas", "Defensa",
				"Rebotes", "Asistencias", "Robos", "Tapas", "Poste bajo", "Pick and Roll", "Uno contra uno" }));
		comboBoxEspecialidad.setSelectedItem(j.getEspecialidad());
		comboBoxEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxEspecialidad.setBounds(445, 306, 209, 33);
		contentPane.add(comboBoxEspecialidad);

		JComboBox<String> comboBoxJugada = new JComboBox<String>();
		comboBoxJugada.setModel(new DefaultComboBoxModel<String>(new String[] { "Salida de tirador", "Triple",
				"Pick and pop", "Tiro de media distancia", "Fadeaway", "Flotadora", "Pick and roll", "Crossover",
				"No-look pass", "Volcada en transición", "Volcada", "Gancho", "Alley-oop" }));
		comboBoxJugada.setSelectedItem(j.getJugada());
		comboBoxJugada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxJugada.setBounds(445, 347, 209, 33);
		contentPane.add(comboBoxJugada);

		inpCiudad = new JTextField(j.getCiudad());
		inpCiudad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inpCiudad.setColumns(10);
		inpCiudad.setBounds(445, 224, 209, 33);
		contentPane.add(inpCiudad);

		JComboBox<String> comboBoxMano = new JComboBox<>();
		comboBoxMano.setModel(new DefaultComboBoxModel<String>(new String[] { "Derecha", "Izquierda" }));
		comboBoxMano.setSelectedItem(j.getManoHabil());
		comboBoxMano.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxMano.setBounds(445, 267, 209, 33);
		contentPane.add(comboBoxMano);

		inpNacionalidad = new JTextField(j.getNacionalidad());
		inpNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inpNacionalidad.setColumns(10);
		inpNacionalidad.setBounds(445, 181, 209, 33);
		contentPane.add(inpNacionalidad);

		inpDOB = new JTextField(j.getdOfBirth());
		inpDOB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inpDOB.setColumns(10);
		inpDOB.setBounds(445, 138, 209, 33);
		contentPane.add(inpDOB);

		JLabel lblVacio = new JLabel("");
		lblVacio.setForeground(Color.RED);
		lblVacio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVacio.setBounds(420, 390, 235, 26);
		contentPane.add(lblVacio);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionJugadores frame = new GestionJugadores(admin);
				frame.run(admin);
				dispose();
			}
		});
		btnVolver.setBounds(10, 10, 85, 21);
		contentPane.add(btnVolver);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (inpNombre.getText().isEmpty() || inpApellido.getText().isEmpty() || inpPosicion.getText().isEmpty()
						|| inpNacionalidad.getText().isEmpty() || inpDOB.getText().isEmpty()
						|| inpCiudad.getText().isEmpty()) {
					lblVacio.setText("No se permiten campos Vacíos");
					return;
				}

				Jugador editado = new Jugador(inpNombre.getText(), inpApellido.getText(),
						(Integer) spinnerCamiseta.getValue(), (Integer) spinnerMedia.getValue(), inpPosicion.getText(),
						inpNacionalidad.getText(), jf.getEquipo(), (Integer) spinnerTiro.getValue(),
						(Integer) spinnerDribling.getValue(), (Integer) spinnerPase.getValue(),
						(Integer) spinnerVelocidad.getValue(), (Integer) spinnerDefensa.getValue(),
						(Integer) spinnerSalto.getValue(), inpDOB.getText(), inpCiudad.getText(),
						((Double) spinnerAltura.getValue()).floatValue(), (String) comboBoxMano.getSelectedItem(),
						(String) comboBoxEspecialidad.getSelectedItem(), (String) comboBoxJugada.getSelectedItem());

				if (DLLJugador.editarJugador(editado, j_id)) {
					JOptionPane.showMessageDialog(null, "Jugador editado con éxito");
					GestionJugadores frame = new GestionJugadores(admin);
					frame.run(admin);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null,
							"Hubo un error al editar jugador.\nPor favor vuelva a intentarlo");
				}
			}

		});
		btnEditar.setBounds(561, 421, 93, 32);
		contentPane.add(btnEditar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionJugadores frame = new GestionJugadores(admin);
				frame.run(admin);
				dispose();
			}
		});
		btnCancelar.setBounds(458, 421, 93, 32);
		contentPane.add(btnCancelar);

	}
}
