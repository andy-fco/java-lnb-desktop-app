package DLL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.LinkedList;

import BLL.Aficionado;
import BLL.Equipo;
import BLL.Jugador;

public class DLLJugador {

	private static Connection con = Conexion.getInstance().getConnection();

	//CREAR JUGADOR
	public static boolean crearJugador(Jugador jugador) {
	    boolean flag = false;

	    try {
	        PreparedStatement stmt = con.prepareStatement(
	            "INSERT INTO jugadores (nombre, apellido, camiseta, media, posicion, nacionalidad, tiro, dribling, velocidad, pase, defensa, " +
	            "salto, d_of_birth, ciudad, altura, mano_habil, especialidad, jugada, aficionado_id, equipo) " +
	            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
	        );

	        stmt.setString(1, jugador.getNombre());
	        stmt.setString(2, jugador.getApellido());
	        stmt.setInt(3, jugador.getCamiseta());
	        stmt.setInt(4, jugador.getMedia());
	        stmt.setString(5, jugador.getPosicion());
	        stmt.setString(6, jugador.getNacionalidad());
	        stmt.setInt(7, jugador.getTiro());
	        stmt.setInt(8, jugador.getDribling());
	        stmt.setInt(9, jugador.getVelocidad());
	        stmt.setInt(10, jugador.getPase());
	        stmt.setInt(11, jugador.getDefensa());
	        stmt.setInt(12, jugador.getSalto());
	        stmt.setDate(13, Date.valueOf(jugador.getdOfBirth()));
	        stmt.setString(14, jugador.getCiudad());
	        stmt.setFloat(15, jugador.getAltura());
	        stmt.setString(16, jugador.getManoHabil());
	        stmt.setString(17, jugador.getEspecialidad());
	        stmt.setString(18, jugador.getJugada());
	        if (jugador.getAficionado() != null) {
	            stmt.setInt(19, jugador.getAficionado()); // Suponiendo que sea el quinto parámetro
	        } else {
	            stmt.setNull(19, java.sql.Types.INTEGER);
	        }
	        
	        if (jugador.getEquipo() != null) {
	            stmt.setInt(20, DLLEquipo.buscarID( jugador.getEquipo().getNombre()));
	        } else {
	            stmt.setNull(20, Types.INTEGER);
	        }

	        
	         

	        int filas = stmt.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Jugador cargado correctamente.");
	            flag = true;
	        }

	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return flag;
	}

	
	//LISTAR JUGADORES
	public static LinkedList<Jugador> mostrarJugadores() {
	    LinkedList<Jugador> jugadores = new LinkedList<>();

	    try {
	        PreparedStatement stmt = con.prepareStatement("SELECT * FROM jugadores WHERE aficionado_id IS NULL");
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	           
	        	String nombre = rs.getString("nombre");
	            String apellido = rs.getString("apellido");
	            int camiseta = rs.getInt("camiseta");
	            int media = rs.getInt("media");
	            String posicion = rs.getString("posicion");
	            String nacionalidad = rs.getString("nacionalidad");
	            int equipo_id = rs.getInt("equipo");
	            int tiro = rs.getInt("tiro");
	            int dribling = rs.getInt("dribling");
	            int velocidad = rs.getInt("velocidad");
	            int pase = rs.getInt("pase");
	            int defensa = rs.getInt("defensa");
	            int salto = rs.getInt("salto");
	            String d_of_birth = rs.getString("d_of_birth");  
	            String ciudad = rs.getString("ciudad");
	            float altura = rs.getFloat("altura");
	            String mano = rs.getString("mano_habil");
	            String especialidad = rs.getString("especialidad");
	            String jugada = rs.getString("jugada");
	            
	            Equipo equipo = DLLEquipo.buscarEquipoPorId(equipo_id);
	            
	            Jugador j = new Jugador(nombre, apellido, camiseta, media, posicion, nacionalidad, equipo, tiro, dribling, pase, velocidad, defensa, salto, 
	            		d_of_birth, ciudad, altura, mano, especialidad, jugada);
	            
	            
	            jugadores.add(j);
	        }

	        rs.close();
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return jugadores;
	}
	
	
	
	
	
