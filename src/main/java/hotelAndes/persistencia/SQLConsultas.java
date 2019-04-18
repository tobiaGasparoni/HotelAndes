package main.java.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.AnalisisFechasDemanda;
import main.java.hotelAndes.negocio.AnalisisFechasIngresos;
import main.java.hotelAndes.negocio.BuenosClientes;
import main.java.hotelAndes.negocio.Consumo;
import main.java.hotelAndes.negocio.ConsumosUsuarios;
import main.java.hotelAndes.negocio.DineroRecolectadoPorHabitacion;
import main.java.hotelAndes.negocio.OcupacionHabitaciones;
import main.java.hotelAndes.negocio.ServiciosMasPopulares;

public class SQLConsultas
{
	/* ****************************************************************
	 * 			Enumeraciones
	 *****************************************************************/
	public enum UnidadTiempo {
	    DIA, SEMANA, MES, ANIO
	}
	
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
	public SQLConsultas(PersistenciaHotelAndes pp)
	{
		this.pp = pp ;
	}

	public List<DineroRecolectadoPorHabitacion> dineroRecolectadoPorHabitacion(PersistenceManager pm, String fechaMinima, String fechaMaxima)
	{
		String command = "SELECT ID_HABITACION HABITACION, SUM(COSTO) DINERO_RECOLECTADO "+
				"FROM CONSUMOS "+
				"WHERE FECHA > TO_DATE('" + fechaMinima + "','DD-MON-YYYY') "+
				"AND FECHA < TO_DATE('" + fechaMaxima + "','DD-MON-YYYY') "+
				"GROUP BY ID_HABITACION "+
				"ORDER BY ID_HABITACION";
		Query q = pm.newQuery(SQL, command);
		q.setResultClass(DineroRecolectadoPorHabitacion.class);
		return (List<DineroRecolectadoPorHabitacion>) q.executeList();
	}

	public List<ServiciosMasPopulares> serviciosMasPopulares(PersistenceManager pm)
	{
		String command = "SELECT * FROM (\r\n" + 
				"SELECT serv.NOMBRE, COUNT(serv.NOMBRE) NUM_CONSUMOS FROM\r\n" + 
				"(SELECT cons.ID_SERVICIO_COMODIDAD ID_SERVICIO FROM CONSUMOS cons\r\n" + 
				"WHERE ID_SERVICIO_COMODIDAD IS NOT NULL)\r\n" + 
				"INNER JOIN SERVICIOS_COMODIDAD serv\r\n" + 
				"ON ID_SERVICIO = serv.ID\r\n" + 
				"GROUP BY serv.NOMBRE\r\n" + 
				"UNION\r\n" + 
				"SELECT serv.NOMBRE, COUNT(serv.NOMBRE) NUM_CONSUMOS FROM\r\n" + 
				"(SELECT cons.ID_SERVICIO_HOTEL ID_SERVICIO FROM CONSUMOS cons\r\n" + 
				"WHERE ID_SERVICIO_HOTEL IS NOT NULL)\r\n" + 
				"INNER JOIN SERVICIOS_HOTEL serv\r\n" + 
				"ON ID_SERVICIO = serv.ID\r\n" + 
				"GROUP BY serv.NOMBRE\r\n" + 
				"UNION\r\n" + 
				"SELECT serv.NOMBRE, COUNT(serv.NOMBRE) NUM_CONSUMOS FROM\r\n" + 
				"(SELECT cons.ID_SERVICIO_PRODUCTOS ID_SERVICIO FROM CONSUMOS cons\r\n" + 
				"WHERE ID_SERVICIO_PRODUCTOS IS NOT NULL)\r\n" + 
				"INNER JOIN SERVICIOS_PRODUCTOS serv\r\n" + 
				"ON ID_SERVICIO = serv.ID\r\n" + 
				"GROUP BY serv.NOMBRE\r\n" + 
				"UNION\r\n" + 
				"SELECT serv.DESCRIPCION, COUNT(serv.DESCRIPCION) NUM_CONSUMOS FROM\r\n" + 
				"(SELECT cons.ID_SERVICIO_SALON ID_SERVICIO FROM CONSUMOS cons\r\n" + 
				"WHERE ID_SERVICIO_SALON IS NOT NULL)\r\n" + 
				"INNER JOIN SERVICIOS_SALON serv\r\n" + 
				"ON ID_SERVICIO = serv.ID\r\n" + 
				"GROUP BY serv.DESCRIPCION\r\n" + 
				"ORDER BY NUM_CONSUMOS DESC)\r\n" + 
				"WHERE ROWNUM <= 20";
		Query q = pm.newQuery(SQL, command);
		q.setResultClass(ServiciosMasPopulares.class);
		return (List<ServiciosMasPopulares>) q.executeList();
	}
	
