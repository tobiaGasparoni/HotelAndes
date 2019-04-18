package main.java.hotelAndes.negocio;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class BuenosClientes
{
	private String nombre;

	private String tipDoc;
	
	private String doc;
	
	private int diasEstadiaTotales;
	
	private int gastosTotales;

	public BuenosClientes(String nombre, String tipDoc, String doc, BigDecimal diasEstadiaTotales, BigDecimal gastosTotales) {
		this.nombre = nombre;
		this.tipDoc = tipDoc;
		this.doc = doc;
		this.diasEstadiaTotales = diasEstadiaTotales.intValue();
		this.gastosTotales = gastosTotales.intValue();
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getTipDoc() {
		return tipDoc;
	}

	public String getDoc() {
		return doc;
	}

	public int getDiasEstadiaTotales() {
		return diasEstadiaTotales;
	}

	public int getGastosTotales() {
		return gastosTotales;
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
