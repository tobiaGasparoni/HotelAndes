/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author jdmen
 *
 */
public class HabitacionToDotacion implements VOHabitacionToDotacion {

	private long idHabitacion;
	
	private long idDotacion;
	
	public HabitacionToDotacion()
	{
		this.idHabitacion= 0;
		this.idDotacion= 0;
	}

	public HabitacionToDotacion(long idHabitacion, long idDotacion) {
		super();
		this.idHabitacion = idHabitacion;
		this.idDotacion = idDotacion;
	}

	public long getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public long getIdDotacion() {
		return idDotacion;
	}

	public void setIdDotacion(long idDotacion) {
		this.idDotacion = idDotacion;
	}
	
	
}