	public List<OcupacionHabitaciones> ocupacionHabitaciones(PersistenceManager pm)
	{
		String command = "SELECT HABITACION_ID, ROUND(NUMERO_PERSONAS/CAPACIDAD*100,2) OCUPACION FROM\r\n" + 
				"((SELECT HABITACION_ID, NUMERO_PERSONAS FROM RESERVAS\r\n" + 
				"WHERE FECHA_ENTRADA <= SYSDATE AND FECHA_SALIDA >= SYSDATE)\r\n" + 
				"INNER JOIN\r\n" + 
				"(SELECT ID, CAPACIDAD\r\n" + 
				"FROM HABITACIONES\r\n" + 
				"WHERE LLEGADA_CLIENTE = 1)\r\n" + 
				"ON HABITACION_ID = ID)";
		Query q = pm.newQuery(SQL, command);
		q.setResultClass(OcupacionHabitaciones.class);
		return (List<OcupacionHabitaciones>) q.executeList();
	}
	
	public List<ConsumosUsuarios> consumosUsuarios(PersistenceManager pm, String tipoDoc, String doc)
	{
		String command = "SELECT * FROM (\r\n" + 
				"SELECT COSTO, DESCRIPCION, FECHA, HABITACION_ID FROM (\r\n" + 
				"SELECT HABITACION_ID, TIPO_DOCUMENTO TIP_DOC, DOCUMENTO DOC, FECHA_ENTRADA, FECHA_SALIDA FROM RESERVAS)\r\n" + 
				"INNER JOIN \r\n" + 
				"(SELECT NOMBRE, TIPO_DOCUMENTO TIP_DOC_USUR, DOCUMENTO DOC_USUR FROM USUARIOS usur\r\n" + 
				"WHERE usur.TIPO_DOCUMENTO = '" + tipoDoc + "' AND usur.DOCUMENTO = '" + doc + "')\r\n" + 
				"ON TIP_DOC = TIP_DOC_USUR AND DOC = DOC_USUR\r\n" + 
				"INNER JOIN\r\n" + 
				"(SELECT ID_HABITACION, COSTO, DESCRIPCION, FECHA FROM CONSUMOS)\r\n" + 
				"ON ID_HABITACION = HABITACION_ID)";
		Query q = pm.newQuery(SQL, command);
		q.setResultClass(ConsumosUsuarios.class);
		return (List<ConsumosUsuarios>) q.executeList();
	}
	
	public List<AnalisisFechasIngresos> analisisFechasIngresos(PersistenceManager pm, boolean porTipoDeHabitacion, UnidadTiempo unit, int amount, String id, String tipoServicio)
	{	
		String difference = generateDifference(unit, amount);
		String command = null;
		if(porTipoDeHabitacion)
			command = "SELECT SUM(COSTO) INGRESOS_TOTALES, ROUND(FECHA,'DDD') FECHA_CONSUMO\r\n" + 
					"FROM CONSUMOS cons\r\n" + 
					"INNER JOIN\r\n" + 
					"HABITACIONES hab\r\n" + 
					"ON hab.ID = cons.ID_HABITACION\r\n" + 
					"WHERE cons.FECHA < SYSTIMESTAMP AND \r\n" + 
					"cons.FECHA > " + difference + " AND\r\n" + 
					"TIPO = " + id + "\r\n" + 
					"GROUP BY ROUND(FECHA,'DDD')\r\n" + 
					"ORDER BY SUM(COSTO) DESC";
		else
			command = "SELECT SUM(COSTO) INGRESOS_TOTALES,ROUND(FECHA,'DDD') FECHA_CONSUMO\r\n" + 
					"FROM CONSUMOS cons\r\n" + 
					"WHERE cons.FECHA < SYSTIMESTAMP AND\r\n" + 
					"cons.FECHA > " + difference + " AND\r\n" + 
					tipoServicio + " = " + id + "\r\n" + 
					"GROUP BY ROUND(FECHA,'DDD')\r\n" + 
					"ORDER BY SUM(COSTO) DESC";
		Query q = pm.newQuery(SQL, command);
		q.setResultClass(AnalisisFechasIngresos.class);
		return (List<AnalisisFechasIngresos>) q.executeList();
	}
	
