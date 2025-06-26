package BLL;

public class DT extends Persona{
	
	private String dOfBirth;
	private String nacionalidad;
	private String ciudad;
	private Equipo equipo;
	private int temporadasEnLiga;
	
	
	public DT(String nobmre, String apellido, String dOfBirth, String nacionalidad, String ciudad, Equipo equipo,
			int temporadasEnLiga) {
		super(nobmre, apellido);
		this.dOfBirth = dOfBirth;
		this.nacionalidad = nacionalidad;
		this.ciudad = ciudad;
		this.equipo = equipo;
		this.temporadasEnLiga = temporadasEnLiga;
	}


	public String getdOfBirth() {
		return dOfBirth;
	}


	public void setdOfBirth(String dOfBirth) {
		this.dOfBirth = dOfBirth;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	public int getTemporadasEnLiga() {
		return temporadasEnLiga;
	}


	public void setTemporadasEnLiga(int temporadasEnLiga) {
		this.temporadasEnLiga = temporadasEnLiga;
	}


	@Override
	public String toString() {
		return "DT [dOfBirth=" + dOfBirth + ", nacionalidad=" + nacionalidad + ", ciudad=" + ciudad + ", equipo="
				+ equipo + ", temporadasEnLiga=" + temporadasEnLiga + "]";
	}
	
	
	
	
	
}
