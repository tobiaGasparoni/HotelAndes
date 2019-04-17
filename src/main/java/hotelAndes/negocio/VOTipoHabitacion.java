/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.util.List;

/**
 * @author Julián Mendoza
 *Interfaz para los métodos get de CONSUMO.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz
 */
public interface VOTipoHabitacion 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * 
	 * @return El id del tipo de habitación
	 */
	public long getId();
	
	/**
	 * 
	 * @return El nombre del tipo de habitación
	 */
	public String getNombre();
	
	/**
	 * 
	 * @return La descripcion del tipo de habitacion.
	 */
	public String getDescripcion();
	
	/**
	 * 
	 * @return Las habitaciones de este tipo de habitación
	 */
	public List<Long> getHabitaciones();
}
