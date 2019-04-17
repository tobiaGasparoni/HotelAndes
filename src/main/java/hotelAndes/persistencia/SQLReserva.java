/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Reserva;

/**
 * @author Julián Mendoza
 *
 */
public class SQLReserva {
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
	public SQLReserva(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Reserva
	 */
	public long adicionarReserva (PersistenceManager pm, long idReserva, Timestamp fechaEntrada, Timestamp fechaSalida, int numeroPersonas, long planPago, String tipoDocumento, String documento, String tipo, long idHabitacion, long idConvencion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReserva() + "(id, fecha_entrada, fecha_salida, numero_personas, plan_pago, tipo_documento, documento, tipo, habitacion_id, convencion_id) values (?, ?, ?,?,?,?,?,?,?,?)");
        q.setParameters(idReserva, fechaEntrada, fechaSalida, numeroPersonas, planPago, tipoDocumento, documento, tipo, idHabitacion, idConvencion);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarReservaPorId (PersistenceManager pm, long idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva() + " WHERE id = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto Reserva que tiene el identificador dado
	 */
	public Reserva darReservaPorId (PersistenceManager pm, long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva() + " WHERE id = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(idReserva);
		return (Reserva) q.executeUnique();
	}
	
	public List<Reserva> darReservas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva());
		q.setResultClass(Reserva.class);
		return (List<Reserva>) q.executeList();
	}
	
}
