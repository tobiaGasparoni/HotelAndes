/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Hotel;

/**
 * @author Julián Mendoza
 *
 */
public class SQLHotel {
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
	public SQLHotel(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Hotel
	 */
	public long adicionarHotel (PersistenceManager pm, long idHotel, String nombre, String ciudad, String pais, String direccion, long idInternet) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHotel() + "(id, nombre, ciudad, pais, direccion, internet_id) values (?, ?, ?, ?, ? ,?)");
        q.setParameters(idHotel, nombre, ciudad, pais, direccion, idInternet);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarHotelPorId (PersistenceManager pm, long idHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel() + " WHERE id = ?");
        q.setParameters(idHotel);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto Hotel que tiene el identificador dado
	 */
	public Hotel darHotelPorId (PersistenceManager pm, long idHotel) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel() + " WHERE id = ?");
		q.setResultClass(Hotel.class);
		q.setParameters(idHotel);
		return (Hotel) q.executeUnique();
	}
	
	public List<Hotel> darHotels (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel());
		q.setResultClass(Hotel.class);
		return (List<Hotel>) q.executeList();
	}
	
}
