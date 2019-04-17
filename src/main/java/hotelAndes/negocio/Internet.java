/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public class Internet implements VOInternet {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del internet
	 */
	private long id;
	
	/**
	 * El costo del servicio de internet
	 */
	private double costo;
	

	/**
	 * La capacidad de uso del internet
	 */
	private double capacidad;


	/**
	 * @param id
	 * @param costo
	 * @param capacidad
	 */
	public Internet(long id, double costo, double capacidad) {
		this.id = id;
		this.costo = costo;
		this.capacidad = capacidad;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public double getCosto() {
		return costo;
	}


	public void setCosto(double costo) {
		this.costo = costo;
	}


	public double getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	
}
