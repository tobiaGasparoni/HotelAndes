/**
 * 
 */
package main.java.hotelAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

/**
 * @author Julián Mendoza
 *
 */
public class SQLUtil {
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
	public SQLUtil(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para obtener un nuevo número de secuencia
	 * @param pm - El manejador de persistencia
	 * @return El número de secuencia generado
	 */
	public long nextval (PersistenceManager pm)
	{
		System.out.println("HEYEYYYEYEYEYEYYEEYYE!!!!! Este es: " + pp.darSeqHotelAndes() + " " + pp.darTablaConsumo());
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqHotelAndes() + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}
	
	public long [] limpiarHotelAndes (PersistenceManager pm)
	{

        Query qProductoToServicio = pm.newQuery(SQL, "DELETE FROM "+pp.darTablaProductoToServicio());
        Query qPlanToHotel = pm.newQuery(SQL, "DELETE FROM "+pp.darTablaPlanToHotel());
        Query qHabitacionToDotacion = pm.newQuery(SQL, "DELETE FROM "+ pp.darTablaHabitacionToDotacion()); 
        Query qPlan = pm.newQuery(SQL, "DELETE FROM "+ pp.darTablaPlan());
        Query qReservaServicio = pm.newQuery(SQL,  "DELETE FROM "+ pp.darTablaReservaServicio());
        Query qConvencion = pm.newQuery(SQL,  "DELETE FROM "+ pp.darTablaConvencion());
        Query qReserva = pm.newQuery(SQL,  "DELETE FROM " +pp.darTablaReserva());
        Query qCuenta = pm.newQuery(SQL, "DELETE FROM "+pp.darTablaCuenta());
        Query qHotel= pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel());
        Query qConsumo = pm.newQuery(SQL, "DELETE FROM "+ pp.darTablaConsumo());
        Query qServicioHotel = pm.newQuery(SQL, "DELETE FROM "+ pp.darTablaServicioHotel());
        Query qServicioProductos = pm.newQuery(SQL, "DELETE FROM "+ pp.darTablaServicioProductos());
        Query qServicioSalon= pm.newQuery(SQL, "DELETE FROM "+ pp.darTablaServicioSalon());
        Query qServicioComodidad = pm.newQuery(SQL, "DELETE FROM "+ pp.darTablaServicioComodidad());
        Query qHabitacion = pm.newQuery(SQL,"DELETE FROM " + pp.darTablaHabitacion() );
        Query qTipoHabitacion = pm.newQuery(SQL,  "DELETE FROM "+pp.darTablaTipoHabitacion());
        Query qDotacion = pm.newQuery(SQL, "DELETE FROM "+pp.darTablaDotacion());
        Query qProducto = pm.newQuery(SQL, "DELETE FROM "+ pp.darTablaProducto());
        Query qInternet = pm.newQuery(SQL, "DELETE FROM "+ pp.darTablaInternet());
        Query qMaquina = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMaquina());
        Query qUsuario = pm.newQuery(SQL, "DELETE FROM "+pp.darTablaUsuario());
        
        long productoToServicioEliminados = (long) qProductoToServicio.executeUnique();
        long planToHotelElimiandos = (long) qPlanToHotel.executeUnique();
        long habitacionToDotacionEliminados = (long) qHabitacionToDotacion.executeUnique();
        long planEliminados =(long) qPlan.executeUnique();
        long reservaServicioEliminados = (long) qReservaServicio.executeUnique();
        long convencionEliminados =(long) qConvencion.executeUnique();
        long reservaEliminados = (long) qReserva.executeUnique();
        long cuentaEliminados = (long) qCuenta.executeUnique();
        long hotelEliminados = (long) qHotel.executeUnique();
        long consumoEliminados = (long) qConsumo.executeUnique();
        long servicioHotelEliminados = (long) qServicioHotel.executeUnique();
        long servicioProductosEliminados =(long) qServicioProductos.executeUnique();
        long servicioSalonEliminados = (long)qServicioSalon.executeUnique();
        long servicioComodidadEliminados =(long)qServicioComodidad.executeUnique();
        long habitacionEliminados = (long)qHabitacion.executeUnique();
        long tipoHabitacionEliminados = (long)qTipoHabitacion.executeUnique();
        long dotacionEliminados =(long)qDotacion.executeUnique();
        long productoEliminados = (long)qProducto.executeUnique();
        long internetEliminados = (long)qInternet.executeUnique();
        long maquinaEliminados = (long)qMaquina.executeUnique();
        long usuarioEliminados = (long)qUsuario.executeUnique();
        
        
        
        return new long[] {productoToServicioEliminados, planToHotelElimiandos, habitacionToDotacionEliminados,
        		planEliminados, reservaServicioEliminados, convencionEliminados, reservaEliminados, cuentaEliminados,
        		hotelEliminados,consumoEliminados,servicioHotelEliminados,servicioProductosEliminados,
        		servicioSalonEliminados,servicioComodidadEliminados,habitacionEliminados,tipoHabitacionEliminados,
        		dotacionEliminados,productoEliminados, internetEliminados,maquinaEliminados,usuarioEliminados};
	}
}
