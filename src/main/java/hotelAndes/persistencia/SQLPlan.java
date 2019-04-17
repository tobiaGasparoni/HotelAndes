/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Plan;

/**
 * @author Julián Mendoza
 *
 */
public class SQLPlan {
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
	public SQLPlan(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Plan
	 */
	public long adicionarPlan (PersistenceManager pm, long idPlan, String nombre, String tipo, double costo, double descuentoEstadia, double descuentoProductos, int diasEstadia, String descripcion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPlan() + "(id, nombre, tipo, costo, descuento_estadia, descuento_productos,dias_estadia,descripcion) values (?, ?, ?,?,?, ?, ?,?)");
        q.setParameters(idPlan, nombre, tipo, costo, descuentoEstadia, descuentoProductos,diasEstadia,descripcion);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarPlanPorId (PersistenceManager pm, long idPlan)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlan() + " WHERE id = ?");
        q.setParameters(idPlan);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto Plan que tiene el identificador dado
	 */
	public Plan darPlanPorId (PersistenceManager pm, long idPlan) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlan() + " WHERE id = ?");
		q.setResultClass(Plan.class);
		q.setParameters(idPlan);
		return (Plan) q.executeUnique();
	}
	
	public List<Plan> darPlans (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlan());
		q.setResultClass(Plan.class);
		return (List<Plan>) q.executeList();
	}
	
}
