/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public class ServicioSalon implements VOServicioSalon {

	private long id;
	
	private String descripcion;
	
	private int capacidad;
	
	private double costo;
	
	private boolean enMantenimiento;

	/**
	 * @param id
	 * @param descripcion
	 * @param capacidad
	 * @param costo
	 * @param enMantenimiento
	 */
	public ServicioSalon(long id, String descripcion, int capacidad, double costo, boolean enMantenimiento) {
		this.id = id;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.costo = costo;
		this.enMantenimiento = enMantenimiento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public boolean isEnMantenimiento() {
		return enMantenimiento;
	}

	public void setEnMantenimiento(boolean enMantenimiento) {
		this.enMantenimiento = enMantenimiento;
	}
	
	
}
