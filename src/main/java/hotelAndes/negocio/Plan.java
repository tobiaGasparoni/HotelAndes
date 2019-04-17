/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public class Plan implements VOPlan {

	private long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String tipo;

	private double costo;
	
	private int diasEstadia;
	
    private double descuentoEstadia;
    
    private double descuentoProductos;

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param tipo
	 * @param costo
	 * @param diasEstadia
	 * @param descuentoEstadia
	 * @param descuentoProductos
	 */
	public Plan(long id, String nombre, String descripcion, String tipo, double costo, int diasEstadia,
			double descuentoEstadia, double descuentoProductos) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.costo = costo;
		this.diasEstadia = diasEstadia;
		this.descuentoEstadia = descuentoEstadia;
		this.descuentoProductos = descuentoProductos;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getDiasEstadia() {
		return diasEstadia;
	}

	public void setDiasEstadia(int diasEstadia) {
		this.diasEstadia = diasEstadia;
	}

	public double getDescuentoEstadia() {
		return descuentoEstadia;
	}

	public void setDescuentoEstadia(double descuentoEstadia) {
		this.descuentoEstadia = descuentoEstadia;
	}

	public double getDescuentoProductos() {
		return descuentoProductos;
	}

	public void setDescuentoProductos(double descuentoProductos) {
		this.descuentoProductos = descuentoProductos;
	}

	
}
