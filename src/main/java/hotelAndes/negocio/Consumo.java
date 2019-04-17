/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author jd.mendozar
 *
 */
public class Consumo implements VOConsumo 
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del consumo
	 */
    private long id;
    
    
    /**
	 * La fecha en que se realizó el consumo
	 */
	private Timestamp fecha;


	/**
     * El costo del consumo
     */
    private double costo;
    
    /**
     * La descripcion del consumo
     */
    private String descripcion;

    private long idServicioComodidad;
    
    private long idServicioHotel;
    
    private long idServicioProductos;
    
    private long idServicioSalon;
    
    private long idHabitacion;

	public Consumo(long id, Timestamp fecha, double costo, String descripcion, long idServicioComodidad,
			long idServicioHotel, long idServicioProductos, long idServicioSalon, long idHabitacion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.costo = costo;
		this.descripcion = descripcion;
		this.idServicioComodidad = idServicioComodidad;
		this.idServicioHotel = idServicioHotel;
		this.idServicioProductos = idServicioProductos;
		this.idServicioSalon = idServicioSalon;
		this.idHabitacion = idHabitacion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getIdServicioComodidad() {
		return idServicioComodidad;
	}

	public void setIdServicioComodidad(long idServicioComodidad) {
		this.idServicioComodidad = idServicioComodidad;
	}

	public long getIdServicioHotel() {
		return idServicioHotel;
	}

	public void setIdServicioHotel(long idServicioHotel) {
		this.idServicioHotel = idServicioHotel;
	}

	public long getIdServicioProductos() {
		return idServicioProductos;
	}

	public void setIdServicioProductos(long idServicioProductos) {
		this.idServicioProductos = idServicioProductos;
	}

	public long getIdServicioSalon() {
		return idServicioSalon;
	}

	public void setIdServicioSalon(long idServicioSalon) {
		this.idServicioSalon = idServicioSalon;
	}

	public long getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
}
