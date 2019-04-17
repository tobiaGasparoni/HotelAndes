/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Julián Mendoza
 *
 */
public class Reserva implements VOReserva {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la reserva
	 */
	private long id;
	
	/**
	 * La fecha en que entran los clientes
	 */
	private Timestamp fechaEntrada;
	
	/**
	 * La fecha en que salen los clientes del hotel
	 */
	private Timestamp fechaSalida;
	
	
	/**
	 * El numero de personas por las que se hace la reservación
	 */
	private int numeroPersonas;
	
    private List<Object[]> clientes;
    
    private Object[] cuenta;
    
	private long idHabitacion;
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	
	

	/**
	 * @param id
	 * @param fechaEntrada
	 * @param fechaSalida
	 * @param numeroPersonas
	 * @param clientes
	 * @param cuenta
	 * @param idHabitacion
	 */
	public Reserva(int id, Timestamp fechaEntrada, Timestamp fechaSalida, int numeroPersonas, List<Object[]> clientes,
			Object[] cuenta, int idHabitacion) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.numeroPersonas = numeroPersonas;
		this.clientes = clientes;
		this.cuenta = cuenta;
		this.idHabitacion = idHabitacion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Timestamp fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Timestamp getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public List<Object[]> getClientes() {
		return clientes;
	}

	public void setClientes(List<Object[]> clientes) {
		this.clientes = clientes;
	}

	public Object[] getCuenta() {
		return cuenta;
	}

	public void setCuenta(Object[] cuenta) {
		this.cuenta = cuenta;
	}

	public long getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	
	
}
