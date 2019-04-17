/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public class Maquina implements VOMaquina {

	private long id;
	
	private String tipoMaquina;
	
	private long servicioHotelId;

	public Maquina(long id, String tipoMaquina, long servicioHotelId) {
		super();
		this.id = id;
		this.tipoMaquina = tipoMaquina;
		this.servicioHotelId = servicioHotelId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoMaquina() {
		return tipoMaquina;
	}

	public void setTipoMaquina(String tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}

	public long getServicioHotelId() {
		return servicioHotelId;
	}

	public void setServicioHotelId(long servicioHotelId) {
		this.servicioHotelId = servicioHotelId;
	}

	
}
