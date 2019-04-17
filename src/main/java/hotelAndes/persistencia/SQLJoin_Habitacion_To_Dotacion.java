/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.HabitacionToDotacion;


/**
 * @author Julián Mendoza
 *
 */
public class SQLJoin_Habitacion_To_Dotacion {
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
	public SQLJoin_Habitacion_To_Dotacion(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un HabitacionToDotacion a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idHabitacion - El identificador del bebedor
	 * @param idDotacion - El identificador de la bebida
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarHabitacionToDotacion(PersistenceManager pm, long idDotacion,long idHabitacion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHabitacionToDotacion () + "(dotacion_id, habitacion_id) values (?, ?)");
        q.setParameters(idDotacion,idHabitacion);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN HabitacionToDotacion de la base de datos de Parranderos, por sus identificador
	 * @param pm - El manejador de persistencia
	 * @param idDotacion - El identificador del bebedor
	 * @param idHabitacion - El identificador de la bebida
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarHabitacionToDotacion (PersistenceManager pm, long idDotacion, long idHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacionToDotacion () + " WHERE dotacion_id = ? AND habitacion_id= ?");
        q.setParameters(idDotacion, idHabitacion);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los HabitacionToDotacion de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos HabitacionToDotacion
	 */
	public List<HabitacionToDotacion> darHabitacionToDotacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacionToDotacion ());
		q.setResultClass(HabitacionToDotacion.class);
		List<HabitacionToDotacion> resp = (List<HabitacionToDotacion>) q.execute();
		return resp;
	}
}
