/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.PlanToHotel;

/**
 * @author Julián Mendoza
 *
 */
public class SQLJoin_Plan_To_Hotel {
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
	public SQLJoin_Plan_To_Hotel(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un PlanToHotel a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idPlan - El identificador del bebedor
	 * @param idHotel - El identificador de la bebida
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarPlanToHotel(PersistenceManager pm, long idHotel,long idPlan) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPlanToHotel () + "(hotel_id, plan_id) values (?, ?)");
        q.setParameters(idHotel,idPlan);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN PlanToHotel de la base de datos de Parranderos, por sus identificador
	 * @param pm - El manejador de persistencia
	 * @param idHotel - El identificador del bebedor
	 * @param idPlan - El identificador de la bebida
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarPlanToHotel (PersistenceManager pm, long idHotel, long idPlan)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanToHotel () + " WHERE hotel_id = ? AND plan_id= ?");
        q.setParameters(idHotel, idPlan);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los PlanToHotel de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos PlanToHotel
	 */
	public List<PlanToHotel> darPlanToHotel (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanToHotel ());
		q.setResultClass(PlanToHotel.class);
		List<PlanToHotel> resp = (List<PlanToHotel>) q.execute();
		return resp;
	}
}
