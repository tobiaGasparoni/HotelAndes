/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;


/**
 * @author Julián Mendoza
 *
 */
public class TipoHabitacion implements VOTipoHabitacion 
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del tipo de habitación
	 */
	private long id;
	
	/**
	 * Nombre del tipo de habitacion
	 */
	private String nombre;
	/**
	 * La descripcion del tipo de habitacion
	 */
	private String descripcion;

	/**
	 * Las habitaciones de este tipo
	 */
	private List<Long> habitaciones;

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param habitaciones
	 */
	public TipoHabitacion(long id, String nombre, String descripcion, List<Long> habitaciones) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.habitaciones = habitaciones;
	}
	
	public TipoHabitacion(long id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.habitaciones = habitaciones;
	}
	
	public TipoHabitacion(BigDecimal id, String nombre, String descripcion) {
		this.id = id.intValue();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.habitaciones = habitaciones;
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

	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Long> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Long> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	@Override
	public String toString()
	{
		  StringBuilder result = new StringBuilder();
		  String newLine = System.getProperty("line.separator");

		  result.append( this.getClass().getName() );
		  result.append( " Object {" );
		  result.append(newLine);

		  //determine fields declared in this class only (no fields of superclass)
		  Field[] fields = this.getClass().getDeclaredFields();

		  //print field names paired with their values
		  for ( Field field : fields  ) {
		    result.append("  ");
		    try {
		      result.append( field.getName() );
		      result.append(": ");
		      //requires access to private field:
		      result.append( field.get(this) );
		    } catch ( IllegalAccessException ex ) {
		      System.out.println(ex);
		    }
		    result.append(newLine);
		  }
		  result.append("}");

		  return result.toString();
	}
}
