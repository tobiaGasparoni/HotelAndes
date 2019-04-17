/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import main.java.hotelAndes.negocio.AnalisisFechasDemanda;
import main.java.hotelAndes.negocio.AnalisisFechasIngresos;
import main.java.hotelAndes.negocio.BuenosClientes;
import main.java.hotelAndes.negocio.ConsumosUsuarios;
import main.java.hotelAndes.negocio.DineroRecolectadoPorHabitacion;
import main.java.hotelAndes.negocio.OcupacionHabitaciones;
import main.java.hotelAndes.negocio.Reserva;
import main.java.hotelAndes.negocio.ServiciosMasPopulares;
import main.java.hotelAndes.negocio.ReservaServicio;
import main.java.hotelAndes.negocio.TipoHabitacion;
import main.java.hotelAndes.persistencia.SQLConsultas.UnidadTiempo;

/**
 * @author Julián Mendoza
 *
 */
public class PersistenciaHotelAndes {

	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaHotelAndes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaHotelAndes instance;
	
	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos.
	 */
	private List <String> tablas;
	
	private SQLUtil sqlUtil;
	
	private SQLConsumo sqlConsumo;
	
	private SQLConvencion sqlConvencion;

	private SQLCuenta sqlCuenta;
	
	private SQLDotacion sqlDotacion;
	
	private SQLHabitacion sqlHabitacion;
	
	private SQLHotel sqlHotel;
	
	private SQLInternet sqlInternet;
	
	private SQLJoin_Habitacion_To_Dotacion sqlHabitacionToDotacion;
	
	private SQLJoin_Plan_To_Hotel sqlPlanToHotel;
	
	private SQLJoin_Producto_To_Servicio sqlProductoToServicio;
	
	private SQLMaquina sqlMaquina;
	
	private SQLPlan sqlPlan;
	
	private SQLProducto sqlProducto;
	
	private SQLReserva sqlReserva;
	
	private SQLReserva_Servicio sqlReservaServicio;
	
	private SQLServicio_Comodidad sqlServicioComodidad;
	
	private SQLServicio_Hotel sqlServicioHotel;
	
	private SQLServicio_Productos sqlServicioProductos;
	
	private SQLServicio_Salon sqlServicioSalon;
	
	private SQLTipo_Habitacion sqlTipoHabitacion;
	
	private SQLUsuario sqlUsuario;
	
	private SQLConsultas sqlConsultas;
	
