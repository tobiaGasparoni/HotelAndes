/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public interface VOServicioSalon {

	public long getId();
	
	public String getDescripcion();
	
	public int getCapacidad();
	
	public double getCosto();
	
	public boolean isEnMantenimiento();
}
