/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Julián Mendoza
 *
 */
public interface VOReservaServicio {

	public long getId();
	
	public double getCosto();
	
	public String getDescripcion();
	
	public Timestamp getFecha();
	
	public String getNombreEmpleado();
	
	public int getNumClientes();
	
	public String getTipoServicio();
	
	public long getIdServicio();
	
	public String getTipoDocumento();
	
	public String getDocumento();
	
	public String getTipo();
	
	public long getIdHotel();
	
	/**
	 * [Convencion, nombre]
	 * @return la convencion a la que puede pertenecer
	 */
	public long getIdConvencion();
}
