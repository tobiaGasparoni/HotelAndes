/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author jd.mendozar
 *
 */
public class Cuenta implements VOCuenta {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificado ÚNICO de la cuenta
	 */
	private long id;
	
	/**
	 * Si la cuenta está paga
	 */
	private boolean pagada;
	
	/**
	 * El costo total de la cuenta
	 */
	private double costo;
	
	private Object[] reserva;
	
	private Object[] hotel;

	public Cuenta(long id, boolean pagada, double costo, Object[] reserva, Object[] hotel) {
		super();
		this.id = id;
		this.pagada = pagada;
		this.costo = costo;
		this.reserva = reserva;
		this.hotel = hotel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Object[] getReserva() {
		return reserva;
	}

	public void setReserva(Object[] reserva) {
		this.reserva = reserva;
	}

	public Object[] getHotel() {
		return hotel;
	}

	public void setHotel(Object[] hotel) {
		this.hotel = hotel;
	}
	

}
