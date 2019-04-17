package main.java.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Convencion;

/**
 * @author Julián Mendoza
 *
 */
public class SQLConvencion {

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
	public SQLConvencion(PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Convencion
	 */
	public long adicionarConvencion (PersistenceManager pm, long idConvencion, String nombre, Timestamp fechaInicio, Timestamp fechaFinal) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConvencion() + "(id, nombre, fecha_inicio, fecha_final) values (?, ?, ?, ?)");
        q.setParameters(idConvencion, nombre, fechaInicio, fechaFinal);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarConvencionPorId (PersistenceManager pm, long idConvencion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion() + " WHERE id = ?");
        q.setParameters(idConvencion);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto Convencion que tiene el identificador dado
	 */
	public Convencion darConvencionPorId (PersistenceManager pm, long idConvencion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion() + " WHERE id = ?");
		q.setResultClass(Convencion.class);
		q.setParameters(idConvencion);
		return (Convencion) q.executeUnique();
	}
	
	public List<Convencion> darConvencions (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion());
		q.setResultClass(Convencion.class);
		return (List<Convencion>) q.executeList();
	}
	
	
}
