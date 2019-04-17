package main.java.hotelAndes.negocio;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

import oracle.sql.TIMESTAMP;

public class ConsumosUsuarios
{
	private int costo;
	private String descripcion;
	private TIMESTAMP fecha;
	private int id;
	
	public ConsumosUsuarios(BigDecimal costo, String descripcion, TIMESTAMP fecha, BigDecimal id) {
		this.costo = costo.intValue();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.id = id.intValue();
	}
	
	public int getCosto() {
		return costo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public TIMESTAMP getFecha() {
		return fecha;
	}
	
	public int getId() {
		return id;
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
