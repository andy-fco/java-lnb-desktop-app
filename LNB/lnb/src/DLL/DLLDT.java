package DLL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import BLL.DT;
import BLL.Equipo;

public class DLLDT {
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	//CREAR DT
	public static boolean crearDT(DT dt) {
	    boolean flag = false;

	    try (
	        PreparedStatement stmt = con.prepareStatement(
	            "INSERT INTO dts (nombre, apellido, d_of_birth, nacionalidad, ciudad, temporadas_en_liga, equipo) " +
	            "VALUES (?, ?, ?, ?, ?, ?)"
	        )
	    ) {
	        stmt.setString(1, dt.getNombre());
	        stmt.setString(2, dt.getApellido());
	        stmt.setDate(3, Date.valueOf(dt.getdOfBirth())); 
	        stmt.setString(4, dt.getNacionalidad());
	        stmt.setString(5, dt.getCiudad());
	        stmt.setInt(6, dt.getTemporadasEnLiga());
	        stmt.setInt(7, DLLEquipo.buscarID(dt.getEquipo().getNombre()));
	        

	        int filas = stmt.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Director Técnico creado correctamente.");
	            flag = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return flag;
	}

	//LISTAR DT
	public static LinkedList<DT> mostrarDTs() {
	    LinkedList<DT> DTs = new LinkedList<>();

	    try (
	        PreparedStatement stmt = con.prepareStatement("SELECT * FROM dts");
	        ResultSet rs = stmt.executeQuery()
	    ) {
	        while (rs.next()) {
	            String nombre = rs.getString("nombre");
	            String apellido = rs.getString("apellido");
	            String dOfBirth = rs.getString("d_of_birth");
	            String nacionalidad = rs.getString("nacionalidad");
	            String ciudad = rs.getString("ciudad");
	            int temporadas = rs.getInt("temporadas_en_liga");
	            int equipoId = rs.getInt("equipo");

	            
	            Equipo equipo = DLLEquipo.buscarEquipoPorId(equipoId);

	            DT dt = new DT(nombre, apellido, dOfBirth, nacionalidad, ciudad, equipo, temporadas);
	            DTs.add(dt);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return DTs;
	}

	
	//EDITAR DT
	public static boolean editarDT(DT dt) {
	    boolean flag = false;
	    int idEquipo = -1;
	    
	    idEquipo = DLLEquipo.buscarID(dt.getEquipo().getNombre());
    
	    if (idEquipo != -1) {
	        try (
	            PreparedStatement stmt = con.prepareStatement(
	                "UPDATE dts SET nombre = ?, apellido = ?, d_of_birth = ?, nacionalidad = ?, ciudad = ?, temporadas_en_liga = ? " +
	                "WHERE equipo = ?"
	            )
	        ) {
	            stmt.setString(1, dt.getNombre());
	            stmt.setString(2, dt.getApellido());
	            stmt.setDate(3, Date.valueOf(dt.getdOfBirth()));
	            stmt.setString(4, dt.getNacionalidad());
	            stmt.setString(5, dt.getCiudad());
	            stmt.setInt(6, dt.getTemporadasEnLiga());
	            stmt.setInt(7, idEquipo);

	            int filas = stmt.executeUpdate();
	            if (filas > 0) {
	                System.out.println("Director Técnico actualizado correctamente.");
	                flag = true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return flag;
	}

	
	//ELIMINAR DT
	public static boolean eliminarDT(DT dt) {
	    boolean flag = false;
	    int idEquipo = -1;
	    
	    idEquipo = DLLEquipo.buscarID(dt.getEquipo().getNombre());

 	   
	     
	    if (idEquipo != -1) {
	        try (
	            PreparedStatement stmt = con.prepareStatement("DELETE FROM dts WHERE equipo = ?")
	        ) {
	            stmt.setInt(1, idEquipo);

	            int filas = stmt.executeUpdate();
	            if (filas > 0) {
	                System.out.println("Director Técnico eliminado correctamente.");
	                flag = true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return flag;
	}

	//ASIGNAR EQUIPO
}
