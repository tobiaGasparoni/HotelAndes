/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public interface VOServicioComodidad {

	public long getId();
	
	public String getNombre();
	
	public String getDescripcion();
	
	public int getDuracion();
	
	public String getHorario();
	
	public double getCosto();
	
	public boolean isEnMantenimiento();
	
	
}
