/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * Interfaz para los métodos get de HABITACION.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * @author Julián Mendoza
 *
 */
public interface VOHabitacion 
{

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * 
	 * @return El id de la habitación
	 */
	public long getId();
	
	/**
	 * 
	 * @return La capacidad de la habitación
	 */
	public int getCapacidad();
	
	/**
	 * 
	 * @return El consumo total de la habitación.
	 */
	public double getConsumo();
	
	/**
	 * 
	 * @return Si está disponible la habitación.
	 */
	public boolean isDisponible();
	
	/**
	 * 
	 * @return Si los clientes de la reserva llegaron al hotel y se registraron.
	 */
	public boolean isLlegadaCliente();
	
	/**
	 * 
	 * @return Si está en mantenimiento
	 */
	public boolean isEnMantenimiento();
	
	/**
	 * 
	 * @return El tipo de habitacion
	 */
	public long getIdTipoHabitacion();
}
