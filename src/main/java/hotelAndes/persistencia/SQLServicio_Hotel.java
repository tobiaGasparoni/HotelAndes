/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.ServicioHotel;

/**
 * @author Julián Mendoza
 *
 */
public class SQLServicio_Hotel {
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
	public SQLServicio_Hotel(PersistenciaHotelAndes pp )
	{
		this.pp = pp;
	}

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ServicioHotel
	 */
	public long adicionarServicioHotel (PersistenceManager pm, long idServicioHotel, String nombre, int capacidad, int ocupacionActual, String descripcion, int enMantenimiento, String horario, long idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicioHotel() + "(id, nombre, capacidad, ocupacionActual, descripcion, en_mantenimiento, horario, hotel_id) values (?, ?, ?,?,?,?,?,?)");
        q.setParameters(idServicioHotel, nombre, capacidad, ocupacionActual, descripcion,enMantenimiento, horario, idHotel);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarServicioHotelPorId (PersistenceManager pm, long idServicioHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioHotel() + " WHERE id = ?");
        q.setParameters(idServicioHotel);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto ServicioHotel que tiene el identificador dado
	 */
	public ServicioHotel darServicioHotelPorId (PersistenceManager pm, long idServicioHotel) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioHotel() + " WHERE id = ?");
		q.setResultClass(ServicioHotel.class);
		q.setParameters(idServicioHotel);
		return (ServicioHotel) q.executeUnique();
	}
	
	public List<ServicioHotel> darServicioHotels (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioHotel());
		q.setResultClass(ServicioHotel.class);
		return (List<ServicioHotel>) q.executeList();
	}
	
}
