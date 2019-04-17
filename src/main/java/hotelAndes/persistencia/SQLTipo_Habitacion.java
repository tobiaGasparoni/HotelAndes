/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.TipoHabitacion;

/**
 * @author Julián Mendoza
 *
 */
public class SQLTipo_Habitacion {
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
	public SQLTipo_Habitacion(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un TipoHabitacion
	 */
	public long adicionarTipoHabitacion (PersistenceManager pm, long idTipoHabitacion, String nombre, String descripcion) 
	{
		System.out.println("Entered here(SQL TIPO HABITACION)");
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaTipoHabitacion() + "(id, nombre, descripcion) values (?, ?, ?)");
        q.setParameters(idTipoHabitacion, nombre, descripcion);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarTipoHabitacionPorId (PersistenceManager pm, long idTipoHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipoHabitacion() + " WHERE id = ?");
        q.setParameters(idTipoHabitacion);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto TipoHabitacion que tiene el identificador dado
	 */
	public TipoHabitacion darTipoHabitacionPorId (PersistenceManager pm, long idTipoHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipoHabitacion() + " WHERE id = ?");
		q.setResultClass(TipoHabitacion.class);
		q.setParameters(idTipoHabitacion);
		return (TipoHabitacion) q.executeUnique();
	}
	
	public List<TipoHabitacion> darTiposHabitacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipoHabitacion());
		q.setResultClass(TipoHabitacion.class);
		return (List<TipoHabitacion>) q.executeList();
	}
	
}
