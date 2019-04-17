/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public class ServicioComodidad implements VOServicioComodidad {

	private long id;
	
	private String nombre;
	
	private String descripcion;
	
	private int duracion;
	
	private String horario;
	
	private double costo;
	
	private boolean enMantenimiento;

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param duracion
	 * @param horario
	 * @param costo
	 * @param enMantenimiento
	 */
	public ServicioComodidad(long id, String nombre, String descripcion, int duracion, String horario, double costo,
			boolean enMantenimiento) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.horario = horario;
		this.costo = costo;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
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
