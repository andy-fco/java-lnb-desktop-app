package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Aficionado;
import BLL.Jugador;
import DLL.DLLJugador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class ElegirQuinteto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	 
			public void run(Aficionado user) {
				try {
					ElegirQuinteto frame = new ElegirQuinteto(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
 

	/**
	 * Create the frame.
	 */
	public ElegirQuinteto(Aficionado user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 477);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elegir Quinteto Ideal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(187, 22, 342, 49);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Base");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(10, 121, 176, 38);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblEscolta = new JLabel("Escolta");
		lblEscolta.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblEscolta.setBounds(10, 213, 176, 38);
		getContentPane().add(lblEscolta);
		
		JLabel lblAlero = new JLabel("Alero");
		lblAlero.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAlero.setBounds(10, 312, 176, 38);
		getContentPane().add(lblAlero);
		
		JLabel lblAlapivot = new JLabel("Ala-Pivot");
		lblAlapivot.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAlapivot.setBounds(342, 121, 112, 38);
		getContentPane().add(lblAlapivot);
		
		JLabel lblPivot = new JLabel("Pivot");
		lblPivot.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPivot.setBounds(342, 213, 176, 38);
		getContentPane().add(lblPivot);
		
		JComboBox<Jugador> comboBoxBase = new JComboBox<>();
		comboBoxBase.setBounds(10, 159, 322, 38);
		
		DefaultComboBoxModel<Jugador> modeloBases = new DefaultComboBoxModel<>();

		for (Jugador j : cargarBases()) {
		    modeloBases.addElement(j);
		}

		comboBoxBase.setModel(modeloBases);
		getContentPane().add(comboBoxBase);
		
		JComboBox<Jugador> comboBoxEscolta = new JComboBox<Jugador>();
		comboBoxEscolta.setBounds(10, 252, 322, 38);
		DefaultComboBoxModel<Jugador> modeloEscoltas = new DefaultComboBoxModel<>();

		for (Jugador j : cargarEscoltas()) {
		    modeloEscoltas.addElement(j);
		}

		comboBoxEscolta.setModel(modeloEscoltas);
		getContentPane().add(comboBoxEscolta);
		
		JComboBox<Jugador> comboBoxAlero = new JComboBox<Jugador>();
		comboBoxAlero.setBounds(10, 348, 322, 38);
		DefaultComboBoxModel<Jugador> modeloAleros = new DefaultComboBoxModel<>();

		for (Jugador j : cargarAleros()) {
		    modeloAleros.addElement(j);
		}

		comboBoxAlero.setModel(modeloAleros);
		getContentPane().add(comboBoxAlero);
		
		JComboBox<Jugador> comboBoxAlaPivot = new JComboBox<Jugador>();
		comboBoxAlaPivot.setBounds(342, 159, 322, 38);
		DefaultComboBoxModel<Jugador> modeloAlaPivots = new DefaultComboBoxModel<>();

		for (Jugador j : cargarAlaPivots()) {
		    modeloAlaPivots.addElement(j);
		}

		comboBoxAlaPivot.setModel(modeloAlaPivots);
		getContentPane().add(comboBoxAlaPivot);
		
		JComboBox<Jugador> comboBoxPivot = new JComboBox<Jugador>();
		comboBoxPivot.setBounds(342, 252, 322, 38);
		DefaultComboBoxModel<Jugador> modeloPivots = new DefaultComboBoxModel<>();

		for (Jugador j : cargarPivots()) {
		    modeloPivots.addElement(j);
		}

		comboBoxPivot.setModel(modeloPivots);
		getContentPane().add(comboBoxPivot);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblRepetido = new JLabel("");
		lblRepetido.setForeground(Color.RED);
		lblRepetido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRepetido.setBounds(10, 396, 656, 34);
		getContentPane().add(lblRepetido);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 10, 85, 21);
		btnVolver.setBounds(10, 10, 85, 21);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Perfil frame = new Perfil(user);
				frame.run(user);
				dispose();
			}
		});
		getContentPane().add(btnVolver);
		
		JButton btnElegir = new JButton("Elegir");
		btnElegir.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jugador base = (Jugador) comboBoxBase.getSelectedItem();
		        Jugador escolta = (Jugador) comboBoxEscolta.getSelectedItem();
		        Jugador alero = (Jugador) comboBoxAlero.getSelectedItem();
		        Jugador alaPivot = (Jugador) comboBoxAlaPivot.getSelectedItem();
		        Jugador pivot = (Jugador) comboBoxPivot.getSelectedItem();

		         
		        Set<Integer> ids = new HashSet<>();

		        ids.add(DLLJugador.buscarID(base));
		        ids.add(DLLJugador.buscarID(escolta));
		        ids.add(DLLJugador.buscarID(alero));
		        ids.add(DLLJugador.buscarID(alaPivot));
		        ids.add(DLLJugador.buscarID(pivot));

		        if (ids.size() < 5) {
		            lblRepetido.setText( "No podés elegir el mismo jugador más de una vez.");
		            return;
		        }

		       
		        if (user.asignarQuinteto(base, escolta, alero, alaPivot, pivot)) {
		            JOptionPane.showMessageDialog(null, "Quinteto asignado con éxito.");
		            Perfil frame = new Perfil(user);
					frame.run(user);
					dispose();
		        } else {
		            JOptionPane.showMessageDialog(null, "Ocurrió un error al asignar el quinteto.");
		        }
				
				
			}
		});
		btnElegir.setBounds(504, 348, 160, 38);
		getContentPane().add(btnElegir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Perfil frame = new Perfil(user);
				frame.run(user);
				dispose();
			}
		});
		btnCancelar.setBounds(342, 348, 160, 38);
		getContentPane().add(btnCancelar);
		
		
		
		
		
		
	}
	
	//METODOS
	public static LinkedList<Jugador> cargarBases(){
		LinkedList<Jugador> bases = DLLJugador.mostrarJugadoresPorPosicion("Base");

		bases.sort(Comparator.comparing(j -> j.getEquipo().getNombre()));
		
		return bases;
	}
	public static LinkedList<Jugador> cargarEscoltas(){
		LinkedList<Jugador> escoltas = DLLJugador.mostrarJugadoresPorPosicion("Escolta");

		escoltas.sort(Comparator.comparing(j -> j.getEquipo().getNombre()));
		
		return escoltas;
	}
	public static LinkedList<Jugador> cargarAleros(){
		LinkedList<Jugador> aleros = DLLJugador.mostrarJugadoresPorPosicion("Alero");

		aleros.sort(Comparator.comparing(j -> j.getEquipo().getNombre()));
		
		return aleros;
	}
	public static LinkedList<Jugador> cargarAlaPivots(){
		LinkedList<Jugador> alaPivots = DLLJugador.mostrarJugadoresPorPosicion("Ala-Pivot");

		alaPivots.sort(Comparator.comparing(j -> j.getEquipo().getNombre()));
		
		return alaPivots;
	}
	public static LinkedList<Jugador> cargarPivots(){
		LinkedList<Jugador> pivots = DLLJugador.mostrarJugadoresPorPosicion("Pivot");

		pivots.sort(Comparator.comparing(j -> j.getEquipo().getNombre()));
		
		return pivots;
	}

}
