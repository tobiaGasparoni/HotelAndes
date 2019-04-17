/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public class Dotacion implements VODotacion
{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la dotacion
	 */
	private long id;
	
	/**
	 * El nombre de la dotacion
	 */
	private String nombre;
	
	/**
	 * El costo de la dotacion
	 */
	private double costo;

	/**
	 * @param id
	 * @param nombre
	 * @param costo
	 */
	public Dotacion(long id, String nombre, double costo) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	 

}
