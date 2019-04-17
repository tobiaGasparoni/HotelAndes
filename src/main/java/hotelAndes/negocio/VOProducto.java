/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *Interfaz para los métodos get de PRODUCTO	.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz
 */
public interface VOProducto 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * 		
	 * @return El id del producto
	 */
	public long getId();
	
	/**
	 * 
	 * @return El costo del producto
	 */
	public double getCosto();
	
	/**
	 * 
	 * @return El nombre del producto
	 */
	public String getNombre();
}
