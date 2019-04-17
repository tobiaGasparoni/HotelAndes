/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.ServicioProductos;

/**
 * @author Julián Mendoza
 *
 */
public class SQLServicio_Productos {
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
	public SQLServicio_Productos(PersistenciaHotelAndes pp)
	{
		this.pp= pp;
		
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ServicioProductos
	 */
	public long adicionarServicioProductos (PersistenceManager pm, long idServicioProductos, String nombre, String tipo, int enMantenimiento, int capacidad, int ocupacionActual, String estilo, long idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicioProductos() + "(id, nombre, tipo, en_mantenimiento, capacidad, ocupacion_actual, estilo, hotel_id) values (?, ?, ?,?,?,?,?,?)");
        q.setParameters(idServicioProductos, nombre, tipo, enMantenimiento, capacidad, ocupacionActual,estilo, idHotel);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarServicioProductosPorId (PersistenceManager pm, long idServicioProductos)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioProductos() + " WHERE id = ?");
        q.setParameters(idServicioProductos);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto ServicioProductos que tiene el identificador dado
	 */
	public ServicioProductos darServicioProductosPorId (PersistenceManager pm, long idServicioProductos) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioProductos() + " WHERE id = ?");
		q.setResultClass(ServicioProductos.class);
		q.setParameters(idServicioProductos);
		return (ServicioProductos) q.executeUnique();
	}
	
	public List<ServicioProductos> darServicioProductoss (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioProductos());
		q.setResultClass(ServicioProductos.class);
		return (List<ServicioProductos>) q.executeList();
	}
	
	public long entradaEnMantenimiento (PersistenceManager pm, long idServicioProductos)
	{
		Query q = pm.newQuery(SQL, "UPDATE "+ pp.darTablaServicioProductos()+ " SET EN_MANTENIMIENTO = 1 WHERE ID= ? ");
		q.setParameters(idServicioProductos);
		return (long) q.executeUnique();
	}
	
	public long salidaEnMantenimiento(PersistenceManager pm, long idServicioProductos)
	{
		Query q = pm.newQuery(SQL, "UPDATE "+ pp.darTablaServicioProductos()+ " SET EN_MANTENIMIENTO = 0 WHERE ID= ? ");
		q.setParameters(idServicioProductos);
		return (long) q.executeUnique();
	}
	
	public List<Long> entradaMultipleEnMantenimiento (PersistenceManager pm, List<Long>idServiciosProductos)
	{
		Iterator<Long> iter = idServiciosProductos.iterator();
		SQLServicio_Productos sqlServicioProductos = new SQLServicio_Productos(pp);
		List<Long> lista = new ArrayList<>();
		while(iter.hasNext())
		{
			lista.add(sqlServicioProductos.entradaEnMantenimiento(pm, iter.next()));
		}
		
		return lista;
	}
	
	public List<Long> salidaMultipleEnMantenimiento (PersistenceManager pm, List<Long> idServiciosProductos)
	{
		Iterator<Long> iter = idServiciosProductos.iterator();
		SQLServicio_Productos sqlServicioProductos = new SQLServicio_Productos(pp);
		List<Long> lista = new ArrayList<>();
		while(iter.hasNext())
		{
			lista.add(sqlServicioProductos.salidaEnMantenimiento(pm, iter.next()));
		}
		
		return lista;
	}
	
}
