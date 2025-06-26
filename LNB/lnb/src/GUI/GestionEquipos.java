package GUI;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Admin;
import BLL.Aficionado;
import BLL.Equipo;
import BLL.Jugador;
import DLL.DLLAficionado;
import DLL.DLLEquipo;
import DLL.DLLJugador;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GestionEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Equipo equipoSeleccionado;

	/**
	 * Launch the application.
	 */

	public void run(Admin admin) {
		try {
			GestionEquipos frame = new GestionEquipos(admin);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public GestionEquipos(Admin admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 560);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 60, 521, 28);
		contentPane.add(textField);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.addActionListener(e -> {
			buscarEquipo(textField.getText());
		});
		btnBuscar.setBounds(541, 60, 85, 28);
		contentPane.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 109, 796, 249);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblSeleccionado = new JLabel();
		lblSeleccionado.setBounds(10, 368, 760, 20);
		contentPane.add(lblSeleccionado);

		model = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Ciudad", "Estadio", "Fundación", "Temporadas", "Campeonatos" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Integer.class,
					Integer.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};

		table.setModel(model);

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 10, 85, 21);
		btnVolver.addActionListener(e -> {

			new AdminMenu(admin).run(admin);
			dispose();
		});
		contentPane.add(btnVolver);

		// Acción al seleccionar fila
		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int row = table.getSelectedRow();
				if (row != -1) {
					equipoSeleccionado = new Equipo((String) model.getValueAt(row, 0),
							(String) model.getValueAt(row, 1), (String) model.getValueAt(row, 2),
							(String) model.getValueAt(row, 3), (Integer) model.getValueAt(row, 4),
							(Integer) model.getValueAt(row, 5)

					);
					lblSeleccionado.setText(
							"Seleccionado: " + equipoSeleccionado.getNombre() + ", " + equipoSeleccionado.getCiudad());

				}
			}
		});

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAgregar.setBounds(313, 473, 150, 40);
		btnAgregar.addActionListener(e -> {
		    JTextField nombreField = new JTextField();
		    JTextField ciudadField = new JTextField();
		    JTextField estadioField = new JTextField();
		    JTextField fundacionField = new JTextField();
		    JSpinner spinnerTemporadas = new JSpinner(new SpinnerNumberModel(1, 1, 40, 1));
		    JSpinner spinnerCampeonatos = new JSpinner(new SpinnerNumberModel(0, 0, 40, 1));

		    Object[] fields = {
		        "Nombre:", nombreField,
		        "Ciudad:", ciudadField,
		        "Estadio:", estadioField,
		        "Fecha de Fundación [YYYY-MM-DD]:", fundacionField,
		        "Temporadas en Liga:", spinnerTemporadas,
		        "Campeonatos:", spinnerCampeonatos
		    };

		    int option = JOptionPane.showConfirmDialog(null, fields, "Agregar Equipo", JOptionPane.OK_CANCEL_OPTION);

		    if (option == JOptionPane.OK_OPTION) {
		        String nombre = nombreField.getText().trim();
		        String ciudad = ciudadField.getText().trim();
		        String estadio = estadioField.getText().trim();
		        String fechaFundacion = fundacionField.getText().trim();

		        if (nombre.isEmpty() || ciudad.isEmpty() || estadio.isEmpty() || fechaFundacion.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "No se permiten campos vacíos");
		            return;
		        }

		         
		        try {
		            java.sql.Date.valueOf(fechaFundacion); 

		            Equipo equipo = new Equipo(
		                nombre, ciudad, estadio, fechaFundacion,
		                (Integer) spinnerTemporadas.getValue(),
		                (Integer) spinnerCampeonatos.getValue()
		            );

		            if (DLLEquipo.crearEquipo(equipo)) {
		                JOptionPane.showMessageDialog(null, "Equipo creado correctamente");
		                cargarTabla();
		            } else {
		                JOptionPane.showMessageDialog(null, "Error al crear equipo, por favor vuelva a intentarlo.");
		            }

		        } catch (IllegalArgumentException ex) {
		            JOptionPane.showMessageDialog(null, "La fecha debe estar en formato válido: YYYY-MM-DD");
		        }
		    }
		});

		contentPane.add(btnAgregar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditar.setBounds(475, 473, 150, 40);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (equipoSeleccionado != null) {
					JTextField nombreField = new JTextField();
					nombreField.setText(equipoSeleccionado.getNombre());
				    JTextField ciudadField = new JTextField();
				    ciudadField.setText(equipoSeleccionado.getCiudad());
				    JTextField estadioField = new JTextField();
				    estadioField.setText(equipoSeleccionado.getEstadio());
				    JTextField fundacionField = new JTextField();
				    fundacionField.setText(equipoSeleccionado.getFechaDeFundacion());
				    JSpinner spinnerTemporadas = new JSpinner(new SpinnerNumberModel(equipoSeleccionado.getTemporadasEnLiga(), 1, 40, 1));
				    JSpinner spinnerCampeonatos = new JSpinner(new SpinnerNumberModel(equipoSeleccionado.getCampeonatos(), 0, 40, 1));

				    Object[] fields = {
				        "Nombre:", nombreField,
				        "Ciudad:", ciudadField,
				        "Estadio:", estadioField,
				        "Fecha de Fundación [YYYY-MM-DD]:", fundacionField,
				        "Temporadas en Liga:", spinnerTemporadas,
				        "Campeonatos:", spinnerCampeonatos
				    };

				    int option = JOptionPane.showConfirmDialog(null, fields, "Editar Equipo", JOptionPane.OK_CANCEL_OPTION);

				    if (option == JOptionPane.OK_OPTION) {
				        String nombre = nombreField.getText().trim();
				        String ciudad = ciudadField.getText().trim();
				        String estadio = estadioField.getText().trim();
				        String fechaFundacion = fundacionField.getText().trim();
				        
				        int id = DLLEquipo.buscarID(equipoSeleccionado.getNombre());

				        if (nombre.isEmpty() || ciudad.isEmpty() || estadio.isEmpty() || fechaFundacion.isEmpty()) {
				            JOptionPane.showMessageDialog(null, "No se permiten campos vacíos");
				            return;
				        }

				         
				        try {
				            java.sql.Date.valueOf(fechaFundacion); 

				            Equipo editado = new Equipo(
				                nombre, ciudad, estadio, fechaFundacion,
				                (Integer) spinnerTemporadas.getValue(),
				                (Integer) spinnerCampeonatos.getValue()
				            );

				            if (DLLEquipo.editarEquipo(editado, id)) {
				                JOptionPane.showMessageDialog(null, "Equipo editado correctamente");
				                cargarTabla();
				            } else {
				                JOptionPane.showMessageDialog(null, "Error al editar equipo, por favor vuelva a intentarlo.");
				            }

				        } catch (IllegalArgumentException ex) {
				            JOptionPane.showMessageDialog(null, "La fecha debe estar en formato válido: YYYY-MM-DD");
				        }
				    }
				} else {
					lblSeleccionado.setText("Seleccione un equipo");
					
				}

			}
		});
		contentPane.add(btnEditar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEliminar.setBounds(635, 473, 150, 40);
		btnEliminar.addActionListener(e -> {

			if (equipoSeleccionado != null) {
				int ans = JOptionPane.showOptionDialog(null, "¿Estás seguro de que querés eliminar este equipo?",
						"Confirmar acción", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1);

				if (ans == 0) {

					if (DLLEquipo.eliminarEquipo(equipoSeleccionado)) {
						JOptionPane.showMessageDialog(null, "Equipo eliminado correctamente.");
					} else {
						JOptionPane.showMessageDialog(null,
								"Error al eliminar equipo, por favor vuelva a intentarlo más tarde.");
					}
				}
			} else {
				lblSeleccionado.setText("Seleccione un equipo");
				;
			}

			cargarTabla();

		});
		contentPane.add(btnEliminar);

		/*
		 * JComboBox comboBoxEquipo = new JComboBox(); comboBoxEquipo.setBounds(83, 441,
		 * 156, 28); contentPane.add(comboBoxEquipo);
		 * 
		 * JLabel lblEquipo = new JLabel("Equipo"); lblEquipo.setFont(new Font("Tahoma",
		 * Font.PLAIN, 18)); lblEquipo.setBounds(10, 439, 76, 30);
		 * contentPane.add(lblEquipo);
		 */

		cargarTabla();

	}

	public void cargarTabla() {
		LinkedList<Equipo> equipos = DLLEquipo.mostrarEquipos();
		equipos.sort(Comparator.comparing(Equipo::getNombre));

		model.setRowCount(0);
		for (Equipo eq : equipos) {
			model.addRow(new Object[] { eq.getNombre(), eq.getCiudad(), eq.getEstadio(), eq.getFechaDeFundacion(),
					eq.getTemporadasEnLiga(), eq.getCampeonatos() });
		}
	}

	public void buscarEquipo(String texto) {
		LinkedList<Equipo> listados = DLLEquipo.mostrarEquipos().stream()
				.filter(e -> e.getNombre().toLowerCase().contains(texto.toLowerCase()))
				.sorted(Comparator.comparing(Equipo::getNombre, String.CASE_INSENSITIVE_ORDER))
				.collect(Collectors.toCollection(LinkedList::new));

		model.setRowCount(0);
		for (Equipo eq : listados) {
			model.addRow(new Object[] { eq.getNombre(), eq.getCiudad(), eq.getEstadio(), eq.getFechaDeFundacion(),
					eq.getTemporadasEnLiga(), eq.getCampeonatos() });
		}
	}
}
