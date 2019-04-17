/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Interfaz para los métodos get de RESERVA.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * @author Julián Mendoza
 *
 */
public interface VOReserva 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * 
	 * @return El id de la reserva
	 */
	public long getId();
	
	public Timestamp getFechaEntrada();
	
	public Timestamp getFechaSalida();
	
	public int getNumeroPersonas();
	
	public long getPlanPago();
	
	public String getTipoDocumento();
	
	public String getDocumento();
	
	public String getTipo();
	
	public long getIdHabitacion();
	
	public long getIdConvencion();

}
