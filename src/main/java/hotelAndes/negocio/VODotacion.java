/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *Interfaz para los métodos get de CONSUMO.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz
 */
public interface VODotacion 
{

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * 
	 * @return El id de la dotación.
	 */
	public long getId();
	
	/**
	 * 
	 * @return El nombre de la dotación.
	 */
	public String getNombre();
	
	/**
	 * 
	 * @return El costo de la dotación.
	 */
	public double getCosto();
}
