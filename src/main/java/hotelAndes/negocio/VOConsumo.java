/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.sql.Timestamp;

/**
 * @author Julián Mendoza
 *Interfaz para los métodos get de CONSUMO.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz
 */
public interface VOConsumo 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * 
	 * @return El id del consumo
	 */
	public long getId();

	
	/**
	 * 
	 * @return El costo del consumo
	 */
	public double getCosto();
	
	/**
	 * 
	 * @return La fecha en que se produjo el consumo.
	 */
	public Timestamp getFecha();
	
	/**
	 * 
	 * @return Una descripcion del consumo.
	 */
	public String getDescripcion();
	
	public long getIdServicioComodidad();
	
	public long getIdServicioHotel();
	
	public long getIdServicioProductos();
	
	public long getIdServicioSalon();
	
	public long getIdHabitacion();
}
