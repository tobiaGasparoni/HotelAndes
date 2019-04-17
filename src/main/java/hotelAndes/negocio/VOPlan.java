/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *Interfaz para los métodos get de USUARIO.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOPlan 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * 
	 * @return El id del plan de consumo
	 */
	public long getId();
	
	/**
	 * 
	 * @return El nombre del plan de consumo
	 */
	public String getNombre();
	
	public String getDescripcion();
	
	public String getTipo();
	
	/**
	 * 
	 * @return El costo del plan de consumo
	 */
	public double getCosto();
	
	/**
	 * 
	 * @return Los días de estadía validos para el plan de consumo.
	 */
	public int getDiasEstadia();

	
	public double getDescuentoEstadia();
	
	public double getDescuentoProductos();
} 
