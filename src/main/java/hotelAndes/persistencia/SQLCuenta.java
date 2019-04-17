/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Cuenta;

/**
 * @author Julián Mendoza
 *
 */
public class SQLCuenta {
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
	public SQLCuenta(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Cuenta
	 */
	public long adicionarCuenta (PersistenceManager pm, long idCuenta, double costo, int pagada, long idReserva, long idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCuenta() + "(id, costo, pagada, reserva_id, hotel_id) values (?, ?, ?, ?, ?)");
        q.setParameters(idCuenta, costo, pagada, idReserva, idHotel);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarCuentaPorId (PersistenceManager pm, long idCuenta)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCuenta() + " WHERE id = ?");
        q.setParameters(idCuenta);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto Cuenta que tiene el identificador dado
	 */
	public Cuenta darCuentaPorId (PersistenceManager pm, long idCuenta) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCuenta() + " WHERE id = ?");
		q.setResultClass(Cuenta.class);
		q.setParameters(idCuenta);
		return (Cuenta) q.executeUnique();
	}
	
	public List<Cuenta> darCuentas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCuenta());
		q.setResultClass(Cuenta.class);
		return (List<Cuenta>) q.executeList();
	}
	
}
