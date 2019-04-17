package main.java.hotelAndes.negocio;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import main.java.hotelAndes.persistencia.PersistenciaHotelAndes;
import main.java.hotelAndes.persistencia.SQLConsultas.UnidadTiempo;

public class HotelAndes
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(HotelAndes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaHotelAndes pp;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public HotelAndes()
	{
		pp = PersistenciaHotelAndes.getInstance();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public HotelAndes(JsonObject tableConfig)
	{
		pp = PersistenciaHotelAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia();
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los TIPOS DE BEBIDA
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un tipo de bebida 
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public TipoHabitacion adicionarTipoHabitacion(String nombre, String descripcion)
	{
        log.info ("Adicionando Tipo de habitacion con nombre " + nombre + " y descripcion " + descripcion);
        TipoHabitacion tipoHabitacion = pp.adicionarTipoHabitacion(nombre, descripcion);		
        log.info ("Adicionando Tipo de habitacion: " + tipoHabitacion);
        return tipoHabitacion;
	}
	
	public List<VOTipoHabitacion> darVOTiposBebida ()
	{
		log.info ("Generando los VO de Tipos de habitacion");        
        List<VOTipoHabitacion> voTipos = new LinkedList<VOTipoHabitacion> ();
        for (TipoHabitacion tb : pp.darTiposHabitacion())
        {
        	voTipos.add (tb);
        }
        log.info ("Generando los VO de Tipos de habitacion: " + voTipos.size() + " existentes");
        return voTipos;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los requerimientos de consulta
	 *****************************************************************/
	public List<DineroRecolectadoPorHabitacion> dineroRecolectadoPorHabitacion(String fechaMinima, String fechaMaxima)
	{
		log.info ("Consultando el dinero recolectado por cada habitacion entre " + fechaMinima + " y " + fechaMaxima);
		List<DineroRecolectadoPorHabitacion> lista = pp.dineroRecolectadoPorHabitacion(fechaMinima, fechaMaxima);		
        log.info ("Realizando la consulta: " + lista);
        return lista;
	}
	
	public List<ServiciosMasPopulares> serviciosMasPopulares()
	{
		log.info ("Consultando los 20 servicios mas populares");
		List<ServiciosMasPopulares> lista = pp.serviciosMasPopulares();		
        log.info ("Realizando la consulta: " + lista);
        return lista;
	}
	
	public List<OcupacionHabitaciones> ocupacionHabitaciones()
	{
		log.info ("Consultando el indice de ocupacion de las habitaciones");
		List<OcupacionHabitaciones> lista = pp.ocupacionHabitaciones();		
        log.info ("Realizando la consulta: " + lista);
        return lista;
	}
	
	public List<ConsumosUsuarios> consumosUsuarios(String tipoDoc, String doc)
	{
		log.info ("Consultando los consumos de un usuario con tipo de documento: " + tipoDoc + " y documento: " + doc);
		List<ConsumosUsuarios> lista = pp.consumosUsuarios(tipoDoc, doc);		
        log.info ("Realizando la consulta: " + lista);
        return lista;
	}
	
	public List<AnalisisFechasIngresos> analisisFechasIngresos(boolean porTipoDeHabitacion, UnidadTiempo unit, int amount, String id, String tipoServicio)
	{
		String por = null;
        if(porTipoDeHabitacion)
        	por = "por tipo de habitacion";
        else
        	por = "por tipo de servicio";
        
		log.info ("Consultando las fechas de mayores ingresos " + por + ": " + amount + " " + unit.toString());
		List<AnalisisFechasIngresos> lista = pp.analisisFechasIngresos(porTipoDeHabitacion, unit, amount, id, tipoServicio);		
        log.info ("Realizando la consulta: " + lista);
        return lista;
	}
	
	public List<AnalisisFechasDemanda> analisisFechasDemanda(boolean porTipoDeHabitacion, UnidadTiempo unit, int amount, String id, String tipoServicio)
	{
		String por = null;
        if(porTipoDeHabitacion)
        	por = "por tipo de habitacion";
        else
        	por = "por tipo de servicio";
        
		log.info ("Consultando las fechas de mayor demanda " + por + ": " + amount + " " + unit.toString());
		List<AnalisisFechasDemanda> lista = pp.analisisFechasDemanda(porTipoDeHabitacion, unit, amount, id, tipoServicio);		
        log.info ("Realizando la consulta: " + lista);
        return lista;
	}
	
	public List<BuenosClientes> buenosClientes()
	{
		log.info ("Consultando los buenos clientes");
		List<BuenosClientes> lista = pp.buenosClientes();		
        log.info ("Realizando la consulta: " + lista);
        return lista;
	}
	
	/* ****************************************************************
	 * 			Métodos para administración
	 *****************************************************************/

	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarHotelAndes ()
	{
        log.info ("Limpiando la BD de Parranderos");
        //long [] borrrados = pp.limpiarParranderos();	
        log.info ("Limpiando la BD de Parranderos: Listo!");
        return null;
	}
}
