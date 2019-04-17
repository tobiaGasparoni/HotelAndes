/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.ProductoToServicio;

/**
 * @author Julián Mendoza
 *
 */
public class SQLJoin_Producto_To_Servicio {
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaHotelAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaHotelAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLJoin_Producto_To_Servicio(PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ProductoToServicio a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idProducto - El identificador del bebedor
	 * @param idServicio - El identificador de la bebida
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarProductoToServicio(PersistenceManager pm, long idServicio,long idProducto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaProductoToServicio () + "(servicio_id, producto_id) values (?, ?)");
        q.setParameters(idServicio,idProducto);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN ProductoToServicio de la base de datos de Parranderos, por sus identificador
	 * @param pm - El manejador de persistencia
	 * @param idServicio - El identificador del bebedor
	 * @param idProducto - El identificador de la bebida
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarProductoToServicio (PersistenceManager pm, long idServicio, long idProducto)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProductoToServicio () + " WHERE servicio_i	d = ? AND producto_id= ?");
        q.setParameters(idServicio, idProducto);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los ProductoToServicio de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ProductoToServicio
	 */
	public List<ProductoToServicio> darProductoToServicio (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProductoToServicio ());
		q.setResultClass(ProductoToServicio.class);
		List<ProductoToServicio> resp = (List<ProductoToServicio>) q.execute();
		return resp;
	}
}
