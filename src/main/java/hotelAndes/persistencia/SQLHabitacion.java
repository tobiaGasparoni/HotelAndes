/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Habitacion;

/**
 * @author Julián Mendoza
 *
 */
public class SQLHabitacion {
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
	public SQLHabitacion(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}


	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Habitacion
	 */
	public long adicionarHabitacion (PersistenceManager pm, long idHabitacion, int capacidad, double consumo, int disponible, int llegadaCliente, long tipo, int idHotel, int enMantenimiento) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHabitacion() + "(id, capacidad, consumo, disponible, llegada_cliente, tipo, hotel_id, en_mantenimiento) values (?, ?, ?, ?, ? ,?, ? , ?)");
		q.setParameters(idHabitacion, capacidad, consumo, disponible, llegadaCliente, tipo, idHabitacion, enMantenimiento);
		return (long) q.executeUnique();
	}

	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarHabitacionPorId (PersistenceManager pm, long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion() + " WHERE id = ?");
		q.setParameters(idHabitacion);
		return (long) q.executeUnique();            
	}

	/**
	 * @return El objeto Habitacion que tiene el identificador dado
	 */
	public Habitacion darHabitacionPorId (PersistenceManager pm, long idHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion() + " WHERE id = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(idHabitacion);
		return (Habitacion) q.executeUnique();
	}

	public List<Habitacion> darHabitaciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion());
		q.setResultClass(Habitacion.class);
		return (List<Habitacion>) q.executeList();
	}

	public List<Long> darIdHabitacionesPorTipoYCantidadSinReservaEnPeriodoDeTiempoYIdHotel (PersistenceManager pm, long tipo, Timestamp fechaInicio, Timestamp fechaFin, long idHotel, int cantidad)
	{
		SQLReserva sqlReserva = new SQLReserva(pp);
		
		List<Long> idHabitacionesReservadas = sqlReserva.darIdHabitacionesDeReservasEnPeriodoTiempo(pm, fechaInicio, fechaFin);
        String and = "";
		if(idHabitacionesReservadas.size()==1)
		{
			and = "AND ID <> "+ idHabitacionesReservadas.get(0); 
		}else if(idHabitacionesReservadas.size() >1)
		{
			Iterator<Long> iter = idHabitacionesReservadas.iterator();
			
			while(iter.hasNext())
			{
				long id = iter.next();
				
				and += "AND ID <>"+ id;
			}
		}
		Query q = pm.newQuery(SQL, "SELECT ID FROM "+ pp.darTablaHabitacion()+ " WHERE TIPO = ? AND HOTEL_ID = ? AND ROWNUM <= ?"+ and);
		q.setResultClass(Habitacion.class);
		q.setParameters(tipo, idHotel,cantidad);
		return (List<Long>)q.executeList();
	}



	public long entradaEnMantenimiento (PersistenceManager pm, long idHabitacion)
	{
		Query q= pm.newQuery(SQL, "UPDATE "+ pp.darTablaHabitacion() + " SET EN_MANTENIMIENTO = 1 WHERE ID = ?");
		q.setParameters(idHabitacion);
		return (long)q.executeUnique();
	}

	public long salidaEnMantenimiento(PersistenceManager pm, long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "UPDATE "+ pp.darTablaHabitacion()+ " SET EN_MANTENIMIENTO = 0 WHERE ID = ? ");
		q.setParameters(idHabitacion);
		return (long)q.executeUnique();
	}

	public List<Long> entradaMultipleEnMantenimiento (PersistenceManager pm, List<Long> idHabitaciones)
	{
		Iterator<Long> iter = idHabitaciones.iterator();
		SQLHabitacion sqlHabitacion = new SQLHabitacion(pp);
		List<Long> lista = new ArrayList<>();
		while(iter.hasNext())
		{
			lista.add(sqlHabitacion.entradaEnMantenimiento(pm, iter.next()));
		}

		return lista;
	}

	public List<Long> salidaMultipleEnMantenimiento (PersistenceManager pm, List<Long> idHabitaciones)
	{
		Iterator<Long> iter = idHabitaciones.iterator();
		SQLHabitacion sqlHabitacion = new SQLHabitacion(pp);
		List<Long> lista = new ArrayList<>();
		while(iter.hasNext())
		{
			lista.add(sqlHabitacion.salidaEnMantenimiento(pm, iter.next()));
		}

		return lista;
	}



}
