/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.util.List;

/**
 * @author Julián Mendoza
 *
 */
public class TipoHabitacion implements VOTipoHabitacion 
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del tipo de habitación
	 */
	private long id;
	
	/**
	 * Nombre del tipo de habitacion
	 */
	private String nombre;
	/**
	 * La descripcion del tipo de habitacion
	 */
	private String descripcion;

	/**
	 * Las habitaciones de este tipo
	 */
	private List<Long> habitaciones;

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param habitaciones
	 */
	public TipoHabitacion(long id, String nombre, String descripcion, List<Long> habitaciones) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.habitaciones = habitaciones;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Long> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Long> habitaciones) {
		this.habitaciones = habitaciones;
	}

	
}
