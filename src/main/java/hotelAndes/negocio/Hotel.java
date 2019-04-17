/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.util.List;

/**
 * @author Julián Mendoza
 *
 */
public class Hotel implements VOHotel {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la dotacion
	 */
	private long id;
	
	/**
	 * El nombre del hotel
	 */
	private String nombre;
	
	/**
	 * El pais del hotel
	 */
	private String pais;
	
	/**
	 * La ciudad en que se encuentra el hotel
	 */
	private String ciudad;
	
	/**
	 * La direccion del hotel
	 */
	private String direccion;
	
	
	/**
	 *  [internet, long], internet y el id del servicio de internet
	 */
	private Object[] internet;
	
	
	private List<Object[]> serviciosHotel;
	
	private List<Object[]> serviciosComodidad;
	
	private List<Object[]> serviciosSalon;
	
	private List<Object[]> serviciosProductos;
	
	private List<Object[]> planes;

	/**
	 * @param id
	 * @param nombre
	 * @param pais
	 * @param ciudad
	 * @param direccion
	 * @param internet
	 * @param serviciosHotel
	 * @param serviciosComodidad
	 * @param serviciosSalon
	 * @param serviciosProductos
	 * @param planes
	 */
	public Hotel(long id, String nombre, String pais, String ciudad, String direccion, Object[] internet,
			List<Object[]> serviciosHotel, List<Object[]> serviciosComodidad, List<Object[]> serviciosSalon,
			List<Object[]> serviciosProductos, List<Object[]> planes) {
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.internet = internet;
		this.serviciosHotel = serviciosHotel;
		this.serviciosComodidad = serviciosComodidad;
		this.serviciosSalon = serviciosSalon;
		this.serviciosProductos = serviciosProductos;
		this.planes = planes;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Object[] getInternet() {
		return internet;
	}

	public void setInternet(Object[] internet) {
		this.internet = internet;
	}

	public List<Object[]> getServiciosHotel() {
		return serviciosHotel;
	}

	public void setServiciosHotel(List<Object[]> serviciosHotel) {
		this.serviciosHotel = serviciosHotel;
	}

	public List<Object[]> getServiciosComodidad() {
		return serviciosComodidad;
	}

	public void setServiciosComodidad(List<Object[]> serviciosComodidad) {
		this.serviciosComodidad = serviciosComodidad;
	}

	public List<Object[]> getServiciosSalon() {
		return serviciosSalon;
	}

	public void setServiciosSalon(List<Object[]> serviciosSalon) {
		this.serviciosSalon = serviciosSalon;
	}

	public List<Object[]> getServiciosProductos() {
		return serviciosProductos;
	}

	public void setServiciosProductos(List<Object[]> serviciosProductos) {
		this.serviciosProductos = serviciosProductos;
	}

	public List<Object[]> getPlanes() {
		return planes;
	}

	public void setPlanes(List<Object[]> planes) {
		this.planes = planes;
	}



}