	//LISTAR JUGADORES POR POSICION
	public static LinkedList<Jugador> mostrarJugadoresPorPosicion(String posicion) {
	    LinkedList<Jugador> jugadores = new LinkedList<>();

	    try {
	        PreparedStatement stmt = con.prepareStatement(
	            "SELECT * FROM jugadores WHERE aficionado_id IS NULL AND posicion LIKE ?"
	        );
	        stmt.setString(1, "%" + posicion + "%"); 

	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            String nombre = rs.getString("nombre");
	            String apellido = rs.getString("apellido");
	            int camiseta = rs.getInt("camiseta");
	            int media = rs.getInt("media");
	            String pos = rs.getString("posicion");
	            String nacionalidad = rs.getString("nacionalidad");
	            int equipo_id = rs.getInt("equipo");
	            int tiro = rs.getInt("tiro");
	            int dribling = rs.getInt("dribling");
	            int velocidad = rs.getInt("velocidad");
	            int pase = rs.getInt("pase");
	            int defensa = rs.getInt("defensa");
	            int salto = rs.getInt("salto");
	            String d_of_birth = rs.getString("d_of_birth");
	            String ciudad = rs.getString("ciudad");
	            float altura = rs.getFloat("altura");
	            String mano = rs.getString("mano_habil");
	            String especialidad = rs.getString("especialidad");
	            String jugada = rs.getString("jugada");

	            Equipo equipo = DLLEquipo.buscarEquipoPorId(equipo_id);

	            Jugador j = new Jugador(
	                nombre, apellido, camiseta, media, pos, nacionalidad, equipo,
	                tiro, dribling, pase, velocidad, defensa, salto,
	                d_of_birth, ciudad, altura, mano, especialidad, jugada
	            );

	            jugadores.add(j);
	        }

	        rs.close();
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return jugadores;
	}

	
	
	//EDITAR JUGADOR
	public static boolean editarJugador(Jugador jugador, int id) {
	    boolean flag = false;

	    try {
	        PreparedStatement stmt = con.prepareStatement(
	            "UPDATE jugadores SET nombre = ?, apellido = ?, camiseta = ?, media = ?, posicion = ?, nacionalidad = ?, " +
	            "tiro = ?, dribling = ?, velocidad = ?, pase = ?, defensa = ?, salto = ?, " +
	            "d_of_birth = ?, ciudad = ?, altura = ?, mano_habil = ?, especialidad = ?, jugada = ?" +
	            "WHERE id = ?"
	        );

	        stmt.setString(1, jugador.getNombre());
	        stmt.setString(2, jugador.getApellido());
	        stmt.setInt(3, jugador.getCamiseta());
	        stmt.setInt(4, jugador.getMedia());
	        stmt.setString(5, jugador.getPosicion());
	        stmt.setString(6, jugador.getNacionalidad());
	        stmt.setInt(7, jugador.getTiro());
	        stmt.setInt(8, jugador.getDribling());
	        stmt.setInt(9, jugador.getVelocidad());
	        stmt.setInt(10, jugador.getPase());
	        stmt.setInt(11, jugador.getDefensa());
	        stmt.setInt(12, jugador.getSalto());
	        stmt.setDate(13, Date.valueOf(jugador.getdOfBirth()));
	        stmt.setString(14, jugador.getCiudad());
	        stmt.setFloat(15, jugador.getAltura());
	        stmt.setString(16, jugador.getManoHabil());
	        stmt.setString(17, jugador.getEspecialidad());
	        stmt.setString(18, jugador.getJugada());
	        
	        stmt.setInt(19, id);

	        int filas = stmt.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Jugador actualizado correctamente.");
	            flag = true;
	        }

	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return flag;
	}
	
	public static boolean mejorarJugador(int media, int tiro, int dribling, int pase, int velocidad, int defensa, int salto, int aficionado) {
	    boolean flag = false;

	    try {
	        PreparedStatement stmt = con.prepareStatement(
	            "UPDATE jugadores SET  media = ?, " +
	            "tiro = ?, dribling = ?, pase = ?, velocidad = ?, defensa = ?, salto = ? " +
	            "WHERE aficionado_id = ?"
	        );

	        stmt.setInt(1, media);
	        stmt.setInt(2, tiro);
	        stmt.setInt(3, dribling);
	        stmt.setInt(4, pase);
	        stmt.setInt(5, velocidad);
	        stmt.setInt(6, defensa);
	        stmt.setInt(7, salto);
	        stmt.setInt(8, aficionado);
	        

	        int filas = stmt.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Jugador actualizado correctamente.");
	            flag = true;
	        }

	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return flag;
	}

