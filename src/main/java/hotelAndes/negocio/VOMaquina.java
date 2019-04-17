/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *Interfaz para los métodos get de MAQUINA.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz
 */
public interface VOMaquina 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * 
	 * @return El id de la máquina
	 */
	public long getId();
	
	/**
	 * 
	 * @return El tipo de maquina
	 */
	public String getTipoMaquina();
	
	public long getServicioHotelId();

}
