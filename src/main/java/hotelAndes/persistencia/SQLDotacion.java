/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Dotacion;

/**
 * @author Julián Mendoza
 *
 */
public class SQLDotacion {
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
	public SQLDotacion(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Dotacion
	 */
	public long adicionarDotacion (PersistenceManager pm, long idDotacion, String nombre, double costo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaDotacion() + "(id, nombre, costo) values (?, ?, ?)");
        q.setParameters(idDotacion, nombre, costo);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarDotacionPorId (PersistenceManager pm, long idDotacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaDotacion() + " WHERE id = ?");
        q.setParameters(idDotacion);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto Dotacion que tiene el identificador dado
	 */
	public Dotacion darDotacionPorId (PersistenceManager pm, long idDotacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaDotacion() + " WHERE id = ?");
		q.setResultClass(Dotacion.class);
		q.setParameters(idDotacion);
		return (Dotacion) q.executeUnique();
	}
	
	public List<Dotacion> darDotacions (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaDotacion());
		q.setResultClass(Dotacion.class);
		return (List<Dotacion>) q.executeList();
	}
	
}
