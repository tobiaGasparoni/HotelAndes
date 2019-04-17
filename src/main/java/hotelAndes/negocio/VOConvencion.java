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
public interface VOConvencion {

	public long getId();
	
	public String getNombre();
	
	public Timestamp getFechaInicio();
	
	public Timestamp getFechaFin();
	
}
