/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Consumo;
import main.java.hotelAndes.negocio.Reserva;

/**
 * @author Julián Mendoza
 *
 */
public class SQLConsumo {
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
	public SQLConsumo(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un CONSUMO
	 */
	public long[] adicionarConsumo (PersistenceManager pm, long idConsumo, Timestamp fecha, double costo, String descripcion, long idServicioComodidad, long idServicioHotel, long idServicioProductos,long idServicioSalon, long idHabitacion) 
	{
        Query q1 = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConsumo() + "(id, fecha, costo, descripcion, id_servicio_comodidad,id_servicio_hotel,id_servicio_productos,id_servicio_salon,id_habitacion) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        q1.setParameters(idConsumo,fecha,costo,descripcion,idServicioComodidad,idServicioHotel,idServicioProductos,idServicioSalon,idHabitacion);
        
        SQLReserva sqlReseva = new SQLReserva(pp);
        
        Reserva reserva = sqlReseva.darReservaPorHabitacionYFecha(pm, idHabitacion, fecha);
        
        Query q2 = pm.newQuery(SQL, "UPDATE "+ pp.darTablaCuenta() + "SET COSTO = COSTO + ? WHERE RESERVA_ID = ? ");
        q2.setParameters(costo, reserva.getId());
        
        long adicionConsumo = (long) q1.executeUnique();
        
        long sumarCostoCuenta = (long) q2.executeUnique();
        
        return new long [] {adicionConsumo,sumarCostoCuenta};
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarConsumoPorId (PersistenceManager pm, long idConsumo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumo() + " WHERE id = ?");
        q.setParameters(idConsumo);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto COnsumo que tiene el identificador dado
	 */
	public Consumo darConsumoPorId (PersistenceManager pm, long idConsumo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumo() + " WHERE id = ?");
		q.setResultClass(Consumo.class);
		q.setParameters(idConsumo);
		return (Consumo) q.executeUnique();
	}
	
	public List<Consumo> darConsumos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumo());
		q.setResultClass(Consumo.class);
		return (List<Consumo>) q.executeList();
	}
	
	
	
}
