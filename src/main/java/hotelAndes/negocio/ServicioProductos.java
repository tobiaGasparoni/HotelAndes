/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public class ServicioProductos implements VOServicioProductos {

	private long id;
	
	private String nombre;
	
	private String tipo;
	
	private int capacidad;
	
	private int ocupacionActual;
	
	private String estilo;
	
	private boolean enMantenimiento;

	/**
	 * @param id
	 * @param nombre
	 * @param tipo
	 * @param capacidad
	 * @param ocupacionActual
	 * @param estilo
	 * @param enMantenimiento
	 */
	public ServicioProductos(long id, String nombre, String tipo, int capacidad, int ocupacionActual, String estilo,
			boolean enMantenimiento) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.ocupacionActual = ocupacionActual;
		this.estilo = estilo;
		this.enMantenimiento = enMantenimiento;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getOcupacionActual() {
		return ocupacionActual;
	}

	public void setOcupacionActual(int ocupacionActual) {
		this.ocupacionActual = ocupacionActual;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public boolean isEnMantenimiento() {
		return enMantenimiento;
	}

	public void setEnMantenimiento(boolean enMantenimiento) {
		this.enMantenimiento = enMantenimiento;
	}
	
	
}
