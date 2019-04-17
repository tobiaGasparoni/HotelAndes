/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Internet;

/**
 * @author Julián Mendoza
 *
 */
public class SQLInternet {
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
	public SQLInternet(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Internet
	 */
	public long adicionarInternet (PersistenceManager pm, long idInternet, double capacidad, double costo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaInternet() + "(id, capacidad, costo) values (?, ?, ?)");
        q.setParameters(idInternet, capacidad, costo);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarInternetPorId (PersistenceManager pm, long idInternet)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaInternet() + " WHERE id = ?");
        q.setParameters(idInternet);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto Internet que tiene el identificador dado
	 */
	public Internet darInternetPorId (PersistenceManager pm, long idInternet) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInternet() + " WHERE id = ?");
		q.setResultClass(Internet.class);
		q.setParameters(idInternet);
		return (Internet) q.executeUnique();
	}
	
	public List<Internet> darInternets (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInternet());
		q.setResultClass(Internet.class);
		return (List<Internet>) q.executeList();
	}
	
}
