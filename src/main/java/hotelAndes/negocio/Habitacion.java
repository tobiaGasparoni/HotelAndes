/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public class Habitacion implements VOHabitacion {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la habitacion
	 */
	private long id;

	/**
	 * La capacidad máxima de la habitación
	 */
	private int capacidad;

	/**
	 * El consumo total de los clientes en la habitación
	 */
	private double consumo;

	/**
	 * La disponibilidad de la habitación 0
	 */
	private boolean disponible;

	/**
	 * Si el cliente ya está registrado en la recepción
	 */
	private boolean llegadaCliente;

	/**
	 * El tipo de la habitacion
	 */
	private long tipo;

	private long idHotel;
	/**
	 * Si está en habitación. 
	 */
	private boolean enMantenimiento;
	/**
	 * @param id
	 * @param capacidad
	 * @param consumo
	 * @param disponible
	 * @param llegadaCliente
	 * @param tipo
	 * @param idHotel
	 * @param enMantenimiento
	 */
	public Habitacion(long id, int capacidad, double consumo, boolean disponible, boolean llegadaCliente, long tipo,
			long idHotel, boolean enMantenimiento) {
		this.id = id;
		this.capacidad = capacidad;
		this.consumo = consumo;
		this.disponible = disponible;
		this.llegadaCliente = llegadaCliente;
		this.tipo = tipo;
		this.idHotel = idHotel;
		this.enMantenimiento = enMantenimiento;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public double getConsumo() {
		return consumo;
	}
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public boolean isLlegadaCliente() {
		return llegadaCliente;
	}
	public void setLlegadaCliente(boolean llegadaCliente) {
		this.llegadaCliente = llegadaCliente;
	}
	public long getTipo() {
		return tipo;
	}
	public void setTipo(long tipo) {
		this.tipo = tipo;
	}
	public long getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	public boolean isEnMantenimiento() {
		return enMantenimiento;
	}
	public void setEnMantenimiento(boolean enMantenimiento) {
		this.enMantenimiento = enMantenimiento;
	}
	

	
}
