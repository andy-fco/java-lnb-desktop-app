package BLL;

import java.util.ArrayList;

public class Equipo {
	
	private String nombre;
	private String ciudad;
	private String estadio;
	private String fechaDeFundacion;
	private int temporadasEnLiga;
	private int campeonatos;
	private ArrayList<Jugador> jugadores;
	private DT dt;
	
	public Equipo(String nombre, String ciudad, String estadio, String fechaDeFundacion, int temporadasEnLiga,
			int campeonatos, ArrayList<Jugador> jugadores, DT dt) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.estadio = estadio;
		this.fechaDeFundacion = fechaDeFundacion;
		this.temporadasEnLiga = temporadasEnLiga;
		this.campeonatos = campeonatos;
		this.jugadores = jugadores;
		this.dt = dt;
	}
	
	public Equipo(String nombre, String ciudad, String estadio, String fechaDeFundacion, int temporadasEnLiga,
			int campeonatos) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.estadio = estadio;
		this.fechaDeFundacion = fechaDeFundacion;
		this.temporadasEnLiga = temporadasEnLiga;
		this.campeonatos = campeonatos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public String getFechaDeFundacion() {
		return fechaDeFundacion;
	}

	public void setFechaDeFundacion(String fechaDeFundacion) {
		this.fechaDeFundacion = fechaDeFundacion;
	}

	public int getTemporadasEnLiga() {
		return temporadasEnLiga;
	}

	public void setTemporadasEnLiga(int temporadasEnLiga) {
		this.temporadasEnLiga = temporadasEnLiga;
	}

	public int getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(int campeonatos) {
		this.campeonatos = campeonatos;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public DT getDt() {
		return dt;
	}

	public void setDt(DT dt) {
		this.dt = dt;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", ciudad=" + ciudad + ", estadio=" + estadio + ", fechaDeFundacion="
				+ fechaDeFundacion + ", temporadasEnLiga=" + temporadasEnLiga + ", campeonatos=" + campeonatos
				+ ", jugadores=" + jugadores + ", dt=" + dt + "]";
	}
	
	
	
	
}
