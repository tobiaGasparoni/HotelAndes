/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Julián Mendoza
 *
 */
public class Convencion implements VOConvencion {

	private long id;
	
	private String nombre;
	
	private Timestamp fechaInicio;
	
	private Timestamp fechaFin;
	
	private List<Object[]> reservas;
	
	private List<Object[]> reservasServicios;


	/**
	 * @param id
	 * @param nombre
	 * @param fechaInicio
	 * @param fechaFin
	 * @param reservas
	 * @param reservasServicios
	 */
	public Convencion(long id, String nombre, Timestamp fechaInicio, Timestamp fechaFin, List<Object[]> reservas,
			List<Object[]> reservasServicios) {
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.reservas = reservas;
		this.reservasServicios = reservasServicios;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Timestamp getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Object[]> getReservas() {
		return reservas;
	}

	public void setReservas(List<Object[]> reservas) {
		this.reservas = reservas;
	}

	public List<Object[]> getReservasServicios() {
		return reservasServicios;
	}

	public void setReservasServicios(List<Object[]> reservasServicios) {
		this.reservasServicios = reservasServicios;
	}
	
	
}
