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
	
	private long planPago;
	
	private String tipoDocumento;
	
	private String documento;
	
	private String tipo;
	
	private long idHabitacion;
	
	private long idConvencion;

	/**
	 * @param id
	 * @param fechaEntrada
	 * @param fechaSalida
	 * @param numeroPersonas
	 * @param planPago
	 * @param tipoDocumento
	 * @param documento
	 * @param tipo
	 * @param idHabitacion
	 * @param idConvencion
	 */
	public Reserva(long id, Timestamp fechaEntrada, Timestamp fechaSalida, int numeroPersonas, long planPago,
			String tipoDocumento, String documento, String tipo, long idHabitacion, long idConvencion) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.numeroPersonas = numeroPersonas;
		this.planPago = planPago;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.tipo = tipo;
		this.idHabitacion = idHabitacion;
		this.idConvencion = idConvencion;
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

	public long getPlanPago() {
		return planPago;
	}

	public void setPlanPago(long planPago) {
		this.planPago = planPago;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public long getIdConvencion() {
		return idConvencion;
	}

	public void setIdConvencion(long idConvencion) {
		this.idConvencion = idConvencion;
	}
	
}
