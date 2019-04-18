package main.java.hotelAndes.negocio;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import java.sql.Timestamp;

public class AnalisisFechasDemanda
{
	private int numConsumos;
	
	private Timestamp fechaConsumo;
	
	public AnalisisFechasDemanda(BigDecimal numConsumos, Timestamp fechaConsumo) {
		this.numConsumos = numConsumos.intValue();
		this.fechaConsumo = fechaConsumo;
	}
	
	public int getNumConsumos() {
		return numConsumos;
	}

	public Timestamp getFechaConsumo() {
		return fechaConsumo;
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
