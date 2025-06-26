package BLL;

public class Persona {
	
	protected String nombre;
	protected String apellido;
	
	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Persona() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nobmre) {
		this.nombre = nobmre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Persona [nobmre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
	
	
	
}