	//ELIMINAR JUGADOR
	public static boolean eliminarJugador(int id) {
	    boolean flag = false;

	    try (
	        PreparedStatement stmt = con.prepareStatement("DELETE FROM jugadores WHERE id = ?")
	    ) {
	        stmt.setInt(1, id);

	        int filas = stmt.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Jugador eliminado correctamente.");
	            flag = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return flag;
	}

	//BUSCAR ID DE JUGADOR
	public static int buscarID(Jugador jugador) {
	    int id = -1;
	    int idEquipo = -1;

	    idEquipo = DLLEquipo.buscarID(jugador.getEquipo().getNombre());

	    if (idEquipo != -1) {
	        try (
	            PreparedStatement stmt = con.prepareStatement(
	                "SELECT id FROM jugadores WHERE equipo = ? AND camiseta = ?")
	        ) {
	            stmt.setInt(1, idEquipo);
	            stmt.setInt(2, jugador.getCamiseta());

	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    id = rs.getInt("id");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return id;
	}
	
	//BUSCAR JUGADOR POR ID
	public static Jugador buscarJugadorPorId(int id) {
	    Jugador jugador = null;

	    try (
	        PreparedStatement stmt = con.prepareStatement("SELECT * FROM jugadores WHERE id = ?")
	    ) {
	        stmt.setInt(1, id);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                String nombre = rs.getString("nombre");
	                String apellido = rs.getString("apellido");
	                int media = rs.getInt("media");
	                String posicion = rs.getString("posicion");
	                String nacionalidad = rs.getString("nacionalidad");
	                int equipo_id = rs.getInt("equipo");
	                int tiro = rs.getInt("tiro");
	                int dribling = rs.getInt("dribling");
	                int velocidad = rs.getInt("velocidad");
	                int pase = rs.getInt("pase");
	                int defensa = rs.getInt("defensa");
	                int salto = rs.getInt("salto");
	                String d_of_birth = rs.getString("d_of_birth");
	                String ciudad = rs.getString("ciudad");
	                float altura = rs.getFloat("altura");
	                String mano = rs.getString("mano_habil");
	                String especialidad = rs.getString("especialidad");
	                String jugada = rs.getString("jugada");
	                int camiseta = rs.getInt("camiseta");

	                
	                Equipo equipo = DLLEquipo.buscarEquipoPorId(equipo_id);

	                jugador = new Jugador(nombre, apellido, camiseta, media, posicion, nacionalidad, equipo,
	                        tiro, dribling, pase, velocidad, defensa, salto,
	                        d_of_birth, ciudad, altura, mano, especialidad, jugada);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return jugador;
	}
	
	//BUSCAR JUGADOR DE AFICIONADO
		public static Jugador buscarJugadorDeAficionado(Aficionado aficionado) {
		    Jugador jugador = null;
		    int id = DLLAficionado.buscarIdAficionado(aficionado);

		    try {
		        PreparedStatement stmt = con.prepareStatement("SELECT * FROM jugadores WHERE aficionado_id = ?");
		        stmt.setInt(1, id);
		        ResultSet rs = stmt.executeQuery();

		        if (rs.next()) {
		            String nombre = rs.getString("nombre");
		            String apellido = rs.getString("apellido");
		            int camiseta = rs.getInt("camiseta");
		            int media = rs.getInt("media");
		            String posicion = rs.getString("posicion");
		            String nacionalidad = rs.getString("nacionalidad");
		            int equipo_id = rs.getInt("equipo");
		            int tiro = rs.getInt("tiro");
		            int dribling = rs.getInt("dribling");
		            int velocidad = rs.getInt("velocidad");
		            int pase = rs.getInt("pase");
		            int defensa = rs.getInt("defensa");
		            int salto = rs.getInt("salto");
		            String d_of_birth = rs.getString("d_of_birth");
		            String ciudad = rs.getString("ciudad");
		            float altura = rs.getFloat("altura");
		            String mano = rs.getString("mano_habil");
		            String especialidad = rs.getString("especialidad");
		            String jugada = rs.getString("jugada");

		            Equipo equipo = DLLEquipo.buscarEquipoPorId(equipo_id);

		            jugador = new Jugador(nombre, apellido, camiseta, media, posicion, nacionalidad, equipo, tiro, dribling, pase,
		                    velocidad, defensa, salto, d_of_birth, ciudad, altura, mano, especialidad, jugada, id);
		        }

		        rs.close();
		        stmt.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return jugador;
		}

	

}
