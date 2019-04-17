/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * Interfaz para los métodos get de CUENTA.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * @author Julián Mendoza
 *
 */
public interface VOCuenta 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * 
	 * @return El id de la cuenta.
	 */
	public long getId();
	
	/**
	 * 
	 * @return Si la cuenta está pagada
	 */
	public boolean isPagada();
	
	/**
	 * 
	 * @return El costo de la cuenta para la habitacion
	 */
	public double getCosto();
	
	public long getIdReserva();
	
	public long getIdHotel();
}