	private PersistenciaHotelAndes()
	{
		
		Properties prop = new Properties();
		prop.setProperty("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
		prop.setProperty("javax.jdo.option.ConnectionURL", "jdbc:oracle:thin:@fn3.oracle.virtual.uniandes.edu.co:1521:prod");
		prop.setProperty("javax.jdo.option.ConnectionUserName", "ISIS2304B141910");
		prop.setProperty("javax.jdo.option.ConnectionPassword", "dQmdYZwpZo");
		prop.setProperty("javax.jdo.option.Mapping", "oracle");
		prop.setProperty("javax.jdo.option.ConnectionDriverName", "oracle.jdbc.driver.OracleDriver");
		prop.setProperty("datanucleus.schema.autoCreateAll", "false");
		prop.setProperty("datanucleus.query.sql.allowAll", "true");
		
		pmf = JDOHelper.getPersistenceManagerFactory(prop);
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		//0
		tablas.add("HOTELANDES_SEQUENCE");
		//1
		tablas.add("CONSUMOS");
		//2
		tablas.add("CONVENCIONES");
		//3
		tablas.add("CUENTAS");
		//4
		tablas.add("DOTACIONES");
		//5
		tablas.add("HABITACIONES");
		//6
		tablas.add("HOTELES");
		//7
		tablas.add("INTERNET");
		//8
		tablas.add("JOIN_HABITACION_TO_DOTACION");
		//9
		tablas.add("JOIN_PLAN_TO_HOTEL");
		//10
		tablas.add("JOIN_PRODUCTO_TO_SERVICIO");
		//11
		tablas.add("MAQUINAS");
		//12
		tablas.add("PLANES");
		//13
		tablas.add("PRODUCTOS");
		//14
		tablas.add("RESERVAS_SERVICIO");
		//15
		tablas.add("RESERVAS");
		//16
		tablas.add("SERVICIOS_COMODIDAD");
		//17
		tablas.add("SERVICIOS_HOTEL");
		//18
		tablas.add("SERVICIOS_PRODUCTOS");
		//19
		tablas.add("SERVICIOS_SALON");
		//20
		tablas.add("TIPOS_HABITACION");
		//21
		tablas.add("USUARIOS");
	}
	

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaHotelAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas(tableConfig);
		
		String unidadPersistencia = tableConfig.get("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaHotelAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaHotelAndes();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaHotelAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaHotelAndes (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas");

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlConsumo =  new SQLConsumo(this);
		sqlCuenta = new SQLCuenta(this);
		sqlConvencion = new SQLConvencion(this);
		sqlDotacion = new SQLDotacion(this);
		sqlHabitacion = new SQLHabitacion(this);
		sqlHotel = new SQLHotel(this);
		sqlInternet = new SQLInternet(this);
		sqlHabitacionToDotacion = new SQLJoin_Habitacion_To_Dotacion(this);
		sqlPlanToHotel = new SQLJoin_Plan_To_Hotel(this);
		sqlProductoToServicio = new SQLJoin_Producto_To_Servicio(this);
		sqlMaquina = new SQLMaquina(this);
		sqlPlan = new SQLPlan(this);
		sqlProducto = new SQLProducto(this);
		sqlReserva =  new SQLReserva(this);
		sqlReservaServicio = new SQLReserva_Servicio(this);
		sqlServicioComodidad = new SQLServicio_Comodidad(this);
		sqlServicioHotel = new SQLServicio_Hotel(this);
		sqlServicioProductos = new SQLServicio_Productos(this);
		sqlServicioSalon = new SQLServicio_Salon(this);
		sqlTipoHabitacion = new SQLTipo_Habitacion(this);
		sqlUsuario = new SQLUsuario(this);
		sqlUtil = new SQLUtil(this);
		sqlConsultas = new SQLConsultas(this);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de hotelAndes
	 */
	public String darSeqHotelAndes()
	{
		return tablas.get(0);
	}

    public String darTablaConsumo()
    {
    	return tablas.get(1);
    }
    
    public String darTablaConvencion()
    {
    	return tablas.get(2);
    }
    
    public String darTablaCuenta()
    {
    	return tablas.get(3);
    }
    
    public String darTablaDotacion()
    {
    	return tablas.get(4);
    }
    
    public String darTablaHabitacion()
    {
    	return tablas.get(5);
    }
    
    public String darTablaHotel()
    {
    	return tablas.get(6);
    }
    
    public String darTablaInternet()
    {
    	return tablas.get(7);
    }
    
    public String darTablaHabitacionToDotacion()
    {
    	return tablas.get(8);
    }
    
    public String darTablaPlanToHotel()
    {
    	return tablas.get(9);
    }
    
    public String darTablaProductoToServicio()
    {
    	return tablas.get(10);
    }
    
    public String darTablaMaquina()
    {
    	return tablas.get(11);
    }
    
    public String darTablaPlan()
    {
    	return tablas.get(12);
    }
    
    public String darTablaProducto()
    {
    	return tablas.get(13);
    }
    
    public String darTablaReservaServicio()
    {
    	return tablas.get(14);
    }
    
    public String darTablaReserva()
    {
    	return tablas.get(15);
    }
    
    public String darTablaServicioComodidad()
    {
    	return tablas.get(16);
    }
    
    public String darTablaServicioHotel()
    {
    	return tablas.get(17);
    }
    
    public String darTablaServicioProductos()
    {
    	return tablas.get(18);
    }
    
    public String darTablaServicioSalon()
    {
    	return tablas.get(19);
    }
    
    public String darTablaTipoHabitacion()
    {
    	return tablas.get(20);
    }
    
    public String darTablaUsuario()
    {
    	return tablas.get(21);
    }
    
    /**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long nextval()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los TIPOS DE HABITACION
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla TiposHabitacion
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de habitacion
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public TipoHabitacion adicionarTipoHabitacion(String pNombre, String pDescripcion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idTipoHabitacion = nextval();
            long tuplasInsertadas = sqlTipoHabitacion.adicionarTipoHabitacion(pm, idTipoHabitacion, pNombre, pDescripcion);
            tx.commit();
            
            log.trace("Inserción de tipo de habitacion: " + pNombre + " y descripcion: " + pDescripcion + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new TipoHabitacion(idTipoHabitacion, pNombre, pDescripcion);
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que consulta todas las tuplas en la tabla TipoBebida
	 * @return La lista de objetos TipoBebida, construidos con base en las tuplas de la tabla TIPOBEBIDA
	 */
	public List<TipoHabitacion> darTiposHabitacion ()
	{
		return sqlTipoHabitacion.darTiposHabitacion (pmf.getPersistenceManager());
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los requerimientos de consulta
	 *****************************************************************/
	public List<DineroRecolectadoPorHabitacion> dineroRecolectadoPorHabitacion(String fechaMinima, String fechaMaxima)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            List<DineroRecolectadoPorHabitacion> tuplas = sqlConsultas.dineroRecolectadoPorHabitacion(pm, fechaMinima, fechaMaxima);
            tx.commit();
            
            long numTuplas = tuplas.size();
            log.trace("Consulta dinero recolectado por habitacion: entre" + fechaMinima + " y " + fechaMaxima + ": " + numTuplas + " tuplas retornadas");
            
            return tuplas;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<ServiciosMasPopulares> serviciosMasPopulares()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            List<ServiciosMasPopulares> tuplas = sqlConsultas.serviciosMasPopulares(pm);
            tx.commit();
            
            long numTuplas = tuplas.size();
            log.trace("Consulta 20 servicios mas populares: " + numTuplas + " tuplas retornadas");
            
            return tuplas;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<OcupacionHabitaciones> ocupacionHabitaciones()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            List<OcupacionHabitaciones> tuplas = sqlConsultas.ocupacionHabitaciones(pm);
            tx.commit();
            
            long numTuplas = tuplas.size();
            log.trace("Consulta indice de ocupacion de las habitaciones: " + numTuplas + " tuplas retornadas");
            
            return tuplas;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();

        }
	}
	
