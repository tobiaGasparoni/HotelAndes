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
	
	/**
	 * [Cliente, documento, tipoDocumento] cliente, documento del cliente, tipo del cliente.
	 * @return los clientes de la reserva
	 */
	public List<Object[]> getClientes();
	
	/**
	 * [cuenta, costo] La cuenta y el costo de la cuenta
	 * @return la cuenta para la reserva
	 */
	public Object[] getCuenta();
	
	
	/**
	 * El id de la habitacion reservada
	 * @return idHabitacion
	 */
	public long getIdHabitacion();

}
