/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *Interfaz para los métodos get de CONSUMO.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz
 */
public interface VOInternet 
{

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * 
	 * @return El id del servicio de internet.
	 */
	public long getId();
	
	/**
	 * 
	 * @return La capacidad de internet disponible por cliente.
	 */
	public double getCapacidad();
	
	/**
	 * 
	 * @return El costo del servicio de internet.
	 */
	public double getCosto();
	
}
