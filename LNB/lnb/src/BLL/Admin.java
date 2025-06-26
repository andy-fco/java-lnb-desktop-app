package BLL;



import java.util.LinkedList;

import javax.swing.JOptionPane;


import DLL.DLLAdmin;

import repository.Encriptador;

public class Admin extends Usuario implements Encriptador {

	// Atributos
	//private static Connection con = Conexion.getInstance().getConnection();

	// Constructor
	public Admin(String nobmre, String apellido, String id, String pass) {
		super(nobmre, apellido, id, pass);

	}

	public Admin() {
	}

	// Setters & Getters

	// Otros Métodos

	public static Admin login(String id, String pass) {
		Admin admin = new Admin();
		

		if (id.isEmpty() || pass.isEmpty()) {
			System.out.print("No se permiten campos vacíos");

		} else {
			admin = DLLAdmin.login(id, pass);

		}
		System.out.print(admin);
		return admin;

	}


	
	
	//AGREGAR ADMINISTRADOR
	public static void agregarAdmin(String nombre, String apellido, String id, String pass) {
		if (nombre.isEmpty() || apellido.isEmpty() || id.isEmpty() || pass.isEmpty()) {

			System.out.print("No se permiten campos vacíos");

		} else {
			
			Admin nuevo = new Admin(nombre, apellido, id, pass);
			
			LinkedList<Admin> existentes = DLLAdmin.mostrarAdmins();
			boolean esUnico = true;
			
			for (Admin existente : existentes) {
				if (existente.getId().equals(nuevo.getId())) {
					esUnico = false;
					break;
				}
			}
			
			if (!esUnico) {
				JOptionPane.showMessageDialog(null, "El usuario ingresado ya existe");
			} else {
				if (DLLAdmin.agregarAdmin(nuevo)) {
					JOptionPane.showMessageDialog(null, "Administrador registrado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Error al registrar administrador");
				}
			}
				
			
			
			
				

			}
	}

	//LISTAR USUARIOS
	//Aficionados
	public static LinkedList<Aficionado> mostrarAficionados() {
		LinkedList<Aficionado> aficionados = DLLAdmin.mostrarAficionados();
		
		return aficionados;
	}
	
	//Administradores
	public LinkedList<Admin> mostrarAdmins(){
		LinkedList<Admin> admins = DLLAdmin.mostrarAdmins();
		
		for (Admin admin : admins) {
			if (admin.getId().equals(this.getId())) {
				admins.remove(admin);
			}
		}
		
		return admins;
	}
	
	//Ambos
	public LinkedList<Usuario> mostrarUsuarios(){
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		LinkedList<? extends Usuario> aficionados = mostrarAficionados();
		LinkedList<? extends Usuario> admins = mostrarAdmins();
		
		usuarios.addAll(aficionados);
		usuarios.addAll(admins);
		
		return usuarios;
		
	}

	@Override
	public String toString() {
		return "Admin: " + super.toString();
	}

}