	public List<AnalisisFechasDemanda> analisisFechasDemanda(PersistenceManager pm, boolean porTipoDeHabitacion, UnidadTiempo unit, int amount, String id, String tipoServicio)
	{
		String difference = generateDifference(unit, amount);
		String command = null;
		if(porTipoDeHabitacion)
			command = "SELECT COUNT(ROUND(FECHA,'DDD')) NUM_CONSUMOS,ROUND(FECHA,'DDD') FECHA_CONSUMO\r\n" + 
					"FROM CONSUMOS cons\r\n" + 
					"INNER JOIN\r\n" + 
					"HABITACIONES hab\r\n" + 
					"ON hab.ID = cons.ID_HABITACION\r\n" + 
					"WHERE cons.FECHA < SYSTIMESTAMP AND \r\n" + 
					"cons.FECHA > " + difference + " AND\r\n" + 
					"TIPO = " + id + "\r\n" + 
					"GROUP BY ROUND(FECHA,'DDD')\r\n" + 
					"ORDER BY COUNT(ROUND(FECHA,'DDD')) DESC, ROUND(FECHA,'DDD')";
		else
			command = "SELECT COUNT(ROUND(FECHA,'DDD')) NUM_CONSUMOS,ROUND(FECHA,'DDD') FECHA_CONSUMO\r\n" + 
					"FROM CONSUMOS cons\r\n" + 
					"WHERE cons.FECHA < SYSTIMESTAMP AND\r\n" + 
					"cons.FECHA > " + difference + " AND\r\n" + 
					tipoServicio + " = " + id + "\r\n" + 
					"GROUP BY ROUND(FECHA,'DDD')\r\n" + 
					"ORDER BY COUNT(FECHA) DESC";
		Query q = pm.newQuery(SQL, command);
		q.setResultClass(AnalisisFechasDemanda.class);
		return (List<AnalisisFechasDemanda>) q.executeList();
	}
	
	public List<BuenosClientes> buenosClientes(PersistenceManager pm)
	{
		String command = "SELECT NOMBRE, TIPO_DOC, DOC, DIAS_ESTADIA, GASTOS_TOTALES FROM (\r\n" + 
				"SELECT SUM(ROUND(FECHA_SALIDA,'DDD') - ROUND(FECHA_ENTRADA,'DDD')) DIAS_ESTADIA,NOMBRE,TIP_RES TIPO_DOC,DOC_RES DOCUMENTO FROM\r\n" + 
				"(SELECT FECHA_ENTRADA,FECHA_SALIDA,TIPO_DOCUMENTO TIP_RES,DOCUMENTO DOC_RES\r\n" + 
				"FROM RESERVAS reser\r\n" + 
				"WHERE FECHA_SALIDA < SYSTIMESTAMP AND\r\n" + 
				"FECHA_SALIDA > FECHA_ENTRADA)\r\n" + 
				"INNER JOIN \r\n" + 
				"(SELECT NOMBRE,TIPO_DOCUMENTO TIP_USUR,DOCUMENTO DOC_USUR FROM USUARIOS usur)\r\n" + 
				"ON TIP_RES = TIP_USUR AND\r\n" + 
				"DOC_RES = DOC_USUR\r\n" + 
				"GROUP BY NOMBRE,TIP_RES,DOC_RES)\r\n" + 
				"INNER JOIN (\r\n" + 
				"SELECT SUM(COSTO) GASTOS_TOTALES,TIPO_DOCUMENTO TIP_DOC,DOCUMENTO DOC FROM(\r\n" + 
				"SELECT * FROM (\r\n" + 
				"SELECT ID,FECHA, COSTO, ID_HABITACION HAB_CONS\r\n" + 
				"FROM CONSUMOS)\r\n" + 
				"INNER JOIN\r\n" + 
				"(SELECT FECHA_ENTRADA,FECHA_SALIDA,TIPO_DOCUMENTO,DOCUMENTO,HABITACION_ID HAB_RESER\r\n" + 
				"FROM RESERVAS\r\n" + 
				"WHERE FECHA_SALIDA < SYSTIMESTAMP AND\r\n" + 
				"FECHA_SALIDA > FECHA_ENTRADA)\r\n" + 
				"ON FECHA <= FECHA_SALIDA AND\r\n" + 
				"FECHA >= FECHA_ENTRADA AND\r\n" + 
				"HAB_CONS = HAB_RESER)\r\n" + 
				"GROUP BY TIPO_DOCUMENTO,DOCUMENTO)\r\n" + 
				"ON TIPO_DOC = TIP_DOC AND DOCUMENTO = DOC\r\n" + 
				"WHERE DIAS_ESTADIA >= 14 OR GASTOS_TOTALES >= 15000000";
		Query q = pm.newQuery(SQL, command);
		q.setResultClass(BuenosClientes.class);
		return (List<BuenosClientes>) q.executeList();
	}
	
	/* ****************************************************************
	 * 			Métodos auxiliares
	 *****************************************************************/
	private String generateDifference(UnidadTiempo unit, int amount)
	{
		String text = null;
		
		switch(unit)
		{
			case DIA:
				text = "SYSTIMESTAMP - " + amount;
				break;
			case SEMANA:
				text = "SYSTIMESTAMP - " + amount*8;
				break;
			case MES:
				text = "add_months(SYSTIMESTAMP, -" + amount + ")";
				break;
			case ANIO:
				text = "add_months(SYSTIMESTAMP, -" + amount*12 + ")";
				break;
		}
		
		return text;
	}
}