	public Reserva adicionarReserva (Timestamp fechaEntrada, Timestamp fechaSalida, int numeroPersonas, long planPago, String tipoDocumento, String documento, String tipo, long idHabitacion, long idConvencion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			long idReserva = nextval();
			long tuplasInsertadas = sqlReserva.adicionarReserva(pm, idReserva, fechaEntrada, fechaSalida, numeroPersonas, planPago, tipoDocumento, documento, tipo, idHabitacion, idConvencion);
		    tx.commit();
		    
		    log.trace("Insercion de reserva: FechaEntrada: "+ fechaEntrada + " FechaSalida: "+ numeroPersonas+ " Tipo Documento: "+ tipoDocumento+ " Documento: "+ documento+ " Id habitacion: "+ idHabitacion+ " : "+ tuplasInsertadas + " tuplas insertadas.");
		    
		    return new Reserva(idReserva, fechaEntrada, fechaSalida, numeroPersonas, planPago, tipoDocumento, documento, tipo, idHabitacion, idConvencion);
		}
		catch (Exception e) {
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
		}
		finally{
			if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<ConsumosUsuarios> consumosUsuarios(String tipoDoc, String doc)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            List<ConsumosUsuarios> tuplas = sqlConsultas.consumosUsuarios(pm, tipoDoc, doc);
            tx.commit();
            
            long numTuplas = tuplas.size();
            log.trace("Consulta consumos de un usuario dado: " + numTuplas + " tuplas retornadas");
            
            return tuplas;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally{
			if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public ReservaServicio adicionarReservaServicio (double costo, String descripcion, Timestamp fecha, String nombreEmpleado, int numClientes, String tipoServicio, long idServicio, String tipoDocumento, String documento, String tipo, long idHotel, long idConvencion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		try {
			tx.begin();
			long idReservaServicio = nextval();
			long tuplasInsertadas= sqlReservaServicio.adicionarReservaServicio(pm, idReservaServicio, costo, descripcion, fecha, nombreEmpleado, numClientes, tipoServicio, idServicio, tipoDocumento, documento, tipo, idHotel, idConvencion);
			tx.commit();
			
			log.trace("Insercion de reserva servicio: Costo: "+costo+ " descripcion: "+ descripcion+ " fecha: "+ fecha+ " nombre empleado: "+ nombreEmpleado+ " numero clientes: "+ numClientes+ " tipo servicio: "+ tipoServicio+ " id servicio:"+ idServicio+  " tipo documento: "+tipoDocumento+ " documento: "+documento+ " tipo: "+tipo+ "id hotel"+ idHotel+ " : "+tuplasInsertadas+ " tuplas insertadas" );
			
			return new ReservaServicio(idReservaServicio, costo, descripcion, fecha, nombreEmpleado, numClientes, tipoServicio, idServicio, tipoDocumento, documento, tipo, idHotel, idConvencion);
		} catch (Exception e) {
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
		}
		finally{
			if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<AnalisisFechasIngresos> analisisFechasIngresos(boolean porTipoDeHabitacion, UnidadTiempo unit, int amount, String id, String tipoServicio)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            List<AnalisisFechasIngresos> tuplas = sqlConsultas.analisisFechasIngresos(pm, porTipoDeHabitacion, unit, amount, id, tipoServicio);
            tx.commit();
            String por = null;
            if(porTipoDeHabitacion)
            	por = "por tipo de habitacion";
            else
            	por = "por tipo de servicio";
            
            long numTuplas = tuplas.size();
            log.trace("Consulta fechas mayores ingresos " + por + ": " + numTuplas + " tuplas retornadas");
            
            return tuplas;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally{
			if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public long registrarLlegadaCliente (long idReserva)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			
			tx.begin();
			long resp = sqlReserva.registrarLlegadaCliente(pm, idReserva, nextval());
			tx.commit();
			return resp;
		} catch (Exception e) {
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
		}finally{
			if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<AnalisisFechasDemanda> analisisFechasDemanda(boolean porTipoDeHabitacion, UnidadTiempo unit, int amount, String id, String tipoServicio)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            List<AnalisisFechasDemanda> tuplas = sqlConsultas.analisisFechasDemanda(pm, porTipoDeHabitacion, unit, amount, id, tipoServicio);
            tx.commit();
            String por = null;
            if(porTipoDeHabitacion)
            	por = "por tipo de habitacion";
            else
            	por = "por tipo de servicio";
            
            long numTuplas = tuplas.size();
            log.trace("Consulta fechas mayor demanda " + por + ": " + numTuplas + " tuplas retornadas");
            
            return tuplas;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<BuenosClientes> buenosClientes()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            List<BuenosClientes> tuplas = sqlConsultas.buenosClientes(pm);
            tx.commit();
            
            long numTuplas = tuplas.size();
            log.trace("Consulta buenos clientes: " + numTuplas + " tuplas retornadas");
            
            return tuplas;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally{
			if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
}
