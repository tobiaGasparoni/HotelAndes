/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Producto;

/**
 * @author Julián Mendoza
 *
 */
public class SQLProducto {
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
	public SQLProducto(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Producto
	 */
	public long adicionarProducto (PersistenceManager pm, long idProducto, String nombre, double costo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaProducto() + "(id, nombre, costo) values (?, ?, ?)");
        q.setParameters(idProducto, nombre, costo);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarProductoPorId (PersistenceManager pm, long idProducto)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProducto() + " WHERE id = ?");
        q.setParameters(idProducto);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto Producto que tiene el identificador dado
	 */
	public Producto darProductoPorId (PersistenceManager pm, long idProducto) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProducto() + " WHERE id = ?");
		q.setResultClass(Producto.class);
		q.setParameters(idProducto);
		return (Producto) q.executeUnique();
	}
	
	public List<Producto> darProductos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProducto());
		q.setResultClass(Producto.class);
		return (List<Producto>) q.executeList();
	}
	
}
