/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Maquina;

/**
 * @author Julián Mendoza
 *
 */
public class SQLMaquina {
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
	public SQLMaquina(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Maquina
	 */
	public long adicionarMaquina (PersistenceManager pm, long idMaquina, String tipoMaquina, long idServicioHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaMaquina() + "(id, tipo_maquina, servicio_hotel_id ) values (?, ?, ?)");
        q.setParameters(idMaquina, tipoMaquina, idServicioHotel);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarMaquinaPorId (PersistenceManager pm, long idMaquina)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMaquina() + " WHERE id = ?");
        q.setParameters(idMaquina);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto Maquina que tiene el identificador dado
	 */
	public Maquina darMaquinaPorId (PersistenceManager pm, long idMaquina) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMaquina() + " WHERE id = ?");
		q.setResultClass(Maquina.class);
		q.setParameters(idMaquina);
		return (Maquina) q.executeUnique();
	}
	
	public List<Maquina> darMaquinas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMaquina());
		q.setResultClass(Maquina.class);
		return (List<Maquina>) q.executeList();
	}
	
}
