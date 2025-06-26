package BLL;


public class Articulo {
	
	//Atributos
	private String titulo;
	private String descripcion;
	private String fecha;
	
	//Constructor
	public Articulo(String titulo, String descripcion, String fecha) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}
	
	
	//Getters & Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	//To String
	@Override
	public String toString() {
		return "Fecha: "+fecha+" | Título: " + titulo ;
	}
	
	
	
	
	
}
