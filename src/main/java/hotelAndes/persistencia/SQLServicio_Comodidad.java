/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.ServicioComodidad;

/**
 * @author Julián Mendoza
 *
 */
public class SQLServicio_Comodidad {
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
	public SQLServicio_Comodidad(PersistenciaHotelAndes pp)
	{
		this.pp= pp;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ServicioComodidad
	 */
	public long adicionarServicioComodidad (PersistenceManager pm, long idServicioComodidad, String nombre, String descripcion, double costo, int enMantenimiento, int duracion, String horario, long idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicioComodidad() + "(id, nombre, descripcion, costo, en_mantenimiento, duracion, horario, hotel_id) values (?, ?, ?,?,?,?,?,?)");
        q.setParameters(idServicioComodidad, nombre, descripcion, costo, enMantenimiento,duracion, horario, idHotel);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarServicioComodidadPorId (PersistenceManager pm, long idServicioComodidad)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioComodidad() + " WHERE id = ?");
        q.setParameters(idServicioComodidad);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto ServicioComodidad que tiene el identificador dado
	 */
	public ServicioComodidad darServicioComodidadPorId (PersistenceManager pm, long idServicioComodidad) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioComodidad() + " WHERE id = ?");
		q.setResultClass(ServicioComodidad.class);
		q.setParameters(idServicioComodidad);
		return (ServicioComodidad) q.executeUnique();
	}
	
	public List<ServicioComodidad> darServicioComodidads (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioComodidad());
		q.setResultClass(ServicioComodidad.class);
		return (List<ServicioComodidad>) q.executeList();
	}
	
	public long entradaEnMantenimiento (PersistenceManager pm, long idServicioComodidad)
	{
		Query q = pm.newQuery(SQL, "UPDATE "+ pp.darTablaServicioComodidad()+ " SET EN_MANTENIMIENTO = 1 WHERE ID= ? ");
		q.setParameters(idServicioComodidad);
		return (long) q.executeUnique();
	}
	
	public long salidaEnMantenimiento(PersistenceManager pm, long idServicioComodidad)
	{
		Query q = pm.newQuery(SQL, "UPDATE "+ pp.darTablaServicioComodidad()+ " SET EN_MANTENIMIENTO = 0 WHERE ID= ? ");
		q.setParameters(idServicioComodidad);
		return (long) q.executeUnique();
	}
	
	public List<Long> entradaMultipleEnMantenimiento (PersistenceManager pm, List<Long>idServiciosComodidad)
	{
		Iterator<Long> iter = idServiciosComodidad.iterator();
		SQLServicio_Comodidad sqlServicioComodidad = new SQLServicio_Comodidad(pp);
		List<Long> lista = new ArrayList<>();
		while(iter.hasNext())
		{
			lista.add(sqlServicioComodidad.entradaEnMantenimiento(pm, iter.next()));
		}
		
		return lista;
	}
	
	public List<Long> salidaMultipleEnMantenimiento (PersistenceManager pm, List<Long> idServiciosComodidad)
	{
		Iterator<Long> iter = idServiciosComodidad.iterator();
		SQLServicio_Comodidad sqlServicioComodidad = new SQLServicio_Comodidad(pp);
		List<Long> lista = new ArrayList<>();
		while(iter.hasNext())
		{
			lista.add(sqlServicioComodidad.salidaEnMantenimiento(pm, iter.next()));
		}
		
		return lista;
	}
	
}
