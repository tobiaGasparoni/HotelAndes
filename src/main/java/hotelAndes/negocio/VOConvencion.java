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
	
	/**
	 * [Reserva, fechaentrada, fechaSalida]
	 * @return reservas asociadas a la convencion
	 */
	public List<Object[]> getReservas();
	
	/**
	 * [ReservaServicio, descripcion, tipoServicio]
	 * @return reserva del servicio del hotel para la convencion
	 */
	public List<Object[]> getReservasServicios();
}
