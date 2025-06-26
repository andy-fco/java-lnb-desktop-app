package DLL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;

import BLL.Articulo;

public class DLLArticulo {

	private static Connection con = Conexion.getInstance().getConnection();

	// CREAR ARTICULO
	public static boolean crearArticulo(Articulo articulo) {
		boolean flag = false;
		LocalDate fecha = LocalDate.now();
		try {
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO articulos (titulo, descripcion, fecha) VALUES (?, ?, ?)");
			stmt.setString(1, articulo.getTitulo());
			stmt.setString(2, articulo.getDescripcion());
			stmt.setDate(3, Date.valueOf(fecha));

			int filas = stmt.executeUpdate();
			if (filas > 0) {
				System.out.print("Artículo cargado correctamente.");
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	// LISTAR ARTICULOS
	public static LinkedList<Articulo> mostrarArticulos() {
	    LinkedList<Articulo> articulos = new LinkedList<>();

	    try {
	        PreparedStatement stmt = con.prepareStatement("SELECT * FROM articulos");
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	           
	            
	            String titulo = rs.getString("titulo");
	            String descr = rs.getString("descripcion");
	            String fecha = rs.getString("fecha");  

	            articulos.add(new Articulo(titulo, descr, fecha));
	        }

	        rs.close();
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return articulos;
	}
	// EDITAR ARTICULO
	public static boolean editarArticulo(Articulo articulo, String titulo_viejo) {
	    boolean flag = false;

	    try {
	        PreparedStatement stmt = con.prepareStatement(
	            "UPDATE articulos SET titulo = ?, descripcion = ? WHERE titulo = ?"
	        );
	        stmt.setString(1, articulo.getTitulo());
	        stmt.setString(2, articulo.getDescripcion());
	        stmt.setString(3, titulo_viejo);
	        

	        int filas = stmt.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Artículo actualizado correctamente.");
	            flag = true;
	        }

	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return flag;
	}
	// ELIMINAR ARTICULO
	public static boolean eliminarArticulo(Articulo articulo) {
	    boolean flag = false;

	    try {
	        PreparedStatement stmt = con.prepareStatement("DELETE FROM articulos WHERE titulo = ?");
	        stmt.setString(1, articulo.getTitulo());

	        int filas = stmt.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Artículo eliminado correctamente.");
	            flag = true;
	        }

	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return flag;
	}

}
