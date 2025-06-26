package DLL;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.LinkedList;

import BLL.Aficionado;

import BLL.Evento;

public class DLLEvento {

	private static Connection con = Conexion.getInstance().getConnection();

	//CREAR EVENTO
	public static boolean crearEvento(Evento evento) {
		boolean flag = false;
		
		try {
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO eventos (titulo, descripcion, fecha_y_hora, cap_max) VALUES (?, ?, ?, ?)");
			stmt.setString(1, evento.getTitulo());
			stmt.setString(2, evento.getDescripcion());
			stmt.setTimestamp(3, Timestamp.valueOf(evento.getFechaYHora()));
			stmt.setInt(4, evento.getCapMax());

			int filas = stmt.executeUpdate();
			if (filas > 0) {
				System.out.print("Evento cargado correctamente.");
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	//LISTAR EVENTOS
	public static LinkedList<Evento> mostrarEventos() {
	    LinkedList<Evento> eventos = new LinkedList<>();

	    try {
	        PreparedStatement stmt = con.prepareStatement("SELECT * FROM eventos");
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	           
	            
	            String titulo = rs.getString("titulo");
	            String descr = rs.getString("descripcion");
	            LocalDateTime fecha = rs.getTimestamp("fecha_y_hora").toLocalDateTime();
	            int cap = rs.getInt("cap_max");

	            eventos.add(new Evento(titulo, descr, fecha, cap));
	        }

	        rs.close();
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return eventos;
	}
	//EDITAR EVENTO
	public static boolean editarEvento(Evento evento, String titulo_viejo) {
	    boolean flag = false;

	    try {
	        PreparedStatement stmt = con.prepareStatement(
	        		"UPDATE eventos SET titulo = ?, descripcion = ?, fecha_y_hora = ?, cap_max = ? WHERE titulo = ?"

	        );
	        stmt.setString(1, evento.getTitulo());
	        stmt.setString(2, evento.getDescripcion());
	        stmt.setTimestamp(3, Timestamp.valueOf(evento.getFechaYHora()));
	        stmt.setInt(4, evento.getCapMax());
	        stmt.setString(5, titulo_viejo);

	        int filas = stmt.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Evento actualizado correctamente.");
	            flag = true;
	        }

	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return flag;
	}
	//ELIMINAR EVENTO
	public static boolean eliminarEvento(Evento evento) {
	    boolean flag = false;

	    try {
	        PreparedStatement stmt = con.prepareStatement("DELETE FROM eventos WHERE titulo = ?");
	        stmt.setString(1, evento.getTitulo());

	        int filas = stmt.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Evento eliminado correctamente.");
	            flag = true;
	        }

	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return flag;
	}
	
	//BUSCAR ID POR TITULO
	public static int buscarIDPorTitulo(String titulo) {
	    try (PreparedStatement stmt = con.prepareStatement("SELECT id FROM eventos WHERE titulo = ?")) {
	        stmt.setString(1, titulo);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) return rs.getInt("id");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

	
	//AGREGAR INSCRIPCIÓN
	public static boolean inscribir(Evento evento, Aficionado aficionado) {
		boolean flag = false;
		int id_a = DLLAficionado.buscarIdAficionado(aficionado);
		int id_e = buscarIDPorTitulo(evento.getTitulo());
		
		
		
		if (id_a != 0 && id_e != 0) {
			try {
				PreparedStatement stmt = con
						.prepareStatement("INSERT INTO evento_aficionado (id_evento, id_aficionado) VALUES (?, ?)");
				stmt.setInt(1, id_e);
				stmt.setInt(2, id_a);

				int filas = stmt.executeUpdate();
				if (filas > 0) {
					System.out.print("Inscripción cargado correctamente.");
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	
	//VER INSCRIPCIONES
	
	public static LinkedList<Aficionado> mostrarInscripciones(Evento evento) {
	    LinkedList<Aficionado> inscriptos = new LinkedList<>();

	    try (
	        PreparedStatement stmt = con.prepareStatement(
	            "SELECT a.* " +
	            "FROM aficionados a " +
	            "JOIN evento_aficionado ea ON a.id = ea.id_aficionado " +
	            "JOIN eventos e ON e.id = ea.id_evento " +
	            "WHERE e.titulo = ?"
	        )
	    ) {
	        stmt.setString(1, evento.getTitulo());

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                String nombre = rs.getString("nombre");
	                String apellido = rs.getString("apellido");
	                String id_usuario = rs.getString("id_usuario");
	                String pass = rs.getString("pass");
	                String email = rs.getString("email");
	                String dOfBirth = rs.getString("d_of_birth");

	                inscriptos.add(new Aficionado(nombre, apellido, id_usuario, pass, email, dOfBirth));
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return inscriptos;
	}

	//ELIMINAR INSCRPICIÓN
	public static boolean eliminarInscripcion(Evento evento, Aficionado aficionado) {
	    boolean flag = false;

	    try (
	        PreparedStatement stmt = con.prepareStatement(
	            "DELETE FROM evento_aficionado " +
	            "WHERE id_evento = (SELECT id FROM eventos WHERE titulo = ?) " +
	            "AND id_aficionado = (SELECT id FROM aficionados WHERE id_usuario = ?)"
	        )
	    ) {
	        stmt.setString(1, evento.getTitulo());
	        stmt.setString(2, aficionado.getId());

	        int filas = stmt.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Inscripción eliminada correctamente.");
	            flag = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return flag;
	}

	
}
