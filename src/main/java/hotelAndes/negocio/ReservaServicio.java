/**
 * 
 */
package main.java.hotelAndes.negocio;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Julián Mendoza
 *
 */
public class ReservaServicio implements VOReservaServicio {

	private long id;
	
	private double costo;
	
	private String descripcion;
	
	private Timestamp fecha;
	
	private String nombreEmpleado;
	
	private int numClientes;
	
	private String tipoServicio;
	
	private long idServicio;	
	
	private String tipoDocumento;
	
	private String documento;
	
	private String tipo;
	
	private Object[] hotelId;

	private Object[] convencion;

	public ReservaServicio(long id, double costo, String descripcion, Timestamp fecha, String nombreEmpleado,
			int numClientes, String tipoServicio, long idServicio, String tipoDocumento, String documento, String tipo,
			Object[] hotelId, Object[] convencion) {
		super();
		this.id = id;
		this.costo = costo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.nombreEmpleado = nombreEmpleado;
		this.numClientes = numClientes;
		this.tipoServicio = tipoServicio;
		this.idServicio = idServicio;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.tipo = tipo;
		this.hotelId = hotelId;
		this.convencion = convencion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public int getNumClientes() {
		return numClientes;
	}

	public void setNumClientes(int numClientes) {
		this.numClientes = numClientes;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Object[] getHotelId() {
		return hotelId;
	}

	public void setHotelId(Object[] hotelId) {
		this.hotelId = hotelId;
	}

	public Object[] getConvencion() {
		return convencion;
	}

	public void setConvencion(Object[] convencion) {
		this.convencion = convencion;
	}

	
}
