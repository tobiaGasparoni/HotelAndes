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
	private List<Object[]> habitaciones;

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param habitaciones
	 */
	public TipoHabitacion(long id, String nombre, String descripcion, List<Object[]> habitaciones) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.habitaciones = habitaciones;
	}
	
	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 */
	public TipoHabitacion(long id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public List<Object[]> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Object[]> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	
}
