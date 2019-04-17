/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.ServicioSalon;

/**
 * @author Julián Mendoza
 *
 */
public class SQLServicio_Salon {
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
	public SQLServicio_Salon(PersistenciaHotelAndes pp)
	{
		this.pp=pp;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ServicioSalon
	 */
	public long adicionarServicioSalon (PersistenceManager pm, long idServicioSalon,String descripcion, int enMantenimiento, double costo, int capacidad, long idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicioSalon() + "(id, descripcion, en_mantenimiento, costo, capacidad, hotel_id) values (?, ?, ?,?,?,?)");
        q.setParameters(idServicioSalon, descripcion, enMantenimiento, costo, capacidad, idHotel);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarServicioSalonPorId (PersistenceManager pm, long idServicioSalon)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioSalon() + " WHERE id = ?");
        q.setParameters(idServicioSalon);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto ServicioSalon que tiene el identificador dado
	 */
	public ServicioSalon darServicioSalonPorId (PersistenceManager pm, long idServicioSalon) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioSalon() + " WHERE id = ?");
		q.setResultClass(ServicioSalon.class);
		q.setParameters(idServicioSalon);
		return (ServicioSalon) q.executeUnique();
	}
	
	public List<ServicioSalon> darServicioSalons (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioSalon());
		q.setResultClass(ServicioSalon.class);
		return (List<ServicioSalon>) q.executeList();
	}
	
}
