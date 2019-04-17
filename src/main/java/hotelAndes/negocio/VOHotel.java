/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.util.List;

/**
 * @author Julián Mendoza
 *Interfaz para los métodos get de CONSUMO.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz
 */
public interface VOHotel 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * 
	 * @return El id del hotel.
	 */
	public long getId();
	
	/**
	 * 
	 * @return El nombre del hotel
	 */
	public String getNombre();
	
	/**
	 * 
	 * @return El pais en el que está el hotel.
	 */
	public String getPais();
	
	/**
	 * 
	 * @return La ciudad en la que está el hotel.
	 */
	public String getCiudad();
	
	/**
	 * 
	 * @return La dirección del hotel.
	 */
	public String getDireccion();
	
	/**
	 * 
	 * @return El servicio de internet que provee el hotel.
	 * [internet, long], internet y el id del servicio de internet
	 */
	public Object[] getInternet();
	
	/**
	 * @return el servicioHotel.
	 * [ServicioHotel, nombre, descripcion] El servicioHotel, el nombre del servicio y la descripción.
	 */
	public List<Object[]> getServiciosHotel();
	
	/**
	 * 
	 * @return el servicioComodidad
	 * [ServicioComodidad, nombre, descripcion] El servicioComodidad, el nombre del servicio y la descripción.
	 */
	public List<Object[]> getServiciosComodidad();
	
	/**
	 * [ServicioSalon,descripcion] El servicioSalon y la descripcion del salon.
	 * @return el servicioSalon.
	 */
	public List<Object[]> getServiciosSalon();
	
	/**
	 * [ServicioProductos, nombre, descripcion] El servicioProductos, nombre del servicio y la descripcion.
	 * @return el servicio productos
	 */
	public List<Object[]> getServiciosProductos();
	
	/**
	 * [plan, nombre, descripcion] El plan, el nombre y la descripcion.
	 * @return el plan
	 */
	public List<Object[]> getPlanes();
	
}
