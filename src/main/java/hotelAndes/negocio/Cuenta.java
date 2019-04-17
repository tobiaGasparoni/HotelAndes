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
	
	private long idReserva;
	
	private long idHotel;

	/**
	 * @param id
	 * @param pagada
	 * @param costo
	 * @param idReserva
	 * @param idHotel
	 */
	public Cuenta(long id, boolean pagada, double costo, long idReserva, long idHotel) {
		this.id = id;
		this.pagada = pagada;
		this.costo = costo;
		this.idReserva = idReserva;
		this.idHotel = idHotel;
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

	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
    
}
