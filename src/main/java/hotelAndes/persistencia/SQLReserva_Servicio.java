/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.ReservaServicio;

/**
 * @author Julián Mendoza
 *
 */
public class SQLReserva_Servicio {
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
	public SQLReserva_Servicio(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ReservaServicio
	 */
	public long adicionarReservaServicio (PersistenceManager pm, long idReservaServicio, double costo, String descripcion, Timestamp fecha, String nombreEmpleado, int numclientes, String tipoServicio, long idServicio, String tipoDocumento, String documento, String tipo, long idHotel, long idConvencion ) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReservaServicio() + "(id, costo, descripcion, fecha, nombre_empleado, num_clientes, tipo_servicio, servicio_id, tipo_documento, documento, tipo, hotel_id, convencion_id) values (?, ?, ?,?,?,?,?,?,?,?,?,?,?)");
        q.setParameters(idReservaServicio, costo, descripcion, fecha, nombreEmpleado, numclientes, tipoServicio, idServicio,tipoDocumento, documento, tipo, idHotel, idConvencion);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarReservaServicioPorId (PersistenceManager pm, long idReservaServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservaServicio() + " WHERE id = ?");
        q.setParameters(idReservaServicio);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto ReservaServicio que tiene el identificador dado
	 */
	public ReservaServicio darReservaServicioPorId (PersistenceManager pm, long idReservaServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaServicio() + " WHERE id = ?");
		q.setResultClass(ReservaServicio.class);
		q.setParameters(idReservaServicio);
		return (ReservaServicio) q.executeUnique();
	}
	
	public List<ReservaServicio> darReservaServicios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaServicio());
		q.setResultClass(ReservaServicio.class);
		return (List<ReservaServicio>) q.executeList();
	}
	
}
