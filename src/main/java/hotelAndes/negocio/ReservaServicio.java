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
	
	private long hotelId;

	private long convencion;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (convencion ^ (convencion >>> 32));
		long temp;
		temp = Double.doubleToLongBits(costo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (hotelId ^ (hotelId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (idServicio ^ (idServicio >>> 32));
		result = prime * result + ((nombreEmpleado == null) ? 0 : nombreEmpleado.hashCode());
		result = prime * result + numClientes;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
		result = prime * result + ((tipoServicio == null) ? 0 : tipoServicio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaServicio other = (ReservaServicio) obj;
		if (convencion != other.convencion)
			return false;
		if (Double.doubleToLongBits(costo) != Double.doubleToLongBits(other.costo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (hotelId != other.hotelId)
			return false;
		if (id != other.id)
			return false;
		if (idServicio != other.idServicio)
			return false;
		if (nombreEmpleado == null) {
			if (other.nombreEmpleado != null)
				return false;
		} else if (!nombreEmpleado.equals(other.nombreEmpleado))
			return false;
		if (numClientes != other.numClientes)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (tipoDocumento == null) {
			if (other.tipoDocumento != null)
				return false;
		} else if (!tipoDocumento.equals(other.tipoDocumento))
			return false;
		if (tipoServicio == null) {
			if (other.tipoServicio != null)
				return false;
		} else if (!tipoServicio.equals(other.tipoServicio))
			return false;
		return true;
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

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public long getConvencion() {
		return convencion;
	}

	public void setConvencion(long convencion) {
		this.convencion = convencion;
	}


	
}
