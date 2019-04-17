/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public class ServicioHotel implements VOServicioHotel {

	
	private long id;
	
	private String nombre;
	
	private String descripcion;
	
	private int capacidad;
	
	private int ocupacionActual;
	
	private boolean enMantenimiento;
	
	private String horario;

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param capacidad
	 * @param ocupacionActual
	 * @param enMantenimiento
	 * @param horario
	 */
	public ServicioHotel(long id, String nombre, String descripcion, int capacidad, int ocupacionActual,
			boolean enMantenimiento, String horario) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.ocupacionActual = ocupacionActual;
		this.enMantenimiento = enMantenimiento;
		this.horario = horario;
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

	public boolean isEnMantenimiento() {
		return enMantenimiento;
	}

	public void setEnMantenimiento(boolean enMantenimiento) {
		this.enMantenimiento = enMantenimiento;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	

}
