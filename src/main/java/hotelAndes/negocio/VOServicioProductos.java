/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public interface VOServicioProductos {

	public long getId();
	
	public String getNombre();
	
	public String getTipo();
	
	public int getCapacidad();
	
	public int getOcupacionActual();
	
	public String getEstilo();
	
	public boolean isEnMantenimiento();
	
	
}
