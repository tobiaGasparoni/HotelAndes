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
	private long internet;
	
	
	private List<Long> serviciosHotel;
	
	private List<Long> serviciosComodidad;
	
	private List<Long> serviciosSalon;
	
	private List<Long> serviciosProductos;
	
	private List<Long> planes;

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
	public Hotel(long id, String nombre, String pais, String ciudad, String direccion, long internet,
			List<Long> serviciosHotel, List<Long> serviciosComodidad, List<Long> serviciosSalon,
			List<Long> serviciosProductos, List<Long> planes) {
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

	public long getInternet() {
		return internet;
	}

	public void setInternet(long internet) {
		this.internet = internet;
	}

	public List<Long> getServiciosHotel() {
		return serviciosHotel;
	}

	public void setServiciosHotel(List<Long> serviciosHotel) {
		this.serviciosHotel = serviciosHotel;
	}

	public List<Long> getServiciosComodidad() {
		return serviciosComodidad;
	}

	public void setServiciosComodidad(List<Long> serviciosComodidad) {
		this.serviciosComodidad = serviciosComodidad;
	}

	public List<Long> getServiciosSalon() {
		return serviciosSalon;
	}

	public void setServiciosSalon(List<Long> serviciosSalon) {
		this.serviciosSalon = serviciosSalon;
	}

	public List<Long> getServiciosProductos() {
		return serviciosProductos;
	}

	public void setServiciosProductos(List<Long> serviciosProductos) {
		this.serviciosProductos = serviciosProductos;
	}

	public List<Long> getPlanes() {
		return planes;
	}

	public void setPlanes(List<Long> planes) {
		this.planes = planes;
	}




}
