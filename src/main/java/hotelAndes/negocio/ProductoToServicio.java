/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author jdmen
 *
 */
public class ProductoToServicio implements VOProductoToServicio {

	private long idProducto;
	
	private long idServicio;
	
	public ProductoToServicio()
	{
		this.idProducto=0;
		this.idServicio=0;
	}

	public ProductoToServicio(long idProducto, long idServicio) {
		super();
		this.idProducto = idProducto;
		this.idServicio = idServicio;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	
	
}
