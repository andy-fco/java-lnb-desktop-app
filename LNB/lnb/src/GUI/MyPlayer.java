package GUI;

 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Aficionado;
import BLL.Jugador;
 

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JProgressBar;

public class MyPlayer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
			public void run(Aficionado user, Jugador myPlayer) {
				try {
					MyPlayer frame = new MyPlayer(user, myPlayer);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public MyPlayer(Aficionado user, Jugador myPlayer) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 500);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mi Jugador");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(268, 22, 180, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel(myPlayer.getNombre()+" "+myPlayer.getApellido());
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNombre.setBounds(55, 93, 338, 32);
		contentPane.add(lblNombre);
		
		JLabel lblCamiseta = new JLabel("#"+myPlayer.getCamiseta());
		lblCamiseta.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCamiseta.setBounds(55, 124, 63, 32);
		contentPane.add(lblCamiseta);
		
		JLabel lblPosicion = new JLabel(myPlayer.getPosicion());
		lblPosicion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPosicion.setBounds(99, 124, 241, 32);
		contentPane.add(lblPosicion);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad: " + myPlayer.getNacionalidad());
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNacionalidad.setBounds(356, 314, 304, 32);
		contentPane.add(lblNacionalidad);
		
		JLabel lblCiudad = new JLabel("Ciudad: "+myPlayer.getCiudad());
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCiudad.setBounds(356, 356, 304, 32);
		contentPane.add(lblCiudad);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento: "+myPlayer.getdOfBirth());
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaDeNacimiento.setBounds(356, 398, 304, 32);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblAltura = new JLabel("Altura: "+myPlayer.getAltura()+"m");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltura.setBounds(356, 272, 241, 32);
		contentPane.add(lblAltura);
		
		
		
		JLabel lblManoHabil = new JLabel("Mano Hábil: "+myPlayer.getManoHabil());
		lblManoHabil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblManoHabil.setBounds(356, 133, 304, 32);
		contentPane.add(lblManoHabil);
		
		JLabel lblEspecialidad = new JLabel("Especialidad: "+myPlayer.getEspecialidad());
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecialidad.setBounds(356, 179, 304, 32);
		contentPane.add(lblEspecialidad);
		
		JLabel lblJugada = new JLabel("Jugada Característica: "+myPlayer.getJugada());
		lblJugada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJugada.setBounds(356, 223, 304, 32);
		contentPane.add(lblJugada);
		
		JLabel lblMedia = new JLabel(String.valueOf(myPlayer.getMedia()));
		lblMedia.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblMedia.setBounds(10, 93, 63, 32);
		contentPane.add(lblMedia);
		
		JLabel lblTiro = new JLabel("Tiro "+myPlayer.getTiro());
		lblTiro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTiro.setBounds(10, 187, 131, 32);
		contentPane.add(lblTiro);
		
		JLabel lblVelocidad = new JLabel("Velocidad "+myPlayer.getVelocidad());
		lblVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVelocidad.setBounds(165, 187, 131, 32);
		contentPane.add(lblVelocidad);
		
		JLabel lblDribling = new JLabel("Dribling "+ myPlayer.getDribling());
		lblDribling.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDribling.setBounds(10, 261, 131, 32);
		contentPane.add(lblDribling);
		
		JLabel lblDefensa = new JLabel("Defensa "+myPlayer.getDefensa());
		lblDefensa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDefensa.setBounds(165, 261, 131, 32);
		contentPane.add(lblDefensa);
		
		JLabel lblPase = new JLabel("Pase "+myPlayer.getPase());
		lblPase.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPase.setBounds(10, 347, 131, 32);
		contentPane.add(lblPase);
		
		JLabel lblSalto = new JLabel("Salto "+myPlayer.getSalto());
		lblSalto.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSalto.setBounds(165, 347, 131, 32);
		contentPane.add(lblSalto);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu frame = new MainMenu(user);
				frame.run(user);
				dispose();
			}
		 });
		btnVolver.setBounds(10, 10, 85, 21);
		contentPane.add(btnVolver);
		
		JButton btnMejorar = new JButton("Mejorar");
		btnMejorar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMejorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.getPuntos()==0) {
					JOptionPane.showMessageDialog(null, "¡No tenés puntos! Usá la app y divertite en el menú de juegos"
							+ "\npara ganar puntos y canjealos por mejores estadísticas.");
				} else {
					MejorarMyPlayer frame = new MejorarMyPlayer(user,myPlayer);
					frame.run(user, myPlayer);
					dispose();
				}
			}
		 });
		btnMejorar.setBounds(247, 421, 93, 32);
		contentPane.add(btnMejorar);
		
		JLabel lblPuntos = new JLabel("Puntos: "+user.getPuntos());
		lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuntos.setBounds(10, 421, 131, 32);
		contentPane.add(lblPuntos);
		
		JProgressBar progressTiro = new JProgressBar(0,99);
		progressTiro.setValue(myPlayer.getTiro());
		progressTiro.setBounds(10, 229, 139, 21);
		contentPane.add(progressTiro);
		
		JProgressBar progressVel = new JProgressBar();
		progressVel.setValue(myPlayer.getVelocidad());
		progressVel.setBounds(165, 229, 139, 21);
		contentPane.add(progressVel);
		
		JProgressBar progressDri = new JProgressBar(0,99);
		progressDri.setValue(myPlayer.getDribling());
		progressDri.setBounds(10, 303, 139, 21);
		contentPane.add(progressDri);
		
		JProgressBar progressDef = new JProgressBar(0,99);
		progressDef.setValue(myPlayer.getDefensa());
		progressDef.setBounds(165, 303, 139, 21);
		contentPane.add(progressDef);
		
		JProgressBar progressPase = new JProgressBar(0,99);
		progressPase.setValue(myPlayer.getPase());
		progressPase.setBounds(10, 390, 139, 21);
		contentPane.add(progressPase);
		
		JProgressBar progressSalto = new JProgressBar(0,99);
		progressSalto.setValue(myPlayer.getSalto());
		progressSalto.setBounds(165, 390, 139, 21);
		contentPane.add(progressSalto);
	}
}
