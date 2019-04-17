/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public class Producto implements VOProducto
{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del producto
	 */
	private long id;
	
	/**
	 * El nombre del producto
	 */
	private String nombre;
	
	/**
	 * El costo del producto
	 */
	private double costo;

	/**
	 * @param id
	 * @param nombre
	 * @param costo
	 */
	public Producto(long id, String nombre, double costo) {
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
